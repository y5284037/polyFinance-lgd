package com.ptteng.polyFinance.lgd.controller;

import com.alibaba.fastjson.JSONObject;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.util.SQLUtil;
import com.ptteng.polyFinance.lgd.model.User;
import com.ptteng.polyFinance.lgd.model.UserBank;
import com.ptteng.polyFinance.lgd.service.UserBankService;
import com.ptteng.polyFinance.lgd.service.UserService;
import com.ptteng.polyFinance.lgd.utils.CommonUtil;
import com.ptteng.polyFinance.lgd.utils.DynamicUtil;
import com.ptteng.polyFinance.lgd.utils.FilesUtil;
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
import java.util.Map;

/**
 * User  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class UserController {
    private static final Log log = LogFactory.getLog(UserController.class);
    
    @Autowired
    private UserService userService;
    @Autowired
    private UserBankService userBankService;
    
    /**
     * 后台：查看用户详情
     *
     * @param model
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/user/{id}", method = RequestMethod.GET)
    public String getUserJson(ModelMap model, @PathVariable Long id) throws Exception {
        
        log.info("get data : id= " + id);
        try {
            User user = userService.getObjectById(id);
            log.info("get user data is " + user);
            
            model.addAttribute("code", 0);
            
            model.addAttribute("user", user);
            
            List<Long> userBankIds = userBankService.getUserBankIdsByUserId(id, 0, 10);
            
            List<UserBank> userbanks = userBankService.getObjectsByIds(userBankIds);
            
            log.info("get userbanks data is " + userbanks);
            
            model.addAttribute("userBankList", userbanks);
            
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get user error,id is  " + id);
            model.addAttribute("code", -100000);
        }
        
        return "/polyFinance-lgd-server/user/json/userDetailAndBankListJson";
    }
    
    /**
     * 后台：用户冻结与解冻
     * 已测
     *
     * @param accountsStatus 用户状态
     * @param id             请求id。
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/user/{id}", method = RequestMethod.PUT, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public Object updateUserJson(Integer accountsStatus, @PathVariable("id") Long id) throws Exception {
        
        log.info("update user : user id = " + id + " user accountsStatus  = " + accountsStatus);
        JSONObject a = new JSONObject();
        if (CommonUtil.isEmpty(accountsStatus)) {
            
            a.put("code", -200000);
            a.put("message", "necessary param missing");
            return a.toString();
        }
        
        try {
            User userGet = userService.getObjectById(id);
            if (userGet == null) {
                log.error("update user with error id , id is  " + id);
                a.put("code", -200000);
                a.put("message", "necessary param missing");
                return a.toString();
            }
            userGet.setAccountsStatus(accountsStatus);
            userService.update(userGet);
            a.put("code", 0);
            a.put("message", "success");
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("update user error,id is  " + id);
            a.put("code", -100000);
            a.put("message", "Server has something wrong");
            return a.toString();
        }
        
        return a.toString();
    }
    
    
    /**
     * 后台:用户列表
     *
     * @param model
     * @param name           用户名
     * @param phoneNum       用户手机号
     * @param accountsStatus 状态
     * @param createAtStart  注册时间起
     * @param createAtEnd    注册时间至
     * @param managerNum     理财经理
     * @param page           页数
     * @param size           查询个数
     * @return
     */
    
    @RequestMapping(value = "/a/u/user/list", method = RequestMethod.GET)
    public String getUserList(ModelMap model, String name, String phoneNum, Integer accountsStatus, Long createAtStart, Long createAtEnd, String managerNum, Integer page, Integer size) {
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
        
        Map<String, Object> param = DynamicUtil.getUserListSql(name, phoneNum, accountsStatus, createAtStart, createAtEnd, managerNum);
        
        log.info("DynamicCondition SQL : getUserListSql " + SQLUtil.convert2Sql(param, start, size));
        
        try {
            List<Long> ids = userService.getIdsByDynamicCondition(User.class, param, start, size);
            List<User> users = userService.getObjectsByIds(ids);
            
            Integer total = userService.countUserIds();
            
            model.addAttribute("code", 0);
            model.addAttribute("total", total);
            model.addAttribute("userList", users);
        } catch (Throwable e) {
            log.info(e.getMessage());
            log.info("get user list error");
            e.printStackTrace();
            model.addAttribute("code", -100000);
        }
        
        return "/polyFinance-lgd-server/user/json/userListJson";
    }
    
    /**
     * 后台：用户实名认证列表
     * 已测
     *
     * @param model
     * @param name
     * @param phoneNum
     * @param identityStatus
     * @param identityTimeStart
     * @param identityTimeEnd
     * @param serialNum
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/a/u/user/identify/list", method = RequestMethod.GET)
    public String getUserIdentifyList(ModelMap model, String name, String phoneNum, Integer identityStatus, Long identityTimeStart, Long identityTimeEnd, String serialNum, Integer page, Integer size) {
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
        
        Map<String, Object> param = DynamicUtil.getUserIdentifyList(name, phoneNum, identityStatus, identityTimeStart, identityTimeEnd, serialNum);
        log.info("DynamicCondition SQL : getUserIdentifyList---->>> " + SQLUtil.convert2Sql(param, start, size));
        
        try {
            List<Long> ids = userService.getIdsByDynamicCondition(User.class, param, start, size);
            List<Long> countIds = userService.getIdsByDynamicCondition(User.class, param, 0, userService.countUserIds());
            Integer total = countIds.size();
            
            List<User> users = userService.getObjectsByIds(ids);
            model.addAttribute("userList", users);
            model.addAttribute("total", total);
            model.addAttribute("code", 0);
            
        } catch (Throwable e) {
            log.info(e.getMessage());
            log.info("get user list error");
            e.printStackTrace();
            model.addAttribute("code", -100000);
            e.printStackTrace();
        }
        
        return "/polyFinance-lgd-server/user/json/userListJson";
    }
    
    /**
     * 后台：操作用户实名状态
     * 已测
     *
     * @param id             用户id
     * @param identityStatus 用户实名状态
     * @param refuseReason   拒绝理由
     * @return
     */
    @RequestMapping(value = "/a/u/user/identify/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String updateUserIdentifyStatus(@PathVariable("id") Long id, Integer identityStatus, String refuseReason) {
        log.info("updateUserIdentifyStatus : id = " + id + " ; " + " identityStatus= " + identityStatus);
        JSONObject a = new JSONObject();
        if (CommonUtil.isEmpty(identityStatus, id)) {
            a.put("code", -200000);
            a.put("message", "necessary param wrong");
            return a.toString();
        }
        Boolean flag;
        try {
            User userGet = userService.getObjectById(id);
            if (userGet == null) {
                log.error("update user error , id is  " + id);
                a.put("code", -200000);
                a.put("message", "necessary param missing");
                return a.toString();
            }
            //identityStatus 3:取消实名
            userGet.setRefuseReason(refuseReason);
            if (identityStatus.equals(3)) {
                userGet.setName("");
                userGet.setIdCard("");
                userGet.setIdCardFornt("");
                userGet.setIdCardBack("");
                userGet.setRefuseReason("");
            }
            if (identityStatus.equals(2)) {
                if (CommonUtil.isEmpty(refuseReason)) {
                    a.put("code", -200000);
                    a.put("message", "necessary param wrong");
                    return a.toString();
                }
            }
            if (!identityStatus.equals(1)) {
                userGet.setRefuseStatus(1);
            }
            userGet.setIdentityStatus(identityStatus);
            flag = userService.update(userGet);
            if (flag) {
                a.put("code", 0);
                a.put("message", "success");
            }
            
        } catch (Throwable e) {
            log.error(e);
            e.printStackTrace();
            log.error("updateUserIdentifyStatus , id  is  " + id);
            a.put("code", -100000);
            a.put("message", "Server has something wrong");
        }
        return a.toString();
    }
    
    /**
     * 后台：查询用户实名详情
     *
     * @param model
     * @param id    用户id
     * @return
     */
    @RequestMapping(value = "/a/u/user/identify/{id}")
    public String getUserIdentifyDetail(ModelMap model, @PathVariable("id") Long id) {
        log.info("getUserIdentifyDetail : user id = " + id);
        try {
            User userGet = userService.getObjectById(id);
            if (userGet == null) {
                log.error("get user with error id , id is  " + id);
                model.addAttribute("code", -200000);
                return "/polyFinance-lgd-server/user/json/userDetailJson";
            }
            String idCardFrontUrl = FilesUtil.getUrl(userGet.getIdCardFornt());
            String idCardBackUrl = FilesUtil.getUrl(userGet.getIdCardBack());
            userGet.setIdCardFornt(idCardFrontUrl);
            userGet.setIdCardBack(idCardBackUrl);
            model.addAttribute("code", 0);
            model.addAttribute("user", userGet);
        } catch (Throwable e) {
            log.error(e);
            e.printStackTrace();
            log.error("get user error");
            model.addAttribute("code", -100000);
            e.printStackTrace();
        }
        
        return "/polyFinance-lgd-server/user/json/userDetailJson";
    }
    
   
}

