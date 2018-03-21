package com.ptteng.polyFinance.lgd.controller;

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
 * 
 */
@Controller
public class ModuleController {
	private static final Log log = LogFactory.getLog(ModuleController.class);

	@Autowired
	private ModuleService moduleService;






    /**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */

	@RequestMapping(value = "/c/module", method = RequestMethod.GET)
	public String getmoduleList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		
		
		log.info("/module  to /module/view/moduleList");

		return "/polyFinance-lgd-server/module/view/moduleList";
	}
    
    

    
	
	@RequestMapping(value = "/c/module/{id}", method = RequestMethod.GET)
	public String getModule(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("/module/" + id + "  to /module/view/moduleDeail");
		if(null != id){
			model.addAttribute("id", id);
		}else{
			model.addAttribute("id", 0);
		}

		return "/polyFinance-lgd-server/module/view/moduleDetail";
	}
	
	
	
	    
	

	@RequestMapping(value = "/a/module/{id}", method = RequestMethod.GET)
	public String getModuleJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
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
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/module/json/moduleDetailJson";
	}

	@RequestMapping(value = "/a/module/{id}", method = RequestMethod.PUT)
	public String updateModuleJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Module module) throws Exception {
		
		log.info("update module : module= " + module);
		
		try {
			
			moduleService.update(module);

			model.addAttribute("code", 0);

			model.addAttribute("module", module);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update module error,id is  " + module.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/module", method = RequestMethod.POST)
	public String addModuleJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Module module) throws Exception {
		
		log.info("update module : module= " + module);
		
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

		return "/data/json";
	}

	@RequestMapping(value = "/a/module/{id}", method = RequestMethod.DELETE)
	public String deleteModuleJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete module : id= " + id);
		try {
			moduleService.delete(id);

			log.info("add module success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete module error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/module", method = RequestMethod.GET)
	public String getMultiModuleJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<Module> moduleList = moduleService.getObjectsByIds(idList);
			log.info("get  module data is " + moduleList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",moduleList.size());

			model.addAttribute("moduleList", moduleList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get module error,id is  " + idList);
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/module/json/moduleListJson";
	}
	
	
	
	
	
}

