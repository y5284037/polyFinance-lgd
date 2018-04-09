package com.ptteng.polyFinance.lgd.controller;

import com.ptteng.polyFinance.lgd.model.Content;
import com.ptteng.polyFinance.lgd.service.ContentService;
import com.ptteng.polyFinance.lgd.utils.CommonUtil;
import com.ptteng.polyFinance.lgd.utils.DynamicUtil;
import com.ptteng.polyFinance.lgd.utils.FilesUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * Content  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class ContentController {
    private static final Log log = LogFactory.getLog(ContentController.class);
    
    @Autowired
    private ContentService contentService;
    
    
    /**内容列表
     * @param model
     * @param title         标题
     * @param type          类型
     * @param status        状态
     * @param updateBy      编辑者
     * @param updateAtStart 编辑时间起限
     * @param updateAtEnd   编辑时间终限
     * @param page          页数
     * @param size          每页数量
     * @return
     */
    @RequestMapping(value = " /a/u/content/list", method = RequestMethod.GET)
    public String getContentList(ModelMap model, String title, String type, String status, String updateBy, String updateAtStart, String updateAtEnd, Integer page, Integer size) {
        if (CommonUtil.isEmpty(page)) {
            page = 1;
        }
        if (CommonUtil.isEmpty(size)) {
            size = 10;
        }
        int start = (page - 1) * size;
        if (start < 0) {
            start = 0;
        }
        
        Map<String, Object> map = DynamicUtil.getContentSql(title, type, status, updateBy, updateAtStart, updateAtEnd);
        try {
            List<Long> ids = contentService.getIdsByDynamicCondition(Content.class, map, start, size);
            List<Content> list = contentService.getObjectsByIds(ids);
            model.addAttribute("contentList", list);
            model.addAttribute("code", 0);
            model.addAttribute("total", contentService.getIdsByDynamicCondition(Content.class, map, 0, Integer.MAX_VALUE).size());
            model.addAttribute("size", size);
        } catch (Throwable e) {
            model.addAttribute("code", -100);
            e.printStackTrace();
        }
        return "polyFinance-lgd-server/content/json/contentListJson";
    }
    
    /**
     * 获取单条内容详情
     *
     * @param modelMap
     * @param id       内容id
     * @return
     */
    @RequestMapping(value = "/a/u/content", method = RequestMethod.GET)
    public String getContent(ModelMap modelMap, Long id) {
        
        if (CommonUtil.isEmpty(id)) {
            modelMap.addAttribute("code", -200);
            return "polyFinance-lgd-server/content/json/contentDetailJson";
        }
        
        try {
            modelMap.addAttribute("content", contentService.getObjectById(id));
            modelMap.addAttribute("code", 0);
        } catch (Throwable e) {
            modelMap.addAttribute("code", -100);
            e.printStackTrace();
        }
        return "polyFinance-lgd-server/content/json/contentDetailJson";
    }
    
    /**
     * 新增内容
     *
     * @param modelMap
     * @param createBy 创建者
     * @param title    标题
     * @param type     类型 0:banner 1:帮助中心 2:关于我们
     * @param coverPic 封面
     * @param pic      内容
     * @param status   状态
     * @return
     */
    @RequestMapping(value = "/a/u/content", method = RequestMethod.POST)
    public String addContent(ModelMap modelMap, String createBy, String title, Integer type, MultipartFile coverPic, MultipartFile pic, Integer status) {
        if (CommonUtil.isEmpty(createBy, title, type, pic)) {
            modelMap.addAttribute("code", -200);
            return "polyFinance-lgd-server/content/json/ContentJson";
        }
        
        if (type == 0) {
            if (CommonUtil.isEmpty(coverPic)) {
                modelMap.addAttribute("code", -200);
                return "polyFinance-lgd-server/content/json/ContentJson";
            }
            Content content = new Content();
            try {
                Long time = System.currentTimeMillis();
                content.setContentCoverPic(FilesUtil.upLoadFile(coverPic));
                content.setContentPic(FilesUtil.upLoadFile(pic));
                content.setTitle(title);
                content.setCreateBy(createBy);
                content.setUpdateBy(createBy);
                content.setType(type);
                content.setStatus(status);
                content.setCreateAt(time);
                content.setUpdateAt(time);
                contentService.insert(content);
                modelMap.addAttribute("code", 0);
            } catch (Throwable e) {
                modelMap.addAttribute("code", -100);
                e.printStackTrace();
            }
        } else {
            Content content = new Content();
            try {
                Long time = System.currentTimeMillis();
                content.setContentPic(FilesUtil.upLoadFile(pic));
                content.setTitle(title);
                content.setCreateBy(createBy);
                content.setUpdateBy(createBy);
                content.setType(type);
                content.setStatus(status);
                content.setCreateAt(time);
                content.setUpdateAt(time);
                contentService.insert(content);
                modelMap.addAttribute("code", 0);
            } catch (Throwable e) {
                modelMap.addAttribute("code", -100);
                e.printStackTrace();
            }
        }
        return "polyFinance-lgd-server/content/json/ContentJson";
    }
    
    
    /**
     * 修改内容接口
     *
     * @param id       需要修改的内容ID
     * @param modelMap
     * @param updateBy 更新者
     * @param title    标题
     * @param type     类型
     * @param coverPic 封面
     * @param pic      内容
     * @param status   状态
     * @return
     */
    @RequestMapping(value = "/a/u/content/{id}", method = RequestMethod.POST)
    public String updateContent(@PathVariable Long id, ModelMap modelMap, String updateBy, String title, Integer type, MultipartFile coverPic, MultipartFile pic, Integer status) {
        if (CommonUtil.isEmpty(id, updateBy, title, type, pic)) {
            modelMap.addAttribute("code", -200);
            return "polyFinance-lgd-server/content/json/ContentJson";
        }
        
        if (type == 0) {
            if (CommonUtil.isEmpty(coverPic)) {
                modelMap.addAttribute("code", -200);
                return "polyFinance-lgd-server/content/json/ContentJson";
            }
            try {
                Content content = contentService.getObjectById(id);
                Long time = System.currentTimeMillis();
                content.setContentCoverPic(FilesUtil.upLoadFile(coverPic));
                content.setContentPic(FilesUtil.upLoadFile(pic));
                content.setTitle(title);
                content.setUpdateBy(updateBy);
                content.setType(type);
                content.setStatus(status);
                content.setUpdateAt(time);
                content.setId(id);
                contentService.update(content);
                modelMap.addAttribute("code", 0);
            } catch (Throwable e) {
                modelMap.addAttribute("code", -100);
                e.printStackTrace();
            }
        } else {
            try {
                Content content = contentService.getObjectById(id);
                Long time = System.currentTimeMillis();
                content.setContentPic(FilesUtil.upLoadFile(pic));
                content.setTitle(title);
                content.setUpdateBy(updateBy);
                content.setType(type);
                content.setStatus(status);
                content.setUpdateAt(time);
                content.setId(id);
                contentService.update(content);
                modelMap.addAttribute("code", 0);
            } catch (Throwable e) {
                modelMap.addAttribute("code", -100);
                e.printStackTrace();
            }
        }
        return "polyFinance-lgd-server/content/json/ContentJson";
    }
    
    /**
     * 修改内容上下线状态
     * @param id 内容ID
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/a/u/content/{id}", method = RequestMethod.PUT)
    public String onContent(@PathVariable Long id, ModelMap modelMap) {
        if (CommonUtil.isEmpty(id)) {
            modelMap.addAttribute("code", -200);
            return "polyFinance-lgd-server/content/json/ContentJson";
        }
        try {
            Content content = contentService.getObjectById(id);
            if (content.getStatus() == 0) {
                content.setStatus(1);
            } else {
                content.setStatus(0);
            }
            contentService.update(content);
            modelMap.addAttribute("code", 0);
        } catch (Throwable e) {
            modelMap.addAttribute("code", -100);
            e.printStackTrace();
        }
        return "polyFinance-lgd-server/content/json/ContentJson";
    }
    
    /**
     * 删除内容
     * @param id 内容ID
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/a/u/content/{id}", method = RequestMethod.DELETE)
    public String delContent(@PathVariable Long id,ModelMap modelMap){
        if(CommonUtil.isEmpty(id)){
            modelMap.addAttribute("code", -200);
            return "polyFinance-lgd-server/content/json/ContentJson";
        }
        try {
            contentService.delete(id);
            modelMap.addAttribute("code", 0);
        } catch (Throwable e) {
            modelMap.addAttribute("code", -100);
            
            e.printStackTrace();
        }
        return "polyFinance-lgd-server/content/json/ContentJson";
    
    }
    
}

