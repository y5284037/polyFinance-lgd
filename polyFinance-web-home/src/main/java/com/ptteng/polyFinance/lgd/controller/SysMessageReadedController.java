package com.ptteng.polyFinance.lgd.controller;

import com.ptteng.polyFinance.lgd.model.SysMessageReaded;
import com.ptteng.polyFinance.lgd.service.SysMessageReadedService;
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
 * SysMessageReaded  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class SysMessageReadedController {
	private static final Log log = LogFactory.getLog(SysMessageReadedController.class);

	@Autowired
	private SysMessageReadedService sysMessageReadedService;






    /**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */

	@RequestMapping(value = "/c/sysMessageReaded", method = RequestMethod.GET)
	public String getsysMessageReadedList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		
		
		log.info("/sysMessageReaded  to /sysMessageReaded/view/sysMessageReadedList");

		return "/polyFinance-lgd-server/sysMessageReaded/view/sysMessageReadedList";
	}
    
    

    		
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 
	
		 @RequestMapping(value = "/c/sysMessageReaded1 ", method = RequestMethod.GET)
	public String getSysMessageReadedIdsByUserIdList1(HttpServletRequest request,
			HttpServletResponse response, ModelMap model,Long userId) throws Exception {

		log.info("/sysMessageReaded  to /sysMessageReaded/view/sysMessageReadedList");

		return "/polyFinance-lgd-server/sysMessageReaded/view/sysMessageReadedList";
	}

	
	
	
	
	
	
	@RequestMapping(value = "/c/sysMessageReaded/{id}", method = RequestMethod.GET)
	public String getSysMessageReaded(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("/sysMessageReaded/" + id + "  to /sysMessageReaded/view/sysMessageReadedDeail");
		if(null != id){
			model.addAttribute("id", id);
		}else{
			model.addAttribute("id", 0);
		}

		return "/polyFinance-lgd-server/sysMessageReaded/view/sysMessageReadedDetail";
	}
	
	
	
	    		
			
    /**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	
		@RequestMapping(value = "/a/sysMessageReaded1 ", method = RequestMethod.GET)
	public String getSysMessageReadedIdsByUserIdJsonList(HttpServletRequest request,
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

			List<Long> ids= sysMessageReadedService.getSysMessageReadedIdsByUserId(userId,start,size);
		log.info("get countSysMessageReadedIdsByUserId size is " + ids.size());

			List<SysMessageReaded> sysMessageReadedList = sysMessageReadedService.getObjectsByIds(ids);
			log.info("get sysMessageReaded data is " + sysMessageReadedList.size());

			Integer total = sysMessageReadedService. countSysMessageReadedIdsByUserId(userId);
			log.info("get sysMessageReaded count is " + total);

			model.addAttribute("code", 0);
			model.addAttribute("page", page);
			model.addAttribute("size", size);
			
			model.addAttribute("total", total);

			model.addAttribute("sysMessageReadedList", sysMessageReadedList);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get sysMessageReaded list error,page is  " + start + " , size "
					+ size);
			// for test
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/sysMessageReaded/json/sysMessageReadedListJson";
	}

	
	
		
	
	

	@RequestMapping(value = "/a/sysMessageReaded/{id}", method = RequestMethod.GET)
	public String getSysMessageReadedJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			SysMessageReaded sysMessageReaded = sysMessageReadedService.getObjectById(id);
			log.info("get sysMessageReaded data is " + sysMessageReaded);

			model.addAttribute("code", 0);

			model.addAttribute("sysMessageReaded", sysMessageReaded);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get sysMessageReaded error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/sysMessageReaded/json/sysMessageReadedDetailJson";
	}

	@RequestMapping(value = "/a/sysMessageReaded/{id}", method = RequestMethod.PUT)
	public String updateSysMessageReadedJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, SysMessageReaded sysMessageReaded) throws Exception {
		
		log.info("update sysMessageReaded : sysMessageReaded= " + sysMessageReaded);
		
		try {
			
			sysMessageReadedService.update(sysMessageReaded);

			model.addAttribute("code", 0);

			model.addAttribute("sysMessageReaded", sysMessageReaded);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update sysMessageReaded error,id is  " + sysMessageReaded.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/sysMessageReaded", method = RequestMethod.POST)
	public String addSysMessageReadedJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, SysMessageReaded sysMessageReaded) throws Exception {
		
		log.info("update sysMessageReaded : sysMessageReaded= " + sysMessageReaded);
		
		try { 
			sysMessageReaded.setId(null);

			sysMessageReadedService.insert(sysMessageReaded);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add sysMessageReaded error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/sysMessageReaded/{id}", method = RequestMethod.DELETE)
	public String deleteSysMessageReadedJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete sysMessageReaded : id= " + id);
		try {
			sysMessageReadedService.delete(id);

			log.info("add sysMessageReaded success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete sysMessageReaded error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/sysMessageReaded", method = RequestMethod.GET)
	public String getMultiSysMessageReadedJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<SysMessageReaded> sysMessageReadedList = sysMessageReadedService.getObjectsByIds(idList);
			log.info("get  sysMessageReaded data is " + sysMessageReadedList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",sysMessageReadedList.size());

			model.addAttribute("sysMessageReadedList", sysMessageReadedList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get sysMessageReaded error,id is  " + idList);
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/sysMessageReaded/json/sysMessageReadedListJson";
	}
	
	
	
	
	
}

