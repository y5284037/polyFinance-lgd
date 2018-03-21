package com.ptteng.polyFinance.lgd.controller;

import com.ptteng.polyFinance.lgd.model.Content;
import com.ptteng.polyFinance.lgd.service.ContentService;
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
 * Content  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class ContentController {
	private static final Log log = LogFactory.getLog(ContentController.class);

	@Autowired
	private ContentService contentService;






    /**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */

	@RequestMapping(value = "/c/content", method = RequestMethod.GET)
	public String getcontentList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		
		
		log.info("/content  to /content/view/contentList");

		return "/polyFinance-lgd-server/content/view/contentList";
	}
    
    

    
	
	@RequestMapping(value = "/c/content/{id}", method = RequestMethod.GET)
	public String getContent(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("/content/" + id + "  to /content/view/contentDeail");
		if(null != id){
			model.addAttribute("id", id);
		}else{
			model.addAttribute("id", 0);
		}

		return "/polyFinance-lgd-server/content/view/contentDetail";
	}
	
	
	
	    
	

	@RequestMapping(value = "/a/content/{id}", method = RequestMethod.GET)
	public String getContentJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			Content content = contentService.getObjectById(id);
			log.info("get content data is " + content);

			model.addAttribute("code", 0);

			model.addAttribute("content", content);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get content error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/content/json/contentDetailJson";
	}

	@RequestMapping(value = "/a/content/{id}", method = RequestMethod.PUT)
	public String updateContentJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Content content) throws Exception {
		
		log.info("update content : content= " + content);
		
		try {
			
			contentService.update(content);

			model.addAttribute("code", 0);

			model.addAttribute("content", content);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update content error,id is  " + content.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/content", method = RequestMethod.POST)
	public String addContentJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Content content) throws Exception {
		
		log.info("update content : content= " + content);
		
		try { 
			content.setId(null);

			contentService.insert(content);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add content error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/content/{id}", method = RequestMethod.DELETE)
	public String deleteContentJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete content : id= " + id);
		try {
			contentService.delete(id);

			log.info("add content success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete content error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/content", method = RequestMethod.GET)
	public String getMultiContentJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<Content> contentList = contentService.getObjectsByIds(idList);
			log.info("get  content data is " + contentList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",contentList.size());

			model.addAttribute("contentList", contentList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get content error,id is  " + idList);
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/content/json/contentListJson";
	}
	
	
	
	
	
}

