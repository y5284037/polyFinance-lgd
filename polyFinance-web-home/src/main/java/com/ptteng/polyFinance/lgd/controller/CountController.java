package com.ptteng.polyFinance.lgd.controller;

import com.ptteng.polyFinance.lgd.model.Count;
import com.ptteng.polyFinance.lgd.service.CountService;
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
 * Count  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class CountController {
	private static final Log log = LogFactory.getLog(CountController.class);

	@Autowired
	private CountService countService;






    /**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */

	@RequestMapping(value = "/c/count", method = RequestMethod.GET)
	public String getcountList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		
		
		log.info("/count  to /count/view/countList");

		return "/polyFinance-lgd-server/count/view/countList";
	}
    
    

    		
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 
	
		 @RequestMapping(value = "/c/count1 ", method = RequestMethod.GET)
	public String getCountIdsByProductIdOrderByCreateAtList1(HttpServletRequest request,
			HttpServletResponse response, ModelMap model,Long productId) throws Exception {

		log.info("/count  to /count/view/countList");

		return "/polyFinance-lgd-server/count/view/countList";
	}

	
	
	
	
	
	
	@RequestMapping(value = "/c/count/{id}", method = RequestMethod.GET)
	public String getCount(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("/count/" + id + "  to /count/view/countDeail");
		if(null != id){
			model.addAttribute("id", id);
		}else{
			model.addAttribute("id", 0);
		}

		return "/polyFinance-lgd-server/count/view/countDetail";
	}
	
	
	
	    		
			
    /**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	
		@RequestMapping(value = "/a/count1 ", method = RequestMethod.GET)
	public String getCountIdsByProductIdOrderByCreateAtJsonList(HttpServletRequest request,
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

			List<Long> ids= countService.getCountIdsByProductIdOrderByCreateAt(productId,start,size);
		log.info("get countCountIdsByProductIdOrderByCreateAt size is " + ids.size());

			List<Count> countList = countService.getObjectsByIds(ids);
			log.info("get count data is " + countList.size());

			Integer total = countService. countCountIdsByProductIdOrderByCreateAt(productId);
			log.info("get count count is " + total);

			model.addAttribute("code", 0);
			model.addAttribute("page", page);
			model.addAttribute("size", size);
			
			model.addAttribute("total", total);

			model.addAttribute("countList", countList);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get count list error,page is  " + start + " , size "
					+ size);
			// for test
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/count/json/countListJson";
	}

	
	
		
	
	

	@RequestMapping(value = "/a/count/{id}", method = RequestMethod.GET)
	public String getCountJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("get data : id= " + id);
		try {
			Count count = countService.getObjectById(id);
			log.info("get count data is " + count);

			model.addAttribute("code", 0);

			model.addAttribute("count", count);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("get count error,id is  " + id);
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/count/json/countDetailJson";
	}

	@RequestMapping(value = "/a/count/{id}", method = RequestMethod.PUT)
	public String updateCountJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Count count) throws Exception {
		
		log.info("update count : count= " + count);
		
		try {
			
			countService.update(count);

			model.addAttribute("code", 0);

			model.addAttribute("count", count);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("update count error,id is  " + count.getId());
			model.addAttribute("code", -6003);

		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/count", method = RequestMethod.POST)
	public String addCountJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Count count) throws Exception {
		
		log.info("update count : count= " + count);
		
		try { 
			count.setId(null);

			countService.insert(count);

			model.addAttribute("code", 0);
		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("add count error ");
			model.addAttribute("code", -6002);
		}

		return "/data/json";
	}

	@RequestMapping(value = "/a/count/{id}", method = RequestMethod.DELETE)
	public String deleteCountJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, @PathVariable Long id)
			throws Exception {

		log.info("delete count : id= " + id);
		try {
			countService.delete(id);

			log.info("add count success");
			model.addAttribute("code", 0);

		} catch (Throwable t) {
		    t.printStackTrace();
			log.error(t.getMessage());
			log.error("delete count error,id is  " + id);
			model.addAttribute("code", -6004);

		}

		return "/data/json";
	}
	
	
	@RequestMapping(value = "/a/multi/count", method = RequestMethod.GET)
	public String getMultiCountJson(HttpServletRequest request,
			HttpServletResponse response, ModelMap model, Long[] ids)
			throws Exception {
			
		List<Long> idList = new ArrayList();	
	   if (ids == null) {

		} else {
			idList = Arrays.asList(ids);
		}
		try {

			

			List<Count> countList = countService.getObjectsByIds(idList);
			log.info("get  count data is " + countList);

			model.addAttribute("code", 0);			
			model.addAttribute("total",countList.size());

			model.addAttribute("countList", countList);

		} catch (Throwable t) {
			log.error(t.getMessage());
			log.error("get count error,id is  " + idList);
			model.addAttribute("code", -100000);
		}

		return "/polyFinance-lgd-server/count/json/countListJson";
	}
	
	
	
	
	
}

