package com.ptteng.polyFinance.lgd.controller;

import com.aliyun.oss.ServiceException;
import com.gemantic.common.exception.ServiceDaoException;
import com.ptteng.polyFinance.lgd.model.Admin;
import com.ptteng.polyFinance.lgd.service.AdminService;
import com.ptteng.polyFinance.lgd.utils.CommonUtil;
import com.ptteng.polyFinance.lgd.utils.SecureUtil;
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
 * Admin  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class AdminController {
    private static final Log log = LogFactory.getLog(AdminController.class);
    
    @Autowired
    private AdminService adminService;
    
    /**
     * 后台登陆
     *
     * @param modelMap  回显参数
     * @param loginName 登陆名称
     * @param pswd      登陆密码
     * @return 返回json-taglib页面.
     */
    @RequestMapping(value = "/a/l/admin/login", method = RequestMethod.PUT)
    public String adminLogin(ModelMap modelMap, String loginName, String pswd) {
        Admin admin;
        if (CommonUtil.isEmpty(loginName)) {
            modelMap.addAttribute("code", -200000);
        } else {
            try {
                admin = adminService.getObjectByLoginName(loginName);
                if (admin != null) {
                    String salt = admin.getSalt();
                    if (SecureUtil.messageDigest(pswd + salt).equals(admin.getPswd())) {
                        modelMap.addAttribute("code", 0);
                    } else {
                        modelMap.addAttribute("code", 4002);
                    }
                } else {
                    modelMap.addAttribute("code", 4001);
                }
            } catch (Throwable e) {
                modelMap.addAttribute("code", -100000);
                e.printStackTrace();
            }
        }
        
        
        return "polyFinance-lgd-server/admin/json/adminLoginJson";
    }
    
    /**
     * 新增管理员
     *
     * @param admin    需要创建的admin对象
     * @param modelMap 回显数据
     * @return json-taglib页面
     */
    @RequestMapping(value = "/a/u/admin", method = RequestMethod.POST)
    public String adminInsert(Admin admin, ModelMap modelMap) {
        if (CommonUtil.isEmpty(admin.getLoginName(), admin.getPswd(), admin.getAdminRoleId())) {
            modelMap.addAttribute("code", -200000);
        } else {
            try {
                if (adminService.getObjectByLoginName(admin.getLoginName()) != null) {
                    modelMap.addAttribute("code", 4003);
                } else {
                    admin.setUpdateAt(System.currentTimeMillis());
                    admin.setUpdateBy(007L);
                    admin.setCreateBy(007L);
                    admin.setCreateAt(System.currentTimeMillis());
                    String salt = SecureUtil.getSalt();
                    admin.setSalt(salt);
                    admin.setPswd(SecureUtil.messageDigest(admin.getPswd() + salt));
                    adminService.insert(admin);
                    modelMap.addAttribute("code", 0);
                }
            } catch (Throwable e) {
                modelMap.addAttribute("code", -100000);
                e.printStackTrace();
            }
            
        }
        return "polyFinance-lgd-server/admin/json/adminInsert";
    }
}

