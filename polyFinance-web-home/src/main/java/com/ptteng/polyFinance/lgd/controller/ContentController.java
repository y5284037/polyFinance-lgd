package com.ptteng.polyFinance.lgd.controller;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.Content;
import com.ptteng.polyFinance.lgd.service.ContentService;
import com.ptteng.polyFinance.lgd.utils.CommonUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

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
    
    
    /**
     * 查询内容帮助列表
     * @param model
     * @param status 消息状态
     * @param type 消息类型
     * @return
     */
    @RequestMapping(value = "/a/content/list", method = RequestMethod.GET)
    public String getContentList(ModelMap model, Integer status,Integer type) {
        
        if(CommonUtil.isEmpty(type,status)){
            model.addAttribute("code", -200);
            return "/polyFinance-lgd-server/content/json/contentListJson";
        }
    
        try {
            List<Long> ids = contentService.getContentIdsByTypeAndStatus(type, status);
            model.addAttribute("contentList", contentService.getObjectsByIds(ids));
            model.addAttribute("code", 0);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return "/polyFinance-lgd-server/content/json/contentListJson";
    }
    
}

