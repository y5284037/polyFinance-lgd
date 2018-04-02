package com.ptteng.polyFinance.lgd.controller;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.common.dao.util.SQLUtil;
import com.ptteng.polyFinance.lgd.model.Suggestion;
import com.ptteng.polyFinance.lgd.service.SuggestionService;
import com.ptteng.polyFinance.lgd.utils.DynamicUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Suggestion  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class SuggestionController {
    private static final Log log = LogFactory.getLog(SuggestionController.class);
    
    @Autowired
    private SuggestionService suggestionService;
    
    
    /**
     * 后台：查看建议详情
     *
     * @param model
     * @param id    建议id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/suggestion/{id}", method = RequestMethod.GET)
    public String getSuggestionJson(ModelMap model, @PathVariable Long id) throws Exception {
        
        log.info("get data : id= " + id);
        try {
            Suggestion suggestion = suggestionService.getObjectById(id);
            log.info("get suggestion data is " + suggestion);
            
            model.addAttribute("code", 0);
            
            model.addAttribute("suggestion", suggestion);
            
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get suggestion error,id is  " + id);
            model.addAttribute("code", -100);
        }
        
        return "/polyFinance-lgd-server/suggestion/json/suggestionDetailJson";
    }
    
    /**
     * 后台：删除建议
     *
     * @param id 用户id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/suggestion/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteSuggestionJson(@PathVariable Long id) throws Exception {
        JSONObject a = new JSONObject();
        log.info("delete suggestion : id= " + id);
        try {
            suggestionService.delete(id);
            
            log.info("delete suggestion success");
            a.put("code", 0);
            a.put("message", "success");
            
            
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("delete suggestion error,id is  " + id);
            a.put("code", -100);
            a.put("message", "Server has something wrong");
        }
        return a.toString();
    }
    
    /**
     * 后台：查询意见列表
     *
     * @param model
     * @param phone           用户手机号
     * @param name            用户名字
     * @param submitTimestart 提交时间起
     * @param submitTimeEnd   提交时间止
     * @param email           用户邮箱
     * @param page            页数
     * @param size            每页个数
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/suggestion/list", method = RequestMethod.GET)
    public String getMultiSuggestionJson(ModelMap model, String phone, String name, Long submitTimestart, Long submitTimeEnd, String email, Integer page, Integer size)
            throws Exception {
        if (page == null) {
            page = 1;
        }
        if (size == null) {
            size = 10;
        }
        int start = (page - 1) * size;
        if (start < 0) {
            start = 0;
        }
        Map<String, Object> param = DynamicUtil.getSuggestionList(phone, name, submitTimestart, submitTimeEnd, email);
        log.info("DynamicCondition SQL ======> getSuggestionListsql " + SQLUtil.convert2Sql(param, start, size));
        
        try {
            List<Long> idList = suggestionService.getIdsByDynamicCondition(Suggestion.class, param, start, size);
            List<Suggestion> suggestionList = suggestionService.getObjectsByIds(idList);
            log.info("get  suggestion data is " + suggestionList);
            
            model.addAttribute("code", 0);
            
            Integer total = suggestionService.getIdsByDynamicCondition(Suggestion.class, param, 0, Integer.MAX_VALUE).size();
            model.addAttribute("total", total);
            
            model.addAttribute("suggestionList", suggestionList);
            
        } catch (Throwable t) {
            log.error(t.getMessage());
            log.error("get suggestion error,id is  ");
            model.addAttribute("code", -100);
        }
        
        return "/polyFinance-lgd-server/suggestion/json/suggestionListJson";
    }
    
    
}

