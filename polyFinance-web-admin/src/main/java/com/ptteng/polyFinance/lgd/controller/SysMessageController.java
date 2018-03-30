package com.ptteng.polyFinance.lgd.controller;

import com.ptteng.polyFinance.lgd.model.SysMessage;
import com.ptteng.polyFinance.lgd.service.SysMessageService;
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
 * SysMessage  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class SysMessageController {
	private static final Log log = LogFactory.getLog(SysMessageController.class);

	@Autowired
	private SysMessageService sysMessageService;






    /**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */

	@RequestMapping(value = "/c/sysMessage", method = RequestMethod.GET)
	public String getsysMessageList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		
		
		log.info("/sysMessage  to /sysMessage/view/sysMessageList");

		return "/polyFinance-lgd-server/sysMessage/view/sysMessageList";
	}
    
    

    		
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 
	
		 @RequestMapping(value = "/c/sysMessage1 ", method = RequestMethod.GET)
	public String getSysMessageIdsByStatusList1(HttpServletRequest request,
			HttpServletResponse response, ModelMap model,Integer status) throws Exception {

		log.info("/sysMessage  to /sysMessage/view/sysMessageList");

		return "/polyFinance-lgd-server/sysMessage/view/sysMessageList";
	}

	
	
	
	
	
	
	@RequestMapping(value = "/c/sysMessage/{id}", method = RequestMethod.GET)
	public String getSysMessage(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("/sysMessage/" + id + "  to /sysMessage/view/sysMessageDeail");
		if(null != id){
			model.addAttribute("id", id);
		}else{
			model.addAttribute("id", 0);
		}

		return "/polyFinance-lgd-server/sysMessage/view/sysMessageDetail";
	}
	
	
	
	    		
			
    /**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	
		@RequestMapping(value = "/a/sysMessage1 ", method = RequestMethod.GET)
	public String getSysMessageIdsByStatusJsonList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Integer page,
			Integer size,Integer status) throws Exception {


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

			List<Long> ids= sysMessageService.getSysMessageIdsByStatus(status,start,size);
		log.info("get countSysMessageIdsByStatus size is " + ids.size());

			List<SysMessage> sysMessageList = sysMessageService.getObjectsByIds(ids);
			log.info("get sysMessage data is " + sysMessageList.size());

			Integer total = sysMessageService. countSysMessageIdsByStatus(status);
			log.info("get sysMessage count is " + total);

			model.addAttribute("code", 0);
			model.addAttribute("page", page);
			model.addAttribute("size", size);
			
			model.addAttribute("total", total);

			model.addAttribute("sysMessageList", sysMessageList);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get sysMessage list error,page is  " + start + " , size "
					+ size);
			// for test
			model.addAttribute("code", -100);
		}

		return "/polyFinance-lgd-server/sysMessage/json/sysMessageListJson";
	}

	
	
		
	
	

	@RequestMapping(value = "/a/sysMessage/{id}", method = RequestMethod.GET)
	public String getSysMessageJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			SysMessage sysMessage = sysMessageService.getObjectById(id);
			log.info("get sysMessage data is " + sysMessage);

			model.addAttribute("code", 0);

			model.addAttribute("sysMessage", sysMessage);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get sysMessage error,id is  " + id);
			model.addAttribute("code", -100);
		}

		return "/polyFinance-lgd-server/sysMessage/json/sysMessageDetailJson";
	}

	@RequestMapping(value = "/a/sysMessage/{id}", method = RequestMethod.PUT)
	public String updateSysMessageJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, SysMessage sysMessage) throws Exception {
		
		log.info("update sysMessage : sysMessage= " + sysMessage);
		
		try {
			
			sysMessageService.update(sysMessage);

			model.addAttribute("code", 0);

			model.addAttribute("sysMessage", sysMessage);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update sysMessage error,id is  " + sysMessage.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/sysMessage", method = RequestMethod.POST)
	public String addSysMessageJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, SysMessage sysMessage) throws Exception {
		
		log.info("update sysMessage : sysMessage= " + sysMessage);
		
		try { 
			sysMessage.setId(null);

			sysMessageService.insert(sysMessage);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add sysMessage error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/sysMessage/{id}", method = RequestMethod.DELETE)
	public String deleteSysMessageJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete sysMessage : id= " + id);
		try {
			sysMessageService.delete(id);

			log.info("add sysMessage success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete sysMessage error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/sysMessage", method = RequestMethod.GET)
	public String getMultiSysMessageJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<SysMessage> sysMessageList = sysMessageService.getObjectsByIds(idList);
			log.info("get  sysMessage data is " + sysMessageList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",sysMessageList.size());

			model.addAttribute("sysMessageList", sysMessageList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get sysMessage error,id is  " + idList);
			model.addAttribute("code", -100);
		}

		return "/polyFinance-lgd-server/sysMessage/json/sysMessageListJson";
	}
	
	
	
	
	
}

