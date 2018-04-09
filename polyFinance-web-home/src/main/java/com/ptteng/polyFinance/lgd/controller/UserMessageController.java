package com.ptteng.polyFinance.lgd.controller;

import com.ptteng.polyFinance.lgd.model.UserMessage;
import com.ptteng.polyFinance.lgd.service.SysMessageReadedService;
import com.ptteng.polyFinance.lgd.service.SysMessageService;
import com.ptteng.polyFinance.lgd.service.UserMessageService;
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
 * UserMessage  crud
 * 
 * @author magenm
 * @Date 2014-4-16 13:43
 * 
 */
@Controller
public class UserMessageController {
	private static final Log log = LogFactory.getLog(UserMessageController.class);

	@Autowired
	private UserMessageService userMessageService;
	@Autowired
	private SysMessageService sysMessageService;
	@Autowired
	private SysMessageReadedService sysMessageReadedService;

	
	@RequestMapping(value = "a/u/userMessage/list/{id}",method = RequestMethod.GET)
	
	public String getUserMessage(@PathVariable Long id,ModelMap model){
		return "";
	}
}

