package com.ptteng.polyFinance.lgd.controller;

import com.ptteng.polyFinance.lgd.model.InvestRecord;
import com.ptteng.polyFinance.lgd.service.InvestRecordService;
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
 * InvestRecord  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class InvestRecordController {
	private static final Log log = LogFactory.getLog(InvestRecordController.class);

	@Autowired
	private InvestRecordService investRecordService;






    /**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */

	@RequestMapping(value = "/c/investRecord", method = RequestMethod.GET)
	public String getinvestRecordList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		
		
		log.info("/investRecord  to /investRecord/view/investRecordList");

		return "/polyFinance-lgd-server/investRecord/view/investRecordList";
	}
    
    

    		
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 
	
		 @RequestMapping(value = "/c/investRecord1 ", method = RequestMethod.GET)
	public String getInvestRecordIdsByUserIdAndInvestStatusOrderByCreateAtList1(HttpServletRequest request,
			HttpServletResponse response, ModelMap model,Long userId,Integer investStatus) throws Exception {

		log.info("/investRecord  to /investRecord/view/investRecordList");

		return "/polyFinance-lgd-server/investRecord/view/investRecordList";
	}

	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 
	
		 @RequestMapping(value = "/c/investRecord2 ", method = RequestMethod.GET)
	public String getInvestRecordIdsByProductIdList2(HttpServletRequest request,
			HttpServletResponse response, ModelMap model,Long productId) throws Exception {

		log.info("/investRecord  to /investRecord/view/investRecordList");

		return "/polyFinance-lgd-server/investRecord/view/investRecordList";
	}

	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 
	
		 @RequestMapping(value = "/c/investRecord3 ", method = RequestMethod.GET)
	public String getInvestRecordIdsByUserIdOrderByCreateAtList3(HttpServletRequest request,
			HttpServletResponse response, ModelMap model,Long userId) throws Exception {

		log.info("/investRecord  to /investRecord/view/investRecordList");

		return "/polyFinance-lgd-server/investRecord/view/investRecordList";
	}

	
	
	
	
	
	
	@RequestMapping(value = "/c/investRecord/{id}", method = RequestMethod.GET)
	public String getInvestRecord(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("/investRecord/" + id + "  to /investRecord/view/investRecordDeail");
		if(null != id){
			model.addAttribute("id", id);
		}else{
			model.addAttribute("id", 0);
		}

		return "/polyFinance-lgd-server/investRecord/view/investRecordDetail";
	}
	
	
	
	    		
			
    /**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	
		@RequestMapping(value = "/a/investRecord1 ", method = RequestMethod.GET)
	public String getInvestRecordIdsByUserIdAndInvestStatusOrderByCreateAtJsonList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Integer page,
			Integer size,Long userId,Integer investStatus) throws Exception {


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

			List<Long> ids= investRecordService.getInvestRecordIdsByUserIdAndInvestStatusOrderByCreateAt(userId,investStatus,start,size);
		log.info("get countInvestRecordIdsByUserIdAndInvestStatusOrderByCreateAt size is " + ids.size());

			List<InvestRecord> investRecordList = investRecordService.getObjectsByIds(ids);
			log.info("get investRecord data is " + investRecordList.size());

			Integer total = investRecordService. countInvestRecordIdsByUserIdAndInvestStatusOrderByCreateAt(userId,investStatus);
			log.info("get investRecord count is " + total);

			model.addAttribute("code", 0);
			model.addAttribute("page", page);
			model.addAttribute("size", size);
			
			model.addAttribute("total", total);

			model.addAttribute("investRecordList", investRecordList);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get investRecord list error,page is  " + start + " , size "
					+ size);
			// for test
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/investRecord/json/investRecordListJson";
	}

	
	
		
			
			
    /**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	
		@RequestMapping(value = "/a/investRecord2 ", method = RequestMethod.GET)
	public String getInvestRecordIdsByProductIdJsonList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Integer page,
			Integer size,Long productId) throws Exception {


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

			List<Long> ids= investRecordService.getInvestRecordIdsByProductId(productId,start,size);
		log.info("get countInvestRecordIdsByProductId size is " + ids.size());

			List<InvestRecord> investRecordList = investRecordService.getObjectsByIds(ids);
			log.info("get investRecord data is " + investRecordList.size());

			Integer total = investRecordService. countInvestRecordIdsByProductId(productId);
			log.info("get investRecord count is " + total);

			model.addAttribute("code", 0);
			model.addAttribute("page", page);
			model.addAttribute("size", size);
			
			model.addAttribute("total", total);

			model.addAttribute("investRecordList", investRecordList);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get investRecord list error,page is  " + start + " , size "
					+ size);
			// for test
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/investRecord/json/investRecordListJson";
	}

	
	
		
			
			
    /**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	
		@RequestMapping(value = "/a/investRecord3 ", method = RequestMethod.GET)
	public String getInvestRecordIdsByUserIdOrderByCreateAtJsonList(HttpServletRequest request,
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

			List<Long> ids= investRecordService.getInvestRecordIdsByUserIdOrderByCreateAt(userId,start,size);
		log.info("get countInvestRecordIdsByUserIdOrderByCreateAt size is " + ids.size());

			List<InvestRecord> investRecordList = investRecordService.getObjectsByIds(ids);
			log.info("get investRecord data is " + investRecordList.size());

			Integer total = investRecordService. countInvestRecordIdsByUserIdOrderByCreateAt(userId);
			log.info("get investRecord count is " + total);

			model.addAttribute("code", 0);
			model.addAttribute("page", page);
			model.addAttribute("size", size);
			
			model.addAttribute("total", total);

			model.addAttribute("investRecordList", investRecordList);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get investRecord list error,page is  " + start + " , size "
					+ size);
			// for test
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/investRecord/json/investRecordListJson";
	}

	
	
		
	
	

	@RequestMapping(value = "/a/investRecord/{id}", method = RequestMethod.GET)
	public String getInvestRecordJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			InvestRecord investRecord = investRecordService.getObjectById(id);
			log.info("get investRecord data is " + investRecord);

			model.addAttribute("code", 0);

			model.addAttribute("investRecord", investRecord);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get investRecord error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/investRecord/json/investRecordDetailJson";
	}

	@RequestMapping(value = "/a/investRecord/{id}", method = RequestMethod.PUT)
	public String updateInvestRecordJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, InvestRecord investRecord) throws Exception {
		
		log.info("update investRecord : investRecord= " + investRecord);
		
		try {
			
			investRecordService.update(investRecord);

			model.addAttribute("code", 0);

			model.addAttribute("investRecord", investRecord);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update investRecord error,id is  " + investRecord.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/investRecord", method = RequestMethod.POST)
	public String addInvestRecordJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, InvestRecord investRecord) throws Exception {
		
		log.info("update investRecord : investRecord= " + investRecord);
		
		try { 
			investRecord.setId(null);

			investRecordService.insert(investRecord);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add investRecord error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/investRecord/{id}", method = RequestMethod.DELETE)
	public String deleteInvestRecordJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete investRecord : id= " + id);
		try {
			investRecordService.delete(id);

			log.info("add investRecord success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete investRecord error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/investRecord", method = RequestMethod.GET)
	public String getMultiInvestRecordJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<InvestRecord> investRecordList = investRecordService.getObjectsByIds(idList);
			log.info("get  investRecord data is " + investRecordList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",investRecordList.size());

			model.addAttribute("investRecordList", investRecordList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get investRecord error,id is  " + idList);
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/investRecord/json/investRecordListJson";
	}
	
	
	
	
	
}

