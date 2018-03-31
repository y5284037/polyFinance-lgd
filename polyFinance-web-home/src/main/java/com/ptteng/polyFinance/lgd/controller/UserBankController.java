package com.ptteng.polyFinance.lgd.controller;

import com.alibaba.fastjson.JSONObject;
import com.gemantic.common.util.MyListUtil;
import com.ptteng.polyFinance.lgd.model.BankList;
import com.ptteng.polyFinance.lgd.model.User;
import com.ptteng.polyFinance.lgd.model.UserBank;
import com.ptteng.polyFinance.lgd.service.BankListService;
import com.ptteng.polyFinance.lgd.service.UserBankService;
import com.ptteng.polyFinance.lgd.service.UserService;
import com.ptteng.polyFinance.lgd.utils.CommonUtil;
import com.ptteng.polyFinance.lgd.utils.FilesUtil;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private UserService userService;
    
    /**
     * 前台：用户银行卡列表
     *
     * @param model
     * @param id    用户id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/userBank/list/{id}", method = RequestMethod.GET)
    public String getUserBankIdsByUserIdJsonList(ModelMap model, @PathVariable("id") Long id) throws Exception {
        
        Long userId = id;
        try {
            
            List<Long> ids = userBankService.getUserBankIdsByUserId(userId, 0, 10);
            
            log.info("get countUserBankIdsByUserId size is " + ids.size());
            
            
            List<UserBank> userBankList = userBankService.getObjectsByIds(ids);
            List<Long> bankListIds = MyListUtil.getList(UserBank.class.getDeclaredField("bankListId"), userBankList);
            
            List<BankList> bankLists = bankListService.getObjectsByIds(bankListIds);
            for (BankList bankList : bankLists) {
                String url = FilesUtil.getUrl(bankList.getLogoPic());
                bankList.setLogoPic(url);
            }
            
            Map<Long, BankList> map = MyListUtil.convert2Map(BankList.class.getDeclaredField("id"), bankLists);
            
            String sing = map.get(bankListIds.get(0)).getSingleTransactionLimit();
            
            
            UserBank userBank1 = userBankService.getObjectById(ids.get(0));
            
            
            log.info("get userBank data is " + userBankList.size());
            
            
            model.addAttribute("code", 0);
            
            
            model.addAttribute("userBankList", userBankList);
            model.addAttribute("map", map);
            
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get userBank list error, userId is " + userId);
            // for test
            model.addAttribute("code", -100);
        }
        
        return "/polyFinance-lgd-server/userBank/json/userBankListJson";
    }
    
    
    /**
     * 前台：更换默认银行卡
     *
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/userBank/{id}", method = RequestMethod.PUT, produces = "text/html;charset=UTF-8")
    @ResponseBody
    
    public String updateUserBankJson(@PathVariable("id") Long id, ModelMap model, Long userBankId) throws Exception {
        log.info("update userBank : userBankId= " + userBankId);
        JSONObject a = new JSONObject();
        if (CommonUtil.isEmpty(id, userBankId)) {
            a.put("code", -200);
            a.put("message", "necessary param missing");
            return a.toString();
        }
        try {
            List<Long> userBankIds = userBankService.getUserBankIdsByUserId(id, 0, Integer.MAX_VALUE);
            List<UserBank> userBanks = userBankService.getObjectsByIds(userBankIds);
            for (UserBank bank : userBanks) {
                bank.setFirst(0);
                if (bank.getId().equals(userBankId)) {
                    bank.setFirst(1);
                }
            }
            Boolean flag = userBankService.updateList(userBanks);
            if (flag) {
                a.put("code", 0);
                a.put("message", "success");
            }
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("update userBank error,id is  " + userBankId);
            a.put("code", -100);
            a.put("message", "Server has something wrong");
        }
        return a.toString();
    }
    
    /**
     * 前台：用户添加银行卡
     * （只能绑定两张）
     *
     * @param model
     * @param id    用户id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/userBank/{id}", method = RequestMethod.POST)
    public String addUserBankJson(@PathVariable("id") Long id, ModelMap model, String city, String bankName, String cardNo, String bankPhone, Long bankListId) throws Exception {
        
        log.info("insert userBank : userId= " + id + " bankname= " + bankName + " cardNo= " + cardNo);
        UserBank userBank = new UserBank();
        if (CommonUtil.isEmpty(id, cardNo, city, bankName, bankPhone)) {
            model.addAttribute("code", -200);
            return "/polyFinance-lgd-server/userBank/json/userBankDetailJson";
        }
        try {
            userBank.setId(null);
            userBank.setUserId(id);
            userBank.setCardNo(cardNo);
            userBank.setBankName(bankName);
            userBank.setCity(city);
            userBank.setBankPhone(bankPhone);
            userBank.setCreateBy(id);
            userBank.setBankListId(bankListId);
            List<Long> ids = userBankService.getUserBankIdsByUserId(id, 0, Integer.MAX_VALUE);
            if (ids.size() == 0) {
                userBank.setFirst(1);
            } else if (ids.size() == 2) {
                model.addAttribute("code", -3001);
                return "/polyFinance-lgd-server/userBank/json/userBankDetailJson";
            }
            userBankService.insert(userBank);
            model.addAttribute("code", 0);
            
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add userBank error ");
            model.addAttribute("code", -100);
        }
        
        return "/polyFinance-lgd-server/userBank/json/userBankDetailJson";
    }
    
    
}

