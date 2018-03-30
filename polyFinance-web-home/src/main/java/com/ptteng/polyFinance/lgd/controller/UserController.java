package com.ptteng.polyFinance.lgd.controller;

import com.alibaba.fastjson.JSONObject;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.User;
import com.ptteng.polyFinance.lgd.model.UserBank;
import com.ptteng.polyFinance.lgd.service.UserBankService;
import com.ptteng.polyFinance.lgd.service.UserService;
import com.ptteng.polyFinance.lgd.utils.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

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
     * 前台：用户登录
     *
     * @param phoneNum 注册手机号码
     * @param pswd     密码
     * @return 状态码，消息
     */
    
    @RequestMapping(value = "/a/login", method = RequestMethod.POST)
    public String userLogin(HttpServletResponse response, ModelMap model, String phoneNum, String pswd) {
        
        if (phoneNum == null || phoneNum.equals("") || pswd == null || pswd.equals("")) {
            model.addAttribute("code", -200000);
            return "/polyFinance-lgd-server/user/json/userDetailJson";
        }
        
        log.info("/a/login" + phoneNum);
        try {
            User user = userService.getObjectByPhoneNum(phoneNum);
            if (user != null) {
                // 用户状态校验
                if(user.getAccountsStatus()==1){
                    model.addAttribute("code",4003);
                    return "/polyFinance-lgd-server/user/json/userDetailJson";
                }
                String pswdCheck = SecureUtil.messageDigest(user.getSalt() + pswd);
                if (pswdCheck.equals(user.getPswd())) {
                    
                    model.addAttribute("code", 0);
                    //todo 设置cookie
                    
                    Cookie cookie = new Cookie("tendk.com", user.getId() + "");
                    response.addCookie(cookie);
                    
                    
                } else {
                    model.addAttribute("code", 4002);
                }
            } else {
                model.addAttribute("code", 4001);
            }
            
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (ServiceDaoException e) {
            log.error("get user error by phoneNum" + phoneNum);
            log.error(e);
            e.printStackTrace();
        }
        
        return "/polyFinance-lgd-server/user/json/userDetailJson";
    }
    
    /**
     * 前台：用户注册
     *
     * @param model    返回code
     * @param phoneNum 注册手机号
     * @param pswd     密码
     * @param verify   验证码
     * @return
     */
    @RequestMapping(value = "/a/user/register", method = RequestMethod.POST)
    public String userRegister(HttpSession session, ModelMap model, String phoneNum, String pswd, String verify) {
        
        
        String checkCode = (String) session.getAttribute("code");
        String checkphoneNum = (String) session.getAttribute("phoneNum");
        
        
        User user = new User();
        
        if (phoneNum != null && !phoneNum.equals("")) {
            if (pswd != null && !pswd.equals("")) {
                if (verify != null && !verify.equals("")) {
                    log.info("/a/user/register" + phoneNum);
                    if (phoneNum.equals(checkphoneNum) && verify.equals(checkCode)) {
                        try {
                            User check = userService.getObjectByPhoneNum(phoneNum);
                            if (check != null) {
                                model.addAttribute("code", 4003);
                                return "/polyFinance-lgd-server/user/json/userDetailJson";
                            }
                        } catch (Throwable e) {
                            log.error(e);
                            log.error("get user by phone error " + phoneNum);
                            e.printStackTrace();
                        }
                        
                        String salt = SecureUtil.getSalt();
                        user.setId(null);
                        user.setPhoneNum(phoneNum);
                        user.setPswd(SecureUtil.messageDigest(salt + pswd));
                        user.setSalt(salt);
                        user.setAccountsStatus(0);
                        user.setIncome(new BigDecimal(0.00));
                        user.setTotalProperty(new BigDecimal(0.00));
                        user.setIdentityStatus(0);
                        
                        Long id = null;
                        Boolean flag = null;
                        try {
                            id = userService.insert(user);
                            
                            
                        } catch (Throwable e) {
                            log.error(" insert wrong : " + user);
                            log.error(e);
                            e.printStackTrace();
                        }
                        
                        
                        try {
                            User temp = userService.getObjectById(id);
                            temp.setSerialNum(UserSerialNumUtil.getUserSerialNum(id));
                            flag = userService.update(temp);
                        } catch (Throwable e) {
                            log.error(" update wrong : " + UserSerialNumUtil.getUserSerialNum(id));
                            log.error(e);
                            e.printStackTrace();
                        }
                        if (flag) {
                            model.addAttribute("code", 0);
                        } else {
                            model.addAttribute("code", -100000);
                        }
                        
                        
                    } else {
                        model.addAttribute("code", -2003);
                    }
                    
                } else {
                    model.addAttribute("code", -2002);
                }
            } else {
                model.addAttribute("code", -2005);
            }
            
        } else {
            model.addAttribute("code", -2004);
        }
        
        
        return "/polyFinance-lgd-server/user/json/userDetailJson";
    }
    
    @RequestMapping(value = "/test", method = RequestMethod.PUT)
    public String test(HttpServletRequest request, String name) {
        
        System.out.println(name);
        return name;
    }
    
    /**
     * 前台：用户忘记密码接口
     *
     * @param session session
     * @param mobile  手机号
     * @param verify  验证码
     * @param pswd    密码
     * @return
     */
    @RequestMapping(value = "/a/user/forget", method = RequestMethod.PUT, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String fogetPswd(HttpSession session, String mobile, String verify, String pswd) {
        
        JSONObject model = new JSONObject();
        
        
        if (CommonUtil.isEmpty(mobile, verify, pswd)) {
            
            model.put("code", -200000);
            model.put("message", "necessary param wrong 参数错误1");
            return model.toString();
        }
        
        String checkMobile = (String) session.getAttribute("phoneNum");
        String checkCode = (String) session.getAttribute("code");
        if (!mobile.equals(checkMobile) || !verify.equals(checkCode)) {
            model.put("code", -2003);
            model.put("message", "验证码错误");
            return model.toString();
        }
        
        Boolean flag;
        try {
            User user = userService.getObjectByPhoneNum(mobile);
            if (user != null) {
                String newPswd = SecureUtil.messageDigest(user.getSalt() + pswd);
                user.setPswd(newPswd);
                user.setUpdateBy(user.getId());
                flag = userService.update(user);
                if (flag) {
                    model.put("code", 0);
                    model.put("message", "success");
                    //todo 清空session
//                    session.invalidate();
                } else {
                    model.put("code", -100000);
                    model.put("message", "Server has something wrong");
                }
            } else {
                model.put("code", 4001);
                model.put("message", "用户不存在");
            }
            
        } catch (Throwable e) {
            log.error("update user pswd" + mobile);
            log.error(e);
            e.printStackTrace();
        }
        return model.toString();
    }
    
    
    /**
     * 前台：用户修改密码
     *
     * @param id      用户id
     * @param oldPswd 旧密码
     * @param newPswd 新密码
     * @return
     */
    @RequestMapping(value = "/a/u/user/pswd", method = RequestMethod.PUT, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String modifyPswd(HttpSession session,Long id, String oldPswd, String newPswd) {
        JSONObject a = new JSONObject();
        
        if (CommonUtil.isEmpty(id, oldPswd, newPswd)) {
            a.put("code", -200000);
            a.put("message", "necessary param missing");
            return a.toString();
        }
        
        Boolean flag;
        log.info("update user pswd user id : " + id);
        try {
            User user = userService.getObjectById(id);
            if (user == null) {
                a.put("code", 4001);
                a.put("message", "error user id");
                return a.toString();
            }
            String checkPswd = SecureUtil.messageDigest(user.getSalt() + oldPswd);
            if (checkPswd.equals(user.getPswd())) {
                user.setPswd(SecureUtil.messageDigest(user.getSalt() + newPswd));
                flag = userService.update(user);
                if (flag) {
                    a.put("code", 0);
                    a.put("message", "success");
                    //todo 清空session
                    session.invalidate();
                }
            } else {
                a.put("code", 4002);
                a.put("message", "旧密码错误");
            }
            
        } catch (Throwable e) {
            log.error("get user error" + id);
            log.error(e);
            e.printStackTrace();
        }
        return a.toString();
    }
    
    
    /**
     * 前台：用户实名申请
     *
     * @param id      用户id
     * @param name    用户姓名
     * @param idCard  用户身份证号码
     * @param idFront 正面
     * @param idBack  反面
     * @return
     */
    @RequestMapping(value = "/a/u/user/identifyDetails/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String updateUserVerifyDetail(@PathVariable("id") Long id, String name, String idCard, MultipartFile idFront, MultipartFile idBack) {
        
        JSONObject a = new JSONObject();
        if (CommonUtil.isEmpty(id, name, idCard)) {
            a.put("code", -200000);
            a.put("message", "necessary param missing");
            return a.toString();
        }
        
        Boolean flag;
        log.info("update user identify user :" + name + ";" + idCard);
        try {
            User userGet = userService.getObjectById(id);
            if (userGet == null) {
                a.put("code", 4001);
                a.put("message", "error user id");
                return a.toString();
            }
            userGet.setName(name);
            userGet.setIdCard(idCard);
           
            String idFrontUrl = FilesUtil.upLoadFile(idFront);
            String idBackUrl = FilesUtil.upLoadFile(idBack);
            if (idFrontUrl == null || idFrontUrl.equals("") || idBackUrl == null || idBackUrl.equals("")) {
                log.error("pictrue error");
            }
            userGet.setIdCardFornt(idFrontUrl);
            userGet.setIdCardBack(idBackUrl);
            userGet.setUpdateBy(Long.valueOf("100" + id.toString()));
            userGet.setIdentityTime(System.currentTimeMillis());
            flag = userService.update(userGet);
            if (flag) {
                a.put("code", 0);
                a.put("message", "success");
                log.info("uodate user idCard pic success");
            } else {
                a.put("code", -100000);
                a.put("message", "Server has something wrong");
                
            }
        } catch (Throwable e) {
            log.info(e);
            log.error("update user idCard pic SCA service  error");
            a.put("code", -100000);
            a.put("message", "Server has something wrong");
            e.printStackTrace();
        }
        return a.toString();
    }
    
    
    /**
     * 前台：获取用户账户设置详情接口
     *(user 的user_bank_id 废弃。)
     * @param model
     * @param id    用户id
     * @return
     */
    @RequestMapping(value = "/a/u/user/set/{id}", method = RequestMethod.GET)
    public String getUserSettingDetailById(ModelMap model, @PathVariable("id") Long id) {
        
        log.info("get data : id= " + id);
        try {
            User user = userService.getObjectById(id);
            log.info("get user data is " + user);
            Long firstUserBankId = userBankService.getUserBankIdByUserIdAndFirst(id, 1);
            if (!CommonUtil.isEmpty(firstUserBankId)) {
                UserBank detail = userBankService.getObjectById(firstUserBankId);
                String userBankFirst = CommonUtil.getUserBankInfo(detail);
                model.addAttribute("userBankFirst", userBankFirst);
            }
            
            
            model.addAttribute("code", 0);
            model.addAttribute("user", user);
            
            
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get user error,id is  " + id);
            model.addAttribute("code", -100000);
        }
        return "/polyFinance-lgd-server/user/json/userDetailJson";
    }
    
    
    /**
     * 前台：用户账户设置
     *
     * @param id
     * @param email
     * @param address
     * @return
     */
    @RequestMapping(value = "/a/u/user/set/{id}", method = RequestMethod.PUT, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String updateUserSetByid(@PathVariable("id") Long id, String email, String address) {
        JSONObject a = new JSONObject();
        Boolean flag;
        if (CommonUtil.isEmpty(id)) {
            a.put("code", -200000);
            a.put("message", "necessary param wrong");
            return a.toString();
        }
        
        try {
            User userGet = userService.getObjectById(id);
            userGet.setEmail(email);
            userGet.setAddress(address);
            flag = userService.update(userGet);
            if (flag) {
                a.put("code", 0);
                a.put("message", "success");
            }
        } catch (Throwable e) {
            log.error(e.getMessage());
            e.printStackTrace();
            a.put("code", -100000);
            a.put("message", "Server has something wrong");
            return a.toString();
        }
        
        return a.toString();
    }
    
    /**
     * 前台：查询用户账户详情
     *
     * @param id    用户详情
     * @param model
     * @return
     */
    @RequestMapping(value = "/a/u/user/detail/{id}", method = RequestMethod.GET)
    public String getUserDetail(@PathVariable("id") Long id, ModelMap model) {
        log.info("get data : id= " + id);
        try {
            User user = userService.getObjectById(id);
            log.info("get user data is " + user);
            
            model.addAttribute("code", 0);
            model.addAttribute("user", user);
            
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get user error,id is  " + id);
            model.addAttribute("code", -100000);
        }
        return "/polyFinance-lgd-server/user/json/userDetailJson";
        
    }
    
    /**
     * 前台：发送验证码
     *
     * @param session
     * @param phoneNum 手机号
     * @param type     发送类型
     * @return
     */
    @RequestMapping(value = "/a/code/send", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String getUserCode(HttpSession session, String phoneNum, String type) {
        JSONObject a = new JSONObject();
        
        if (CommonUtil.isEmpty(phoneNum, type)) {
            a.put("code", -2000000);
            a.put("message", "necessary param wrong");
            return a.toString();
        }
        
        log.info("/a/code/send " + phoneNum + ";" + type);
        if (type.equals("register")) {
            try {
                User user = userService.getObjectByPhoneNum(phoneNum);
                if (user != null) {
                    a.put("code", 4003);
                    a.put("message", "用户已存在");
                    return a.toString();
                }
                String code = SMSutil.random(6);
                try {
                    SMSutil.sendSms(code, phoneNum);
                } catch (Exception e) {
                    log.error(e);
                    log.error("SMS service error");
                    a.put("code", -1000000);
                    a.put("message", "SMS service error");
                    return a.toString();
                }
                session.setAttribute("phoneNum", phoneNum);
                session.setAttribute("code", code);
                //todo 测试用session时间15小时
                session.setMaxInactiveInterval(15 * 60 * 60);
                a.put("code", 0);
                a.put("message", "success");
            } catch (Throwable e) {
                log.error(e);
                log.error("/a/code/send " + "get user error" + phoneNum);
                e.printStackTrace();
                a.put("code", -1000000);
                a.put("message", "SMS OR RMI  service error");
            }
        } else if (type.equals("password")) {
            try {
                User user = userService.getObjectByPhoneNum(phoneNum);
                if (user == null) {
                    a.put("code", 4003);
                    a.put("message", "用户不存在");
                    return a.toString();
                }
                String code = SMSutil.random(6);
                try {
                    SMSutil.sendSms(code, phoneNum);
                } catch (Exception e) {
                    log.error(e);
                    log.error("SMS service error");
                    a.put("code", -1000000);
                    a.put("message", "SMS service error");
                    return a.toString();
                }
                session.setAttribute("phoneNum", phoneNum);
                session.setAttribute("code", code);
                //todo 测试用session时间15小时
                session.setMaxInactiveInterval(15 * 60 * 60);
                a.put("code", 0);
                a.put("message", "success");
            } catch (Throwable e) {
                log.error(e);
                log.error("/a/code/send " + "get user error" + phoneNum);
                e.printStackTrace();
                a.put("code", -1000000);
                a.put("message", "SMS OR RMI  service error");
            }
        } else {
            a.put("code", -2006);
            a.put("message", "wrong type");
            return a.toString();
        }
        
        
        return a.toString();
    }
}

