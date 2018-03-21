package com.ptteng.polyFinance.lgd.controller;

import com.ptteng.polyFinance.lgd.model.DebtorMatch;
import com.ptteng.polyFinance.lgd.service.DebtorMatchService;
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
 * DebtorMatch  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class DebtorMatchController {
	private static final Log log = LogFactory.getLog(DebtorMatchController.class);

	@Autowired
	private DebtorMatchService debtorMatchService;






    /**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */

	@RequestMapping(value = "/c/debtorMatch", method = RequestMethod.GET)
	public String getdebtorMatchList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		
		
		log.info("/debtorMatch  to /debtorMatch/view/debtorMatchList");

		return "/polyFinance-lgd-server/debtorMatch/view/debtorMatchList";
	}
    
    

    		
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 
	
		 @RequestMapping(value = "/c/debtorMatch1 ", method = RequestMethod.GET)
	public String getDebtorMatchIdsByDebtorIdList1(HttpServletRequest request,
			HttpServletResponse response, ModelMap model,Long debtorId) throws Exception {

		log.info("/debtorMatch  to /debtorMatch/view/debtorMatchList");

		return "/polyFinance-lgd-server/debtorMatch/view/debtorMatchList";
	}

	
	
	
	
	
	
	@RequestMapping(value = "/c/debtorMatch/{id}", method = RequestMethod.GET)
	public String getDebtorMatch(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("/debtorMatch/" + id + "  to /debtorMatch/view/debtorMatchDeail");
		if(null != id){
			model.addAttribute("id", id);
		}else{
			model.addAttribute("id", 0);
		}

		return "/polyFinance-lgd-server/debtorMatch/view/debtorMatchDetail";
	}
	
	
	
	    		
			
    /**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	
		@RequestMapping(value = "/a/debtorMatch1 ", method = RequestMethod.GET)
	public String getDebtorMatchIdsByDebtorIdJsonList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Integer page,
			Integer size,Long debtorId) throws Exception {


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

			List<Long> ids= debtorMatchService.getDebtorMatchIdsByDebtorId(debtorId,start,size);
		log.info("get countDebtorMatchIdsByDebtorId size is " + ids.size());

			List<DebtorMatch> debtorMatchList = debtorMatchService.getObjectsByIds(ids);
			log.info("get debtorMatch data is " + debtorMatchList.size());

			Integer total = debtorMatchService. countDebtorMatchIdsByDebtorId(debtorId);
			log.info("get debtorMatch count is " + total);

			model.addAttribute("code", 0);
			model.addAttribute("page", page);
			model.addAttribute("size", size);
			
			model.addAttribute("total", total);

			model.addAttribute("debtorMatchList", debtorMatchList);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get debtorMatch list error,page is  " + start + " , size "
					+ size);
			// for test
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/debtorMatch/json/debtorMatchListJson";
	}

	
	
		
	
	

	@RequestMapping(value = "/a/debtorMatch/{id}", method = RequestMethod.GET)
	public String getDebtorMatchJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			DebtorMatch debtorMatch = debtorMatchService.getObjectById(id);
			log.info("get debtorMatch data is " + debtorMatch);

			model.addAttribute("code", 0);

			model.addAttribute("debtorMatch", debtorMatch);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get debtorMatch error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/debtorMatch/json/debtorMatchDetailJson";
	}

	@RequestMapping(value = "/a/debtorMatch/{id}", method = RequestMethod.PUT)
	public String updateDebtorMatchJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, DebtorMatch debtorMatch) throws Exception {
		
		log.info("update debtorMatch : debtorMatch= " + debtorMatch);
		
		try {
			
			debtorMatchService.update(debtorMatch);

			model.addAttribute("code", 0);

			model.addAttribute("debtorMatch", debtorMatch);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update debtorMatch error,id is  " + debtorMatch.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/debtorMatch", method = RequestMethod.POST)
	public String addDebtorMatchJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, DebtorMatch debtorMatch) throws Exception {
		
		log.info("update debtorMatch : debtorMatch= " + debtorMatch);
		
		try { 
			debtorMatch.setId(null);

			debtorMatchService.insert(debtorMatch);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add debtorMatch error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/debtorMatch/{id}", method = RequestMethod.DELETE)
	public String deleteDebtorMatchJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete debtorMatch : id= " + id);
		try {
			debtorMatchService.delete(id);

			log.info("add debtorMatch success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete debtorMatch error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/debtorMatch", method = RequestMethod.GET)
	public String getMultiDebtorMatchJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<DebtorMatch> debtorMatchList = debtorMatchService.getObjectsByIds(idList);
			log.info("get  debtorMatch data is " + debtorMatchList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",debtorMatchList.size());

			model.addAttribute("debtorMatchList", debtorMatchList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get debtorMatch error,id is  " + idList);
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/debtorMatch/json/debtorMatchListJson";
	}
	
	
	
	
	
}

