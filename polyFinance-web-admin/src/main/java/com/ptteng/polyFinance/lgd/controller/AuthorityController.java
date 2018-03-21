package com.ptteng.polyFinance.lgd.controller;

import com.ptteng.polyFinance.lgd.model.Authority;
import com.ptteng.polyFinance.lgd.service.AuthorityService;
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
 * Authority  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class AuthorityController {
	private static final Log log = LogFactory.getLog(AuthorityController.class);

	@Autowired
	private AuthorityService authorityService;






    /**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */

	@RequestMapping(value = "/c/authority", method = RequestMethod.GET)
	public String getauthorityList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		
		
		log.info("/authority  to /authority/view/authorityList");

		return "/polyFinance-lgd-server/authority/view/authorityList";
	}
    
    

    		
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 
	
		 @RequestMapping(value = "/c/authority1 ", method = RequestMethod.GET)
	public String getAuthorityIdsByAdminRoleIdList1(HttpServletRequest request,
			HttpServletResponse response, ModelMap model,Long adminRoleId) throws Exception {

		log.info("/authority  to /authority/view/authorityList");

		return "/polyFinance-lgd-server/authority/view/authorityList";
	}

	
	
	
	
	
	
	@RequestMapping(value = "/c/authority/{id}", method = RequestMethod.GET)
	public String getAuthority(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("/authority/" + id + "  to /authority/view/authorityDeail");
		if(null != id){
			model.addAttribute("id", id);
		}else{
			model.addAttribute("id", 0);
		}

		return "/polyFinance-lgd-server/authority/view/authorityDetail";
	}
	
	
	
	    		
			
    /**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	
		@RequestMapping(value = "/a/authority1 ", method = RequestMethod.GET)
	public String getAuthorityIdsByAdminRoleIdJsonList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Integer page,
			Integer size,Long adminRoleId) throws Exception {


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

		log.info("pageList : page= " + start + " , size=" + size);

		try {

			List<Long> ids= authorityService.getAuthorityIdsByAdminRoleId(adminRoleId,start,size);
		log.info("get countAuthorityIdsByAdminRoleId size is " + ids.size());

			List<Authority> authorityList = authorityService.getObjectsByIds(ids);
			log.info("get authority data is " + authorityList.size());

			Integer total = authorityService. countAuthorityIdsByAdminRoleId(adminRoleId);
			log.info("get authority count is " + total);

			model.addAttribute("code", 0);
			model.addAttribute("page", page);
			model.addAttribute("size", size);
			
			model.addAttribute("total", total);

			model.addAttribute("authorityList", authorityList);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get authority list error,page is  " + start + " , size "
					+ size);
			// for test
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/authority/json/authorityListJson";
	}

	
	
		
	
	

	@RequestMapping(value = "/a/authority/{id}", method = RequestMethod.GET)
	public String getAuthorityJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			Authority authority = authorityService.getObjectById(id);
			log.info("get authority data is " + authority);

			model.addAttribute("code", 0);

			model.addAttribute("authority", authority);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get authority error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/authority/json/authorityDetailJson";
	}

	@RequestMapping(value = "/a/authority/{id}", method = RequestMethod.PUT)
	public String updateAuthorityJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Authority authority) throws Exception {
		
		log.info("update authority : authority= " + authority);
		
		try {
			
			authorityService.update(authority);

			model.addAttribute("code", 0);

			model.addAttribute("authority", authority);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update authority error,id is  " + authority.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/authority", method = RequestMethod.POST)
	public String addAuthorityJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Authority authority) throws Exception {
		
		log.info("update authority : authority= " + authority);
		
		try { 
			authority.setId(null);

			authorityService.insert(authority);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add authority error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/authority/{id}", method = RequestMethod.DELETE)
	public String deleteAuthorityJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete authority : id= " + id);
		try {
			authorityService.delete(id);

			log.info("add authority success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete authority error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/authority", method = RequestMethod.GET)
	public String getMultiAuthorityJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<Authority> authorityList = authorityService.getObjectsByIds(idList);
			log.info("get  authority data is " + authorityList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",authorityList.size());

			model.addAttribute("authorityList", authorityList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get authority error,id is  " + idList);
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/authority/json/authorityListJson";
	}
	
	
	
	
	
}

