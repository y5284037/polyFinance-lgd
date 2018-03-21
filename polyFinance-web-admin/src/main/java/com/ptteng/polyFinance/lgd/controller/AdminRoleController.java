package com.ptteng.polyFinance.lgd.controller;

import com.ptteng.polyFinance.lgd.model.AdminRole;
import com.ptteng.polyFinance.lgd.service.AdminRoleService;
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
 * AdminRole  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class AdminRoleController {
	private static final Log log = LogFactory.getLog(AdminRoleController.class);

	@Autowired
	private AdminRoleService adminRoleService;






    /**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */

	@RequestMapping(value = "/c/adminRole", method = RequestMethod.GET)
	public String getadminRoleList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		
		
		log.info("/adminRole  to /adminRole/view/adminRoleList");

		return "/polyFinance-lgd-server/adminRole/view/adminRoleList";
	}
    
    

    
	
	@RequestMapping(value = "/c/adminRole/{id}", method = RequestMethod.GET)
	public String getAdminRole(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("/adminRole/" + id + "  to /adminRole/view/adminRoleDeail");
		if(null != id){
			model.addAttribute("id", id);
		}else{
			model.addAttribute("id", 0);
		}

		return "/polyFinance-lgd-server/adminRole/view/adminRoleDetail";
	}
	
	
	
	    
	

	@RequestMapping(value = "/a/adminRole/{id}", method = RequestMethod.GET)
	public String getAdminRoleJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			AdminRole adminRole = adminRoleService.getObjectById(id);
			log.info("get adminRole data is " + adminRole);

			model.addAttribute("code", 0);

			model.addAttribute("adminRole", adminRole);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get adminRole error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/adminRole/json/adminRoleDetailJson";
	}

	@RequestMapping(value = "/a/adminRole/{id}", method = RequestMethod.PUT)
	public String updateAdminRoleJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, AdminRole adminRole) throws Exception {
		
		log.info("update adminRole : adminRole= " + adminRole);
		
		try {
			
			adminRoleService.update(adminRole);

			model.addAttribute("code", 0);

			model.addAttribute("adminRole", adminRole);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update adminRole error,id is  " + adminRole.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/adminRole", method = RequestMethod.POST)
	public String addAdminRoleJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, AdminRole adminRole) throws Exception {
		
		log.info("update adminRole : adminRole= " + adminRole);
		
		try { 
			adminRole.setId(null);

			adminRoleService.insert(adminRole);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add adminRole error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/adminRole/{id}", method = RequestMethod.DELETE)
	public String deleteAdminRoleJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete adminRole : id= " + id);
		try {
			adminRoleService.delete(id);

			log.info("add adminRole success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete adminRole error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/adminRole", method = RequestMethod.GET)
	public String getMultiAdminRoleJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<AdminRole> adminRoleList = adminRoleService.getObjectsByIds(idList);
			log.info("get  adminRole data is " + adminRoleList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",adminRoleList.size());

			model.addAttribute("adminRoleList", adminRoleList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get adminRole error,id is  " + idList);
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/adminRole/json/adminRoleListJson";
	}
	
	
	
	
	
}

