package com.ptteng.polyFinance.lgd.controller;

import com.ptteng.polyFinance.lgd.model.Repayment;
import com.ptteng.polyFinance.lgd.service.RepaymentService;
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
 * Repayment  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class RepaymentController {
	private static final Log log = LogFactory.getLog(RepaymentController.class);

	@Autowired
	private RepaymentService repaymentService;






    /**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */

	@RequestMapping(value = "/c/repayment", method = RequestMethod.GET)
	public String getrepaymentList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		
		
		log.info("/repayment  to /repayment/view/repaymentList");

		return "/polyFinance-lgd-server/repayment/view/repaymentList";
	}
    
    

    		
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 
	
		 @RequestMapping(value = "/c/repayment1 ", method = RequestMethod.GET)
	public String getRepaymentIdsByRepaymentStatusList1(HttpServletRequest request,
			HttpServletResponse response, ModelMap model,Integer repaymentStatus) throws Exception {

		log.info("/repayment  to /repayment/view/repaymentList");

		return "/polyFinance-lgd-server/repayment/view/repaymentList";
	}

	
	
	
	
	
	
	@RequestMapping(value = "/c/repayment/{id}", method = RequestMethod.GET)
	public String getRepayment(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("/repayment/" + id + "  to /repayment/view/repaymentDeail");
		if(null != id){
			model.addAttribute("id", id);
		}else{
			model.addAttribute("id", 0);
		}

		return "/polyFinance-lgd-server/repayment/view/repaymentDetail";
	}
	
	
	
	    		
			
    /**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	
		@RequestMapping(value = "/a/repayment1 ", method = RequestMethod.GET)
	public String getRepaymentIdsByRepaymentStatusJsonList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Integer page,
			Integer size,Integer repaymentStatus) throws Exception {


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

			List<Long> ids= repaymentService.getRepaymentIdsByRepaymentStatus(repaymentStatus,start,size);
		log.info("get countRepaymentIdsByRepaymentStatus size is " + ids.size());

			List<Repayment> repaymentList = repaymentService.getObjectsByIds(ids);
			log.info("get repayment data is " + repaymentList.size());

			Integer total = repaymentService. countRepaymentIdsByRepaymentStatus(repaymentStatus);
			log.info("get repayment count is " + total);

			model.addAttribute("code", 0);
			model.addAttribute("page", page);
			model.addAttribute("size", size);
			
			model.addAttribute("total", total);

			model.addAttribute("repaymentList", repaymentList);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get repayment list error,page is  " + start + " , size "
					+ size);
			// for test
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/repayment/json/repaymentListJson";
	}

	
	
		
	
	

	@RequestMapping(value = "/a/repayment/{id}", method = RequestMethod.GET)
	public String getRepaymentJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			Repayment repayment = repaymentService.getObjectById(id);
			log.info("get repayment data is " + repayment);

			model.addAttribute("code", 0);

			model.addAttribute("repayment", repayment);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get repayment error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/repayment/json/repaymentDetailJson";
	}

	@RequestMapping(value = "/a/repayment/{id}", method = RequestMethod.PUT)
	public String updateRepaymentJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Repayment repayment) throws Exception {
		
		log.info("update repayment : repayment= " + repayment);
		
		try {
			
			repaymentService.update(repayment);

			model.addAttribute("code", 0);

			model.addAttribute("repayment", repayment);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update repayment error,id is  " + repayment.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/repayment", method = RequestMethod.POST)
	public String addRepaymentJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Repayment repayment) throws Exception {
		
		log.info("update repayment : repayment= " + repayment);
		
		try { 
			repayment.setId(null);

			repaymentService.insert(repayment);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add repayment error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/repayment/{id}", method = RequestMethod.DELETE)
	public String deleteRepaymentJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete repayment : id= " + id);
		try {
			repaymentService.delete(id);

			log.info("add repayment success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete repayment error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/repayment", method = RequestMethod.GET)
	public String getMultiRepaymentJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<Repayment> repaymentList = repaymentService.getObjectsByIds(idList);
			log.info("get  repayment data is " + repaymentList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",repaymentList.size());

			model.addAttribute("repaymentList", repaymentList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get repayment error,id is  " + idList);
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/repayment/json/repaymentListJson";
	}
	
	
	
	
	
}

