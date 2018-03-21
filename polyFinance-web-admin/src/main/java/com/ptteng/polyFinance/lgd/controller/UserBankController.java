package com.ptteng.polyFinance.lgd.controller;

import com.ptteng.polyFinance.lgd.model.UserBank;
import com.ptteng.polyFinance.lgd.service.UserBankService;
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
 * UserBank  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class UserBankController {
	private static final Log log = LogFactory.getLog(UserBankController.class);

	@Autowired
	private UserBankService userBankService;






    /**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */

	@RequestMapping(value = "/c/userBank", method = RequestMethod.GET)
	public String getuserBankList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		
		
		log.info("/userBank  to /userBank/view/userBankList");

		return "/polyFinance-lgd-server/userBank/view/userBankList";
	}
    
    

    		
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 
	
		 @RequestMapping(value = "/c/userBank1 ", method = RequestMethod.GET)
	public String getUserBankIdsByUserIdList1(HttpServletRequest request,
			HttpServletResponse response, ModelMap model,Long userId) throws Exception {

		log.info("/userBank  to /userBank/view/userBankList");

		return "/polyFinance-lgd-server/userBank/view/userBankList";
	}

	
	
	
	
	
	
	@RequestMapping(value = "/c/userBank/{id}", method = RequestMethod.GET)
	public String getUserBank(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("/userBank/" + id + "  to /userBank/view/userBankDeail");
		if(null != id){
			model.addAttribute("id", id);
		}else{
			model.addAttribute("id", 0);
		}

		return "/polyFinance-lgd-server/userBank/view/userBankDetail";
	}
	
	
	
	    		
			
    /**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	
		@RequestMapping(value = "/a/userBank1 ", method = RequestMethod.GET)
	public String getUserBankIdsByUserIdJsonList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Integer page,
			Integer size,Long userId) throws Exception {


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

			List<Long> ids= userBankService.getUserBankIdsByUserId(userId,start,size);
		log.info("get countUserBankIdsByUserId size is " + ids.size());

			List<UserBank> userBankList = userBankService.getObjectsByIds(ids);
			log.info("get userBank data is " + userBankList.size());

			Integer total = userBankService. countUserBankIdsByUserId(userId);
			log.info("get userBank count is " + total);

			model.addAttribute("code", 0);
			model.addAttribute("page", page);
			model.addAttribute("size", size);
			
			model.addAttribute("total", total);

			model.addAttribute("userBankList", userBankList);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get userBank list error,page is  " + start + " , size "
					+ size);
			// for test
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/userBank/json/userBankListJson";
	}

	
	
		
	
	

	@RequestMapping(value = "/a/userBank/{id}", method = RequestMethod.GET)
	public String getUserBankJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			UserBank userBank = userBankService.getObjectById(id);
			log.info("get userBank data is " + userBank);

			model.addAttribute("code", 0);

			model.addAttribute("userBank", userBank);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get userBank error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/userBank/json/userBankDetailJson";
	}

	@RequestMapping(value = "/a/userBank/{id}", method = RequestMethod.PUT)
	public String updateUserBankJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, UserBank userBank) throws Exception {
		
		log.info("update userBank : userBank= " + userBank);
		
		try {
			
			userBankService.update(userBank);

			model.addAttribute("code", 0);

			model.addAttribute("userBank", userBank);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update userBank error,id is  " + userBank.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/userBank", method = RequestMethod.POST)
	public String addUserBankJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, UserBank userBank) throws Exception {
		
		log.info("update userBank : userBank= " + userBank);
		
		try { 
			userBank.setId(null);

			userBankService.insert(userBank);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add userBank error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/userBank/{id}", method = RequestMethod.DELETE)
	public String deleteUserBankJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete userBank : id= " + id);
		try {
			userBankService.delete(id);

			log.info("add userBank success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete userBank error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/userBank", method = RequestMethod.GET)
	public String getMultiUserBankJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<UserBank> userBankList = userBankService.getObjectsByIds(idList);
			log.info("get  userBank data is " + userBankList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",userBankList.size());

			model.addAttribute("userBankList", userBankList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get userBank error,id is  " + idList);
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/userBank/json/userBankListJson";
	}
	
	
	
	
	
}

