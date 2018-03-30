package com.ptteng.polyFinance.lgd.controller;

import com.alibaba.fastjson.JSONObject;
import com.ptteng.polyFinance.lgd.model.UserBank;
import com.ptteng.polyFinance.lgd.service.UserBankService;
import com.ptteng.polyFinance.lgd.utils.CommonUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    
    /**
     * 后台：解绑用户银行卡
     *
     * @param model
     * @param id         用户id
     * @param userBankId 用户银行卡id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/userBank/{id}/{userBankId}", method = RequestMethod.DELETE, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String deleteUserBankJson(ModelMap model, @PathVariable Long id, @PathVariable Long userBankId) throws Exception {
        
        log.info("delete userBank : id= " + id + " ;userBankId + " + userBankId);
        JSONObject a = new JSONObject();
        if (CommonUtil.isEmpty(id, userBankId)) {
            a.put("code", -200000);
            a.put("message", "necessary param missing");
            return a.toString();
        }
        
        try {
            List<Long> ids = userBankService.getUserBankIdsByUserId(id, 0, Integer.MAX_VALUE);
            List<UserBank> userBanks = userBankService.getObjectsByIds(ids);
            for (UserBank bank : userBanks) {
                bank.setFirst(1);
                if (bank.getId().equals(userBankId)) {
                    bank.setFirst(0);
                }
            }
            userBankService.updateList(userBanks);
            //todo 事务管理
            userBankService.delete(userBankId);
            
            log.info("update userBank success");
            a.put("code", 0);
            a.put("message", "success");
            
            
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("delete userBank error ,  id= " + id + " ;userBankId + " + userBankId);
            model.addAttribute("code", -6004);
        }
        
        return a.toString();
    }
    
    
}

