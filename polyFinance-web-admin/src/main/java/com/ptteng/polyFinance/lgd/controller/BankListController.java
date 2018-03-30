package com.ptteng.polyFinance.lgd.controller;

import com.ptteng.polyFinance.lgd.model.BankList;
import com.ptteng.polyFinance.lgd.service.BankListService;
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
 * BankList  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class BankListController {
	private static final Log log = LogFactory.getLog(BankListController.class);

	@Autowired
	private BankListService bankListService;






    /**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */

	@RequestMapping(value = "/c/bankList", method = RequestMethod.GET)
	public String getbankListList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		
		
		log.info("/bankList  to /bankList/view/bankListList");

		return "/polyFinance-lgd-server/bankList/view/bankListList";
	}
    
    

    
	
	@RequestMapping(value = "/c/bankList/{id}", method = RequestMethod.GET)
	public String getBankList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("/bankList/" + id + "  to /bankList/view/bankListDeail");
		if(null != id){
			model.addAttribute("id", id);
		}else{
			model.addAttribute("id", 0);
		}

		return "/polyFinance-lgd-server/bankList/view/bankListDetail";
	}
	
	
	
	    
	

	@RequestMapping(value = "/a/bankList/{id}", method = RequestMethod.GET)
	public String getBankListJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			BankList bankList = bankListService.getObjectById(id);
			log.info("get bankList data is " + bankList);

			model.addAttribute("code", 0);

			model.addAttribute("bankList", bankList);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get bankList error,id is  " + id);
			model.addAttribute("code", -100);
		}

		return "/polyFinance-lgd-server/bankList/json/bankListDetailJson";
	}

	@RequestMapping(value = "/a/bankList/{id}", method = RequestMethod.PUT)
	public String updateBankListJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, BankList bankList) throws Exception {
		
		log.info("update bankList : bankList= " + bankList);
		
		try {
			
			bankListService.update(bankList);

			model.addAttribute("code", 0);

			model.addAttribute("bankList", bankList);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update bankList error,id is  " + bankList.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/bankList", method = RequestMethod.POST)
	public String addBankListJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, BankList bankList) throws Exception {
		
		log.info("update bankList : bankList= " + bankList);
		
		try { 
			bankList.setId(null);

			bankListService.insert(bankList);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add bankList error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/bankList/{id}", method = RequestMethod.DELETE)
	public String deleteBankListJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete bankList : id= " + id);
		try {
			bankListService.delete(id);

			log.info("add bankList success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete bankList error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/bankList", method = RequestMethod.GET)
	public String getMultiBankListJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<BankList> bankListList = bankListService.getObjectsByIds(idList);
			log.info("get  bankList data is " + bankListList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",bankListList.size());

			model.addAttribute("bankListList", bankListList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get bankList error,id is  " + idList);
			model.addAttribute("code", -100);
		}

		return "/polyFinance-lgd-server/bankList/json/bankListListJson";
	}
	
	
	
	
	
}

