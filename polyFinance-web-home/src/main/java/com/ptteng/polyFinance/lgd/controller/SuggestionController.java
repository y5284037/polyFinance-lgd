package com.ptteng.polyFinance.lgd.controller;

import com.ptteng.polyFinance.lgd.model.Suggestion;
import com.ptteng.polyFinance.lgd.service.SuggestionService;
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
 * Suggestion  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class SuggestionController {
	private static final Log log = LogFactory.getLog(SuggestionController.class);

	@Autowired
	private SuggestionService suggestionService;






    /**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */

	@RequestMapping(value = "/c/suggestion", method = RequestMethod.GET)
	public String getsuggestionList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		
		
		log.info("/suggestion  to /suggestion/view/suggestionList");

		return "/polyFinance-lgd-server/suggestion/view/suggestionList";
	}
    
    

    
	
	@RequestMapping(value = "/c/suggestion/{id}", method = RequestMethod.GET)
	public String getSuggestion(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("/suggestion/" + id + "  to /suggestion/view/suggestionDeail");
		if(null != id){
			model.addAttribute("id", id);
		}else{
			model.addAttribute("id", 0);
		}

		return "/polyFinance-lgd-server/suggestion/view/suggestionDetail";
	}
	
	
	
	    
	

	@RequestMapping(value = "/a/suggestion/{id}", method = RequestMethod.GET)
	public String getSuggestionJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			Suggestion suggestion = suggestionService.getObjectById(id);
			log.info("get suggestion data is " + suggestion);

			model.addAttribute("code", 0);

			model.addAttribute("suggestion", suggestion);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get suggestion error,id is  " + id);
			model.addAttribute("code", -100);
		}

		return "/polyFinance-lgd-server/suggestion/json/suggestionDetailJson";
	}

	@RequestMapping(value = "/a/suggestion/{id}", method = RequestMethod.PUT)
	public String updateSuggestionJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Suggestion suggestion) throws Exception {
		
		log.info("update suggestion : suggestion= " + suggestion);
		
		try {
			
			suggestionService.update(suggestion);

			model.addAttribute("code", 0);

			model.addAttribute("suggestion", suggestion);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update suggestion error,id is  " + suggestion.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/suggestion", method = RequestMethod.POST)
	public String addSuggestionJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Suggestion suggestion) throws Exception {
		
		log.info("update suggestion : suggestion= " + suggestion);
		
		try { 
			suggestion.setId(null);

			suggestionService.insert(suggestion);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add suggestion error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/suggestion/{id}", method = RequestMethod.DELETE)
	public String deleteSuggestionJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete suggestion : id= " + id);
		try {
			suggestionService.delete(id);

			log.info("add suggestion success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete suggestion error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/suggestion", method = RequestMethod.GET)
	public String getMultiSuggestionJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<Suggestion> suggestionList = suggestionService.getObjectsByIds(idList);
			log.info("get  suggestion data is " + suggestionList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",suggestionList.size());

			model.addAttribute("suggestionList", suggestionList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get suggestion error,id is  " + idList);
			model.addAttribute("code", -100);
		}

		return "/polyFinance-lgd-server/suggestion/json/suggestionListJson";
	}
	
	
	
	
	
}

