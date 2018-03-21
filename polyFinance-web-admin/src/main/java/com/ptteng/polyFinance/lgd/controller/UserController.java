package com.ptteng.polyFinance.lgd.controller;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.util.SQLUtil;
import com.ptteng.polyFinance.lgd.model.User;
import com.ptteng.polyFinance.lgd.model.UserBank;
import com.ptteng.polyFinance.lgd.service.UserBankService;
import com.ptteng.polyFinance.lgd.service.UserService;
import com.ptteng.polyFinance.lgd.utils.DynamicUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
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
     *
     * @param user 请求参数
     * @param id   请求id。
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/user/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Object updateUserJson(User user, @PathVariable("id") Long id) throws Exception {
        
        log.info("update user : user id = " + id + " user  = " + user.getAccountsStatus());
        JSONObject a = new JSONObject();
        
        if (user.getAccountsStatus() != null) {
            try {
                user.setId(id);
//            userService.update(user);
                a.put("code", 0);
                a.put("message", "success");
            } catch (Throwable t) {
                t.printStackTrace();
                log.error(t.getMessage());
                log.error("update user error,id is  " + user.getId());
                a.put("code", -100000);
                a.put("message", "Server has something wrong");
            }
        } else {
            a.put("code", -200000);
            a.put("message", "necessary param missing");
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
        
        log.info("/a/u/user/list " + SQLUtil.convert2Sql(param, start, size));
        
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
        
//        Map<String, Object> param = DynamicUtil.getUserIdentifyList(name, phoneNum, identityStatus, identityTimeStart, identityTimeEnd, serialNum);
        
        try {
//            List<Long> ids = userService.getIdsByDynamicCondition(User.class, param, start, size);
//            List<User> users = userService.getObjectsByIds(ids);
            
        } catch (Throwable e) {
            
            e.printStackTrace();
        }
        
//        log.info("/a/u/user/list " + SQLUtil.convert2Sql(param, start, size));
        
        return "/polyFinance-lgd-server/user/json/userListJson";
    }
}

