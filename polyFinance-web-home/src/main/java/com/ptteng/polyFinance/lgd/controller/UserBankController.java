package com.ptteng.polyFinance.lgd.controller;

import com.gemantic.common.util.MyListUtil;
import com.ptteng.polyFinance.lgd.model.BankList;
import com.ptteng.polyFinance.lgd.model.UserBank;
import com.ptteng.polyFinance.lgd.service.BankListService;
import com.ptteng.polyFinance.lgd.service.UserBankService;
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
 * UserBank  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class UserBankController {
    private static final Log log = LogFactory.getLog(UserBankController.class);
    
    @Autowired
    private UserBankService userBankService;
    @Autowired
    private BankListService bankListService;
    
    @RequestMapping(value = "/a/u/userBank/list/{id}", method = RequestMethod.GET)
    public String getUserBankIdsByUserIdJsonList(ModelMap model, @PathVariable("id") Long id) throws Exception {
        
        Long userId = id;
        try {
            
            List<Long> ids = userBankService.getUserBankIdsByUserId(userId, 0, 10);
            log.info("get countUserBankIdsByUserId size is " + ids.size());
    
    
            List<UserBank> userBankList = new ArrayList<>();
           
            /*
            BankList bankList1 = bankListService.getObjectById(userBank1.getBankListId());
            
            userBank1.setBankList(bankList1);
            
             userBankList.add(userBank1);
            
            UserBank userBank2;
            if (ids.size() == 2) {
                userBank2 = userBankService.getObjectById(ids.get(1));
                BankList bankList2 = bankListService.getObjectById(userBank2.getBankListId());
                userBank2.setBankList(bankList2);
                userBankList.add(userBank2);
            }
             */
            UserBank userBank1 = userBankService.getObjectById(ids.get(0));
            
            log.info("get userBank data is " + userBankList.size());
            
            
            model.addAttribute("code", 0);
            
            
            model.addAttribute("userBankList", userBankList);
            
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get userBank list error, userId is " + userId);
            // for test
            model.addAttribute("code", -100000);
        }
        
        return "/polyFinance-lgd-server/userBank/json/userBankListJson";
    }
    
    
    @RequestMapping(value = "/a/userBank/{id}", method = RequestMethod.GET)
    public String getUserBankJson(HttpServletRequest request,
                                  HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {
        
        log.info("get data : id= " + id);
        try {
            UserBank userBank = userBankService.getObjectById(id);
            log.info("get userBank data is " + userBank);
            
            model.addAttribute("code", 0);
            
            model.addAttribute("userBank", userBank);
            
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get userBank error,id is  " + id);
            model.addAttribute("code", -100000);
        }
        
        return "/polyFinance-lgd-server/userBank/json/userBankDetailJson";
    }
    
    @RequestMapping(value = "/a/userBank/{id}", method = RequestMethod.PUT)
    public String updateUserBankJson(HttpServletRequest request,
                                     HttpServletResponse response, ModelMap model, UserBank userBank) throws Exception {
        
        log.info("update userBank : userBank= " + userBank);
        
        try {
            
            userBankService.update(userBank);
            
            model.addAttribute("code", 0);
            
            model.addAttribute("userBank", userBank);
            
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("update userBank error,id is  " + userBank.getId());
            model.addAttribute("code", -6003);
            
        }
        
        return "/data/json";
    }
    
    @RequestMapping(value = "/a/userBank", method = RequestMethod.POST)
    public String addUserBankJson(HttpServletRequest request,
                                  HttpServletResponse response, ModelMap model, UserBank userBank) throws Exception {
        
        log.info("update userBank : userBank= " + userBank);
        
        try {
            userBank.setId(null);
            
            userBankService.insert(userBank);
            
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add userBank error ");
            model.addAttribute("code", -6002);
        }
        
        return "/data/json";
    }
    
    @RequestMapping(value = "/a/userBank/{id}", method = RequestMethod.DELETE)
    public String deleteUserBankJson(HttpServletRequest request,
                                     HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {
        
        log.info("delete userBank : id= " + id);
        try {
            userBankService.delete(id);
            
            log.info("add userBank success");
            model.addAttribute("code", 0);
            
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("delete userBank error,id is  " + id);
            model.addAttribute("code", -6004);
            
        }
        
        return "/data/json";
    }
    
    
}

