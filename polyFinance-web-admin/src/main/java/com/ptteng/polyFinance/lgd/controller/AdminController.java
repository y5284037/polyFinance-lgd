package com.ptteng.polyFinance.lgd.controller;

import com.aliyun.oss.ServiceException;
import com.gemantic.common.exception.ServiceDaoException;
import com.ptteng.polyFinance.lgd.model.Admin;
import com.ptteng.polyFinance.lgd.service.AdminService;
import com.ptteng.polyFinance.lgd.utils.CommonUtil;
import com.ptteng.polyFinance.lgd.utils.SecureUtil;
import com.sun.org.apache.xpath.internal.operations.Mod;
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
    @RequestMapping(value = "/a/l/admin/login", method = RequestMethod.POST)
    public String adminLogin(ModelMap modelMap, String loginName, String pswd) {
        Admin admin;
        if (CommonUtil.isEmpty(loginName, pswd)) {
            modelMap.addAttribute("code", -200);
        } else {
            try {
                admin = adminService.getObjectByLoginName(loginName);
                if (admin != null) {
                    String salt = admin.getSalt();
                    if (SecureUtil.messageDigest(pswd + salt).equals(admin.getPswd())) {
                        modelMap.addAttribute("code", 0);
                        modelMap.addAttribute("id", admin.getId());
                    } else {
                        modelMap.addAttribute("code", 4002);
                    }
                } else {
                    modelMap.addAttribute("code", 4001);
                }
            } catch (Throwable e) {
                modelMap.addAttribute("code", -100);
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
            modelMap.addAttribute("code", -200);
        } else {
            try {
                if (adminService.getObjectByLoginName(admin.getLoginName()) != null) {
                    modelMap.addAttribute("code", 4003);
                } else {
                    admin.setUpdateAt(System.currentTimeMillis());
                    admin.setUpdateBy(7L);
                    admin.setCreateBy(7L);
                    admin.setCreateAt(System.currentTimeMillis());
                    String salt = SecureUtil.getSalt();
                    admin.setSalt(salt);
                    admin.setPswd(SecureUtil.messageDigest(admin.getPswd() + salt));
                    adminService.insert(admin);
                    modelMap.addAttribute("code", 0);
                }
            } catch (Throwable e) {
                modelMap.addAttribute("code", -100);
                e.printStackTrace();
            }
            
        }
        return "polyFinance-lgd-server/admin/json/adminInsert";
    }
    
    /**
     * 后台管理员修改密码接口
     *
     * @param modelMap
     * @param id          管理员id
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return
     */
    @RequestMapping(value = "a/u/admin/pswd", method = RequestMethod.PUT)
    public String changePswd(ModelMap modelMap, Long id, String oldPassword, String newPassword) {
        if (CommonUtil.isEmpty(id, oldPassword, newPassword)) {
            modelMap.addAttribute("code", -200);
            return "polyFinance-lgd-server/admin/json/adminChangePSWD";
        }
        try {
            Admin admin = adminService.getObjectById(id);
            if (admin.getPswd().equals(SecureUtil.messageDigest(oldPassword + admin.getSalt()))) {
                String salt = SecureUtil.getSalt();
                admin.setPswd(SecureUtil.messageDigest(newPassword + salt));
                admin.setSalt(salt);
                adminService.update(admin);
                modelMap.addAttribute("code", 0);
            } else {
                modelMap.addAttribute("code", 4002);
            }
        } catch (Throwable e) {
            modelMap.addAttribute("code", -100);
            e.printStackTrace();
        }
        return "polyFinance-lgd-server/admin/json/adminChangePSWD";
    }
    
    /**
     * 删除管理员的接口
     *
     * @param modelMap
     * @param id       管理员ID
     * @return
     */
    @RequestMapping(value = "/a/u/admin/{id}", method = RequestMethod.DELETE)
    public String deleteAdmin(ModelMap modelMap, @PathVariable Long id) {
        if (CommonUtil.isEmpty(id)) {
            modelMap.addAttribute("code", -200);
            return "polyFinance-lgd-server/admin/json/adminDelete";
        }
        if (id == 1) {
            modelMap.addAttribute("code", -300);
            return "polyFinance-lgd-server/admin/json/adminDelete";
        }
        try {
            adminService.delete(id);
            modelMap.addAttribute("code", 0);
        } catch (Throwable e) {
            modelMap.addAttribute("code", -100);
            e.printStackTrace();
        }
        return "polyFinance-lgd-server/admin/json/adminDelete";
        
    }
    
    /**
     * 查询所有管理列表接口
     *
     * @param modelMap
     * @param page     当前显示页数
     * @param size     每页数量
     * @return
     */
    @RequestMapping(value = "/a/u/admin/list", method = RequestMethod.GET)
    public String getAdminAll(ModelMap modelMap, Integer page, Integer size) {
        if (CommonUtil.isEmpty(page)) {
            page = 1;
        }
        if (CommonUtil.isEmpty(size)) {
            size = 10;
        }
        int start = (page - 1) * size;
        if (start < 0) {
            start = 0;
        }
        try {
            List<Long> ids = adminService.getAdminIds(start, size);
            List<Admin> admins = adminService.getObjectsByIds(ids);
            modelMap.addAttribute("adminList", admins);
            modelMap.addAttribute("total", adminService.countAdminIds());
            modelMap.addAttribute("size", size);
            modelMap.addAttribute("code", 0);
        } catch (Throwable e) {
            modelMap.addAttribute("code", -100);
            e.printStackTrace();
        }
        return "polyFinance-lgd-server/admin/json/adminListJson";
    }
}

