package com.ptteng.polyFinance.lgd.controller;

import com.ptteng.polyFinance.lgd.model.Debtor;
import com.ptteng.polyFinance.lgd.service.DebtorService;
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
 * Debtor  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class DebtorController {
	private static final Log log = LogFactory.getLog(DebtorController.class);

	@Autowired
	private DebtorService debtorService;






    /**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */

	@RequestMapping(value = "/c/debtor", method = RequestMethod.GET)
	public String getdebtorList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		
		
		log.info("/debtor  to /debtor/view/debtorList");

		return "/polyFinance-lgd-server/debtor/view/debtorList";
	}
    
    

    
	
	@RequestMapping(value = "/c/debtor/{id}", method = RequestMethod.GET)
	public String getDebtor(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("/debtor/" + id + "  to /debtor/view/debtorDeail");
		if(null != id){
			model.addAttribute("id", id);
		}else{
			model.addAttribute("id", 0);
		}

		return "/polyFinance-lgd-server/debtor/view/debtorDetail";
	}
	
	
	
	    
	

	@RequestMapping(value = "/a/debtor/{id}", method = RequestMethod.GET)
	public String getDebtorJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			Debtor debtor = debtorService.getObjectById(id);
			log.info("get debtor data is " + debtor);

			model.addAttribute("code", 0);

			model.addAttribute("debtor", debtor);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get debtor error,id is  " + id);
			model.addAttribute("code", -100);
		}

		return "/polyFinance-lgd-server/debtor/json/debtorDetailJson";
	}

	@RequestMapping(value = "/a/debtor/{id}", method = RequestMethod.PUT)
	public String updateDebtorJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Debtor debtor) throws Exception {
		
		log.info("update debtor : debtor= " + debtor);
		
		try {
			
			debtorService.update(debtor);

			model.addAttribute("code", 0);

			model.addAttribute("debtor", debtor);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update debtor error,id is  " + debtor.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/debtor", method = RequestMethod.POST)
	public String addDebtorJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Debtor debtor) throws Exception {
		
		log.info("update debtor : debtor= " + debtor);
		
		try { 
			debtor.setId(null);

			debtorService.insert(debtor);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add debtor error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/debtor/{id}", method = RequestMethod.DELETE)
	public String deleteDebtorJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete debtor : id= " + id);
		try {
			debtorService.delete(id);

			log.info("add debtor success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete debtor error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/debtor", method = RequestMethod.GET)
	public String getMultiDebtorJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<Debtor> debtorList = debtorService.getObjectsByIds(idList);
			log.info("get  debtor data is " + debtorList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",debtorList.size());

			model.addAttribute("debtorList", debtorList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get debtor error,id is  " + idList);
			model.addAttribute("code", -100);
		}

		return "/polyFinance-lgd-server/debtor/json/debtorListJson";
	}
	
	
	
	
	
}

