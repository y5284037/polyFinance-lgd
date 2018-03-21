package com.ptteng.polyFinance.lgd.controller;

import com.ptteng.polyFinance.lgd.model.UserMessage;
import com.ptteng.polyFinance.lgd.service.UserMessageService;
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
 * UserMessage  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class UserMessageController {
	private static final Log log = LogFactory.getLog(UserMessageController.class);

	@Autowired
	private UserMessageService userMessageService;






    /**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */

	@RequestMapping(value = "/c/userMessage", method = RequestMethod.GET)
	public String getuserMessageList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		
		
		log.info("/userMessage  to /userMessage/view/userMessageList");

		return "/polyFinance-lgd-server/userMessage/view/userMessageList";
	}
    
    

    		
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 
	
		 @RequestMapping(value = "/c/userMessage1 ", method = RequestMethod.GET)
	public String getUserMessageIdsByUserIdAndMessageReadStatusList1(HttpServletRequest request,
			HttpServletResponse response, ModelMap model,Long userId,Integer messageReadStatus) throws Exception {

		log.info("/userMessage  to /userMessage/view/userMessageList");

		return "/polyFinance-lgd-server/userMessage/view/userMessageList";
	}

	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 
	
		 @RequestMapping(value = "/c/userMessage2 ", method = RequestMethod.GET)
	public String getUserMessageIdsByUserIdList2(HttpServletRequest request,
			HttpServletResponse response, ModelMap model,Long userId) throws Exception {

		log.info("/userMessage  to /userMessage/view/userMessageList");

		return "/polyFinance-lgd-server/userMessage/view/userMessageList";
	}

	
	
	
	
	
	
	@RequestMapping(value = "/c/userMessage/{id}", method = RequestMethod.GET)
	public String getUserMessage(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("/userMessage/" + id + "  to /userMessage/view/userMessageDeail");
		if(null != id){
			model.addAttribute("id", id);
		}else{
			model.addAttribute("id", 0);
		}

		return "/polyFinance-lgd-server/userMessage/view/userMessageDetail";
	}
	
	
	
	    		
			
    /**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	
		@RequestMapping(value = "/a/userMessage1 ", method = RequestMethod.GET)
	public String getUserMessageIdsByUserIdAndMessageReadStatusJsonList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Integer page,
			Integer size,Long userId,Integer messageReadStatus) throws Exception {


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

			List<Long> ids= userMessageService.getUserMessageIdsByUserIdAndMessageReadStatus(userId,messageReadStatus,start,size);
		log.info("get countUserMessageIdsByUserIdAndMessageReadStatus size is " + ids.size());

			List<UserMessage> userMessageList = userMessageService.getObjectsByIds(ids);
			log.info("get userMessage data is " + userMessageList.size());

			Integer total = userMessageService. countUserMessageIdsByUserIdAndMessageReadStatus(userId,messageReadStatus);
			log.info("get userMessage count is " + total);

			model.addAttribute("code", 0);
			model.addAttribute("page", page);
			model.addAttribute("size", size);
			
			model.addAttribute("total", total);

			model.addAttribute("userMessageList", userMessageList);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get userMessage list error,page is  " + start + " , size "
					+ size);
			// for test
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/userMessage/json/userMessageListJson";
	}

	
	
		
			
			
    /**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	
		@RequestMapping(value = "/a/userMessage2 ", method = RequestMethod.GET)
	public String getUserMessageIdsByUserIdJsonList(HttpServletRequest request,
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

			List<Long> ids= userMessageService.getUserMessageIdsByUserId(userId,start,size);
		log.info("get countUserMessageIdsByUserId size is " + ids.size());

			List<UserMessage> userMessageList = userMessageService.getObjectsByIds(ids);
			log.info("get userMessage data is " + userMessageList.size());

			Integer total = userMessageService. countUserMessageIdsByUserId(userId);
			log.info("get userMessage count is " + total);

			model.addAttribute("code", 0);
			model.addAttribute("page", page);
			model.addAttribute("size", size);
			
			model.addAttribute("total", total);

			model.addAttribute("userMessageList", userMessageList);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get userMessage list error,page is  " + start + " , size "
					+ size);
			// for test
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/userMessage/json/userMessageListJson";
	}

	
	
		
	
	

	@RequestMapping(value = "/a/userMessage/{id}", method = RequestMethod.GET)
	public String getUserMessageJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			UserMessage userMessage = userMessageService.getObjectById(id);
			log.info("get userMessage data is " + userMessage);

			model.addAttribute("code", 0);

			model.addAttribute("userMessage", userMessage);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get userMessage error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/userMessage/json/userMessageDetailJson";
	}

	@RequestMapping(value = "/a/userMessage/{id}", method = RequestMethod.PUT)
	public String updateUserMessageJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, UserMessage userMessage) throws Exception {
		
		log.info("update userMessage : userMessage= " + userMessage);
		
		try {
			
			userMessageService.update(userMessage);

			model.addAttribute("code", 0);

			model.addAttribute("userMessage", userMessage);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update userMessage error,id is  " + userMessage.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/userMessage", method = RequestMethod.POST)
	public String addUserMessageJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, UserMessage userMessage) throws Exception {
		
		log.info("update userMessage : userMessage= " + userMessage);
		
		try { 
			userMessage.setId(null);

			userMessageService.insert(userMessage);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add userMessage error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/userMessage/{id}", method = RequestMethod.DELETE)
	public String deleteUserMessageJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete userMessage : id= " + id);
		try {
			userMessageService.delete(id);

			log.info("add userMessage success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete userMessage error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/userMessage", method = RequestMethod.GET)
	public String getMultiUserMessageJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<UserMessage> userMessageList = userMessageService.getObjectsByIds(idList);
			log.info("get  userMessage data is " + userMessageList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",userMessageList.size());

			model.addAttribute("userMessageList", userMessageList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get userMessage error,id is  " + idList);
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/userMessage/json/userMessageListJson";
	}
	
	
	
	
	
}

