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
 * 
 */
@Controller
public class AdminController {
    private static final Log log = LogFactory.getLog(AdminController.class);
    
    @Autowired
    private AdminService adminService;
    
    /**
     * 后台登陆
     * @param modelMap 回显参数
     * @param loginName 登陆名称
     * @param pswd  登陆密码
     * @return  返回json-taglib页面.
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
     * @param admin 需要创建的admin对象
     * @param modelMap 回显数据
     * @return  json-taglib页面
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
    
    /**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */

	@RequestMapping(value = "/c/admin", method = RequestMethod.GET)
	public String getadminList(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {

		
		
		log.info("/admin  to /admin/view/adminList");

		return "/polyFinance-lgd-server/admin/view/adminList";
	}
    
    
    @RequestMapping(value = "/c/admin/{id}", method = RequestMethod.GET)
    public String getAdmin(HttpServletRequest request,
                           HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {
        
        log.info("/admin/" + id + "  to /admin/view/adminDeail");
        if (null != id) {
            model.addAttribute("id", id);
        } else {
            model.addAttribute("id", 0);
        }
        
        return "/polyFinance-lgd-server/admin/view/adminDetail";
    }
    
    
    @RequestMapping(value = "/a/admin/{id}", method = RequestMethod.GET)
    public String getAdminJson(HttpServletRequest request,
                               HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {
        
        log.info("get data : id= " + id);
        try {
            Admin admin = adminService.getObjectById(id);
            log.info("get admin data is " + admin);
            
            model.addAttribute("code", 0);
            
            model.addAttribute("admin", admin);
            
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get admin error,id is  " + id);
            model.addAttribute("code", -100000);
        }
        
        return "/polyFinance-lgd-server/admin/json/adminDetailJson";
    }
    
    @RequestMapping(value = "/a/admin/{id}", method = RequestMethod.PUT)
    public String updateAdminJson(HttpServletRequest request,
                                  HttpServletResponse response, ModelMap model, Admin admin) throws Exception {
        
        log.info("update admin : admin= " + admin);
        
        try {
            
            adminService.update(admin);
            
            model.addAttribute("code", 0);
            
            model.addAttribute("admin", admin);
            
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("update admin error,id is  " + admin.getId());
            model.addAttribute("code", -6003);
            
        }
        
        return "/data/json";
    }
    
    @RequestMapping(value = "/a/admin", method = RequestMethod.POST)
    public String addAdminJson(HttpServletRequest request,
                               HttpServletResponse response, ModelMap model, Admin admin) throws Exception {
        
        log.info("update admin : admin= " + admin);
        
        try {
            admin.setId(null);
            
            adminService.insert(admin);
            
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add admin error ");
            model.addAttribute("code", -6002);
        }
        
        return "/data/json";
    }
    
    @RequestMapping(value = "/a/admin/{id}", method = RequestMethod.DELETE)
    public String deleteAdminJson(HttpServletRequest request,
                                  HttpServletResponse response, ModelMap model, @PathVariable Long id)
            throws Exception {
        
        log.info("delete admin : id= " + id);
        try {
            adminService.delete(id);
            
            log.info("add admin success");
            model.addAttribute("code", 0);
            
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("delete admin error,id is  " + id);
            model.addAttribute("code", -6004);
            
        }
        
        return "/data/json";
    }
    
    
    @RequestMapping(value = "/a/multi/admin", method = RequestMethod.GET)
    public String getMultiAdminJson(HttpServletRequest request,
                                    HttpServletResponse response, ModelMap model, Long[] ids)
            throws Exception {
        
        List<Long> idList = new ArrayList();
        if (ids == null) {
        
        } else {
            idList = Arrays.asList(ids);
        }
        try {
            
            
            List<Admin> adminList = adminService.getObjectsByIds(idList);
            log.info("get  admin data is " + adminList);
            
            model.addAttribute("code", 0);
            model.addAttribute("total", adminList.size());
            
            model.addAttribute("adminList", adminList);
            
        } catch (Throwable t) {
            log.error(t.getMessage());
            log.error("get admin error,id is  " + idList);
            model.addAttribute("code", -100000);
        }
        
        return "/polyFinance-lgd-server/admin/json/adminListJson";
    }
    
    
}

