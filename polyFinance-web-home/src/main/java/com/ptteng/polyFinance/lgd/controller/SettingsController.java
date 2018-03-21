package com.ptteng.polyFinance.lgd.controller;

import com.ptteng.polyFinance.lgd.model.Settings;
import com.ptteng.polyFinance.lgd.service.SettingsService;
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
 * Settings  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class SettingsController {
	private static final Log log = LogFactory.getLog(SettingsController.class);

	@Autowired
	private SettingsService settingsService;






    /**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */

	@RequestMapping(value = "/c/settings", method = RequestMethod.GET)
	public String getsettingsList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		
		
		log.info("/settings  to /settings/view/settingsList");

		return "/polyFinance-lgd-server/settings/view/settingsList";
	}
    
    

    
	
	@RequestMapping(value = "/c/settings/{id}", method = RequestMethod.GET)
	public String getSettings(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("/settings/" + id + "  to /settings/view/settingsDeail");
		if(null != id){
			model.addAttribute("id", id);
		}else{
			model.addAttribute("id", 0);
		}

		return "/polyFinance-lgd-server/settings/view/settingsDetail";
	}
	
	
	
	    
	

	@RequestMapping(value = "/a/settings/{id}", method = RequestMethod.GET)
	public String getSettingsJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			Settings settings = settingsService.getObjectById(id);
			log.info("get settings data is " + settings);

			model.addAttribute("code", 0);

			model.addAttribute("settings", settings);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get settings error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/settings/json/settingsDetailJson";
	}

	@RequestMapping(value = "/a/settings/{id}", method = RequestMethod.PUT)
	public String updateSettingsJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Settings settings) throws Exception {
		
		log.info("update settings : settings= " + settings);
		
		try {
			
			settingsService.update(settings);

			model.addAttribute("code", 0);

			model.addAttribute("settings", settings);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update settings error,id is  " + settings.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/settings", method = RequestMethod.POST)
	public String addSettingsJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Settings settings) throws Exception {
		
		log.info("update settings : settings= " + settings);
		
		try { 
			settings.setId(null);

			settingsService.insert(settings);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add settings error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/settings/{id}", method = RequestMethod.DELETE)
	public String deleteSettingsJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete settings : id= " + id);
		try {
			settingsService.delete(id);

			log.info("add settings success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete settings error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/settings", method = RequestMethod.GET)
	public String getMultiSettingsJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<Settings> settingsList = settingsService.getObjectsByIds(idList);
			log.info("get  settings data is " + settingsList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",settingsList.size());

			model.addAttribute("settingsList", settingsList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get settings error,id is  " + idList);
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/settings/json/settingsListJson";
	}
	
	
	
	
	
}

