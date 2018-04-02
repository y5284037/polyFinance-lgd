package com.ptteng.polyFinance.lgd.controller;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.polyFinance.lgd.model.Suggestion;
import com.ptteng.polyFinance.lgd.service.SuggestionService;
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
     * 前台：用户提交建议
     *
     * @param model
     * @param suggestion 建议的内容
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/suggestion", method = RequestMethod.POST)
    public String addSuggestionJson(ModelMap model, Suggestion suggestion) throws Exception {
        
        log.info("insert suggestion : suggestion= " + suggestion);
        
        try {
            suggestion.setId(null);
            
            suggestionService.insert(suggestion);
            
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add suggestion error ");
            model.addAttribute("code", -100);
        }
        
        return "polyFinance-lgd-server/suggestion/json/suggestionDetailJson";
    }
    
    @RequestMapping(value = "/test", method = RequestMethod.PUT)
    @ResponseBody
    public String updateaaa() {
        JSONObject a = new JSONObject();
        a.put("message", "成功");
        return a.toString();
    }
    
}

