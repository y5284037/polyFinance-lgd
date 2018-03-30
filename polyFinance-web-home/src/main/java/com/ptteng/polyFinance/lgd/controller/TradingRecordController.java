package com.ptteng.polyFinance.lgd.controller;

import com.ptteng.polyFinance.lgd.model.TradingRecord;
import com.ptteng.polyFinance.lgd.service.TradingRecordService;
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
 * TradingRecord  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class TradingRecordController {
	private static final Log log = LogFactory.getLog(TradingRecordController.class);

	@Autowired
	private TradingRecordService tradingRecordService;






    /**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */

	@RequestMapping(value = "/c/tradingRecord", method = RequestMethod.GET)
	public String gettradingRecordList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		
		
		log.info("/tradingRecord  to /tradingRecord/view/tradingRecordList");

		return "/polyFinance-lgd-server/tradingRecord/view/tradingRecordList";
	}
    
    

    		
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 
	
		 @RequestMapping(value = "/c/tradingRecord1 ", method = RequestMethod.GET)
	public String getTradingRecordIdsByUserIdOrderByTradingTimeList1(HttpServletRequest request,
			HttpServletResponse response, ModelMap model,Long userId) throws Exception {

		log.info("/tradingRecord  to /tradingRecord/view/tradingRecordList");

		return "/polyFinance-lgd-server/tradingRecord/view/tradingRecordList";
	}

	
	
	
	
	
	
	@RequestMapping(value = "/c/tradingRecord/{id}", method = RequestMethod.GET)
	public String getTradingRecord(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("/tradingRecord/" + id + "  to /tradingRecord/view/tradingRecordDeail");
		if(null != id){
			model.addAttribute("id", id);
		}else{
			model.addAttribute("id", 0);
		}

		return "/polyFinance-lgd-server/tradingRecord/view/tradingRecordDetail";
	}
	
	
	
	    		
			
    /**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	
		@RequestMapping(value = "/a/tradingRecord1 ", method = RequestMethod.GET)
	public String getTradingRecordIdsByUserIdOrderByTradingTimeJsonList(HttpServletRequest request,
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

			List<Long> ids= tradingRecordService.getTradingRecordIdsByUserIdOrderByTradingTime(userId,start,size);
		log.info("get countTradingRecordIdsByUserIdOrderByTradingTime size is " + ids.size());

			List<TradingRecord> tradingRecordList = tradingRecordService.getObjectsByIds(ids);
			log.info("get tradingRecord data is " + tradingRecordList.size());

			Integer total = tradingRecordService. countTradingRecordIdsByUserIdOrderByTradingTime(userId);
			log.info("get tradingRecord count is " + total);

			model.addAttribute("code", 0);
			model.addAttribute("page", page);
			model.addAttribute("size", size);
			
			model.addAttribute("total", total);

			model.addAttribute("tradingRecordList", tradingRecordList);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get tradingRecord list error,page is  " + start + " , size "
					+ size);
			// for test
			model.addAttribute("code", -100);
		}

		return "/polyFinance-lgd-server/tradingRecord/json/tradingRecordListJson";
	}

	
	
		
	
	

	@RequestMapping(value = "/a/tradingRecord/{id}", method = RequestMethod.GET)
	public String getTradingRecordJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			TradingRecord tradingRecord = tradingRecordService.getObjectById(id);
			log.info("get tradingRecord data is " + tradingRecord);

			model.addAttribute("code", 0);

			model.addAttribute("tradingRecord", tradingRecord);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get tradingRecord error,id is  " + id);
			model.addAttribute("code", -100);
		}

		return "/polyFinance-lgd-server/tradingRecord/json/tradingRecordDetailJson";
	}

	@RequestMapping(value = "/a/tradingRecord/{id}", method = RequestMethod.PUT)
	public String updateTradingRecordJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, TradingRecord tradingRecord) throws Exception {
		
		log.info("update tradingRecord : tradingRecord= " + tradingRecord);
		
		try {
			
			tradingRecordService.update(tradingRecord);

			model.addAttribute("code", 0);

			model.addAttribute("tradingRecord", tradingRecord);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update tradingRecord error,id is  " + tradingRecord.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/tradingRecord", method = RequestMethod.POST)
	public String addTradingRecordJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, TradingRecord tradingRecord) throws Exception {
		
		log.info("update tradingRecord : tradingRecord= " + tradingRecord);
		
		try { 
			tradingRecord.setId(null);

			tradingRecordService.insert(tradingRecord);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add tradingRecord error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/tradingRecord/{id}", method = RequestMethod.DELETE)
	public String deleteTradingRecordJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete tradingRecord : id= " + id);
		try {
			tradingRecordService.delete(id);

			log.info("add tradingRecord success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete tradingRecord error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/tradingRecord", method = RequestMethod.GET)
	public String getMultiTradingRecordJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<TradingRecord> tradingRecordList = tradingRecordService.getObjectsByIds(idList);
			log.info("get  tradingRecord data is " + tradingRecordList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",tradingRecordList.size());

			model.addAttribute("tradingRecordList", tradingRecordList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get tradingRecord error,id is  " + idList);
			model.addAttribute("code", -100);
		}

		return "/polyFinance-lgd-server/tradingRecord/json/tradingRecordListJson";
	}
	
	
	
	
	
}

