package com.ptteng.polyFinance.lgd.controller;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.polyFinance.lgd.model.Module;
import com.ptteng.polyFinance.lgd.service.ModuleService;
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
 * Module  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class ModuleController {
    private static final Log log = LogFactory.getLog(ModuleController.class);
    
    @Autowired
    private ModuleService moduleService;
    
    /**
     * 后台：查询模块详情
     *
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/module/{id}", method = RequestMethod.GET)
    public String getModuleJson(ModelMap model, @PathVariable Long id)
            throws Exception {
        
        log.info("get data : id= " + id);
        try {
            Module module = moduleService.getObjectById(id);
            log.info("get module data is " + module);
            
            model.addAttribute("code", 0);
            
            model.addAttribute("module", module);
            
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get module error,id is  " + id);
            model.addAttribute("code", -100);
        }
        
        return "/polyFinance-lgd-server/module/json/moduleDetailJson";
    }
    
    
    /**
     * 后台：修改模块
     *
     * @param module
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/module/{id}", method = RequestMethod.PUT, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String updateModuleJson(@PathVariable("id") Long id, Module module) throws Exception {
        
        log.info("update module : module= " + module);
        JSONObject a = new JSONObject();
        try {
            module.setId(id);
            moduleService.update(module);
            
            a.put("code", 0);
            a.put("message", "success");
            a.put("data", module);
            
            
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("update module error,id is  " + module.getId());
            a.put("code", -100);
            a.put("message", "Server has something wrong");
            
        }
        return a.toString();
    }
    
    /**
     * 后台：新增模块
     *
     * @param model
     * @param module
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/module", method = RequestMethod.POST)
    public String addModuleJson(ModelMap model, Module module) throws Exception {
        
        log.info("insert module : module= " + module);
        
        try {
            module.setId(null);
            
            moduleService.insert(module);
            
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add module error ");
            model.addAttribute("code", -6002);
        }
        
        return "/polyFinance-lgd-server/module/json/moduleDetailJson";
    }
    
    /**
     * 后台：删除模块
     *
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/module/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteModuleJson(ModelMap model, @PathVariable Long id) throws Exception {
        JSONObject a = new JSONObject();
        log.info("delete module : id= " + id);
        try {
            moduleService.delete(id);
            
            log.info("add module success");
            a.put("code", 0);
            a.put("message", "success");
            
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("delete module error,id is  " + id);
            a.put("code", -100);
            a.put("message", "Server has something wrong");
        }
        
        return a.toString();
    }
    
    
    /**
     * 后台：查询模块列表
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/module/list", method = RequestMethod.GET)
    public String getMultiModuleJson(ModelMap model) throws Exception {
        
        try {
            
            List<Long> idList = moduleService.getModuleIds(0, Integer.MAX_VALUE);
            
            List<Module> moduleList = moduleService.getObjectsByIds(idList);
            
            log.info("get  module data is " + moduleList);
            
            model.addAttribute("code", 0);
            model.addAttribute("total", moduleList.size());
            
            model.addAttribute("moduleList", moduleList);
            
        } catch (Throwable t) {
            
            log.error(t.getMessage());
            log.error("get module error");
            model.addAttribute("code", -100);
        }
        return "/polyFinance-lgd-server/module/json/moduleListJson";
    }
    
    
}

