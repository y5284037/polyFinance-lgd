package com.ptteng.polyFinance.lgd.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ptteng.polyFinance.lgd.model.SysMessage;
import com.ptteng.polyFinance.lgd.service.SysMessageService;
import com.ptteng.polyFinance.lgd.utils.CommonUtil;
import com.ptteng.polyFinance.lgd.utils.DynamicUtil;
import com.ptteng.polyFinance.lgd.utils.FilesUtil;
import com.ptteng.polyFinance.lgd.utils.JUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * SysMessage  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class SysMessageController {
    private static final Log log = LogFactory.getLog(SysMessageController.class);
    
    @Autowired
    private SysMessageService sysMessageService;
    
    /**
     * 查询系统消息列表
     * @param title 标题
     * @param updateBy 更新者
     * @param updateAtStart 更新起限
     * @param updateAtEnd 更新终限
     * @param status 状态
     * @param sendTo 发送给谁
     * @param page 当前页数
     * @param size 每页容量
     * @return
     */
    @RequestMapping(value = "/a/u/sysMessage/list", method = RequestMethod.GET)
    public @ResponseBody
    JSON getsysList(String title, String updateBy, Long updateAtStart, Long updateAtEnd, Integer status, Integer sendTo, Integer page, Integer size) {
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
        JSONObject json;
        Map<String, Object> map = DynamicUtil.getSysMessageSql(title, updateBy, updateAtStart, updateAtEnd, status, sendTo);
        try {
            List<Long> ids = sysMessageService.getIdsByDynamicCondition(SysMessage.class, map, start, size);
            List<SysMessage> list = sysMessageService.getObjectsByIds(ids);
            int total = sysMessageService.getIdsByDynamicCondition(SysMessage.class, map, start, size).size();
            json = JUtils.getJSON(0, size, total, "data", list);
            
        } catch (Throwable e) {
            json = JUtils.getJSON(-100);
            e.printStackTrace();
        }
        return json;
    }
    
    /**
     * 获取系统消息详情
     * @param id 内容ID
     * @return
     */
    @RequestMapping(value = "/a/u/sysMessage", method = RequestMethod.GET)
    public @ResponseBody
    JSON getSysMessage(Long id) {
        JSON json;
        if (CommonUtil.isEmpty(id)) {
            return JUtils.getJSON(-200);
        }
        try {
            SysMessage sysMessage = sysMessageService.getObjectById(id);
            String messagePicUrl = FilesUtil.getUrl(sysMessage.getMessagePic());
            json = JUtils.getJSON(0, "messagePicUrl", messagePicUrl, "data", sysMessage);
        } catch (Throwable e) {
            json = JUtils.getJSON(-100);
            e.printStackTrace();
        }
        return json;
    }
    
    /**
     * 新增系统消息
     * @param sysMessage 页面接收的
     * @param messagePicFile 上传的文件
     * @return
     */
    @RequestMapping(value = "/a/u/sysMessage", method = RequestMethod.POST)
    public @ResponseBody
    JSON addSysMessage(SysMessage sysMessage, MultipartFile messagePicFile) {
        JSON json;
        Long time = System.currentTimeMillis();
        if (CommonUtil.isEmpty(sysMessage.getTitle(), sysMessage.getSendTo(), sysMessage.getResume(), messagePicFile, sysMessage.getCreateBy())) {
            return JUtils.getJSON(-200);
        }
        if (CommonUtil.isEmpty(sysMessage.getSendTime())) {
            sysMessage.setSendTime(time);
        }
        try {
            sysMessage.setCreateAt(time);
            sysMessage.setUpdateAt(time);
            sysMessage.setUpdateBy(sysMessage.getCreateBy());
            sysMessage.setMessagePic(FilesUtil.upLoadFile(messagePicFile));
            sysMessageService.insert(sysMessage);
            json = JUtils.getJSON(0);
        } catch (Throwable e) {
            json = JUtils.getJSON(-100);
            e.printStackTrace();
        }
        return json;
    }
    
    /**
     * 修改系统消息
     * @param id 系统消息id.
     * @param sysMessage 从页面接收的数据
     * @param messagePicFile 上传的文件
     * @return
     */
    @RequestMapping(value = "/a/u/sysMessage/{id}", method = RequestMethod.POST)
    public @ResponseBody
    JSON updateSysMessage(@PathVariable Long id, SysMessage sysMessage, MultipartFile messagePicFile) {
        JSON json;
        long time = System.currentTimeMillis();
        if (CommonUtil.isEmpty(sysMessage.getTitle(), sysMessage.getSendTo(), sysMessage.getResume(), sysMessage.getUpdateBy())) {
            return JUtils.getJSON(-200);
        }
        try {
            SysMessage sysMessage1 = sysMessageService.getObjectById(id);
            
            if (!CommonUtil.isEmpty(messagePicFile)) {
                FilesUtil.deleteObject(sysMessage1.getMessagePic());
                sysMessage1.setMessagePic(FilesUtil.upLoadFile(messagePicFile));
            }
            
            sysMessage1.setUpdateBy(sysMessage.getUpdateBy());
            sysMessage1.setUpdateAt(time);
            sysMessage1.setResume(sysMessage.getResume());
            sysMessage1.setSendTime(sysMessage.getSendTime());
            sysMessage1.setSendTo(sysMessage.getSendTo());
            sysMessageService.update(sysMessage1);
            json = JUtils.getJSON(0);
        } catch (Throwable e) {
            json = JUtils.getJSON(-100);
            e.printStackTrace();
        }
        return json;
    }
    
    
    /**
     * 更改系统消息状态
     * @param id 系统消息的id
     * @return
     */
    @RequestMapping(value = "/a/u/sysMessage/{id}",method = RequestMethod.PUT)
    public @ResponseBody
    JSON changeSysStatus(@PathVariable Long id){
        JSON json;
        Long time = System.currentTimeMillis();
        if(CommonUtil.isEmpty(id)){
            return JUtils.getJSON(-200);
        }
        try {
            SysMessage sysMessage = sysMessageService.getObjectById(id);
            if (sysMessage.getStatus() == 0) {
                sysMessage.setStatus(1);
                sysMessage.setUpdateAt(time);
                sysMessageService.update(sysMessage);
            } else {
                sysMessage.setStatus(0);
                sysMessage.setUpdateAt(time);
                sysMessageService.update(sysMessage);
            }
            json = JUtils.getJSON(0);
        } catch (Throwable e) {
            json = JUtils.getJSON(-100);
            e.printStackTrace();
        }
        return json;
    }
    
    /**
     * 删除系统消息
     * @param id 系统消息ID
     * @return
     */
    @RequestMapping(value = "/a/u/sysMessage/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    JSON deleteSysMessage(@PathVariable Long id){
        JSON json;
        if(CommonUtil.isEmpty(id)){
            return JUtils.getJSON(-200);
        }
        try {
            sysMessageService.delete(id);
            json = JUtils.getJSON(0);
        } catch (Throwable e) {
            json = JUtils.getJSON(-100);
            e.printStackTrace();
        }
        return json;
    }
}

