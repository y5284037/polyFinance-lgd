package com.ptteng.polyFinance.lgd.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gemantic.common.util.MyListUtil;
import com.ptteng.polyFinance.lgd.model.AdminRole;
import com.ptteng.polyFinance.lgd.model.Authority;
import com.ptteng.polyFinance.lgd.service.AdminRoleService;
import com.ptteng.polyFinance.lgd.service.AuthorityService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * AdminRole  crud
 *
 * @author magenm
 * @Date 2014-4-16 13:43
 */
@Controller
public class AdminRoleController {
    private static final Log log = LogFactory.getLog(AdminRoleController.class);
    
    @Autowired
    private AdminRoleService adminRoleService;
    @Autowired
    private AuthorityService authorityService;
    
    /**
     * @param model
     * @param id    角色id
     * @return 角色详情，角色权限对应的模块id
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/adminRole/{id}", method = RequestMethod.GET)
    public String getAdminRoleJson(ModelMap model, @PathVariable Long id)
            throws Exception {
        
        log.info("get data : id= " + id);
        try {
            AdminRole adminRole = adminRoleService.getObjectById(id);
            
            List<Long> ids = authorityService.getAuthorityIdsByAdminRoleId(id, 0, Integer.MAX_VALUE);
            List<Authority> authorityList = authorityService.getObjectsByIds(ids);
            
            List<Long> moduleIds = MyListUtil.getList(Authority.class.getDeclaredField("moduleId"), authorityList);
            
            log.info("get adminRole data is " + adminRole);
            
            model.addAttribute("code", 0);
            
            model.addAttribute("adminRole", adminRole);
            
            model.addAttribute("moduleIds", moduleIds);
            
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("get adminRole error,id is  " + id);
            model.addAttribute("code", -100);
        }
        
        return "/polyFinance-lgd-server/adminRole/json/adminRoleDetailJson";
    }
    
    /**
     * 后台：修改角色接口
     *
     * @param id 角色id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/adminRole/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public String updateAdminRoleJson(@PathVariable Long id, @RequestBody JSONObject jsonObject) throws Exception {
        JSONObject a = new JSONObject();
        log.info("update adminRole : adminRole= " + jsonObject.get("roleName"));
        
        try {
            AdminRole adminRole = adminRoleService.getObjectById(id);
            if (adminRole == null) {
                a.put("code", -200);
                a.put("message", "necessery parameter error  , id is wrong ");
            }
            adminRole.setRoleName(jsonObject.getString("roleName"));
            adminRole.setCreateBy(jsonObject.getString("createBy"));
            adminRole.setId(id);
            
            JSONArray jsonArray = jsonObject.getJSONArray("authority");
            
            adminRoleService.update(adminRole);
            
            List<Authority> authorityList = new ArrayList<>();
            
            if (jsonArray.size() > 0) {
                List<Long> authotityIds = authorityService.getAuthorityIdsByAdminRoleId(id, 0, Integer.MAX_VALUE);
                authorityService.deleteList(Authority.class, authotityIds);
                for (Object idget : jsonArray) {
                    Authority authority1 = new Authority();
                    authority1.setAdminRoleId(id);
                    authority1.setModuleId(Long.valueOf(idget.toString()));
                    authorityList.add(authority1);
                }
                log.info("role authorty is " + authorityList);
                authorityService.insertList(authorityList);
            }
            
            
            a.put("code", 0);
            a.put("message", "success");
            
            
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("update adminRole error,id is  " + id);
            a.put("code", -100);
            a.put("message", "Server has something wrong");
        }
        
        return a.toString();
    }
    
    
    /**
     * 后台：新增角色
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/adminRole", method = RequestMethod.POST)
    
    public String addAdminRoleJson(ModelMap model, @RequestBody JSONObject jsonObject) throws Exception {
        
        log.info("insert adminRole : adminRole= " + jsonObject.get("roleName"));
        AdminRole adminRole = new AdminRole();
        adminRole.setRoleName(jsonObject.getString("roleName"));
        adminRole.setCreateBy(jsonObject.getString("createBy"));
        
        JSONArray jsonArray = jsonObject.getJSONArray("authority");
        
        try {
            adminRole.setId(null);
            
            Long roleId = adminRoleService.insert(adminRole);
            
            List<Authority> authorityList = new ArrayList<>();
            if (jsonArray.size() > 0) {
                for (Object id : jsonArray) {
                    Authority authority1 = new Authority();
                    authority1.setAdminRoleId(roleId);
                    authority1.setModuleId(Long.valueOf(id.toString()));
                    authorityList.add(authority1);
                }
                log.info("role authorty is " + authorityList);
                authorityService.insertList(authorityList);
            }
            model.addAttribute("code", 0);
        } catch (Throwable t) {
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("add adminRole error ");
            model.addAttribute("code", -100);
        }
        
        return "/polyFinance-lgd-server/adminRole/json/adminRoleDetailJson";
    }
    
    
    /**
     * 后台：删除管理员角色接口
     * (系统没有事务，自定义事务失败，从新插入后id会发生变化)
     *
     * @param model
     * @param id    角色id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/adminRole/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteAdminRoleJson(ModelMap model, @PathVariable Long id)
            throws Exception {
        JSONObject a = new JSONObject();
        
        log.info("delete adminRole : id= " + id);
        List<Long> authorityIds;
        
        try {
         
            adminRoleService.delete(id);
            authorityIds = authorityService.getAuthorityIdsByAdminRoleId(id, 0, Integer.MAX_VALUE);
            authorityService.deleteList(Authority.class, authorityIds);
            
            
            log.info("delete adminRole and Authority success");
            a.put("code", 0);
            a.put("message", "success");
            
        } catch (Throwable t) {
            
            t.printStackTrace();
            log.error(t.getMessage());
            log.error("delete adminRole error,id is  " + id);
            a.put("code", -100);
            a.put("message", "Server has something wrong");
            return a.toString();
        }
        return a.toString();
    }
    
    /**
     * 后台：查询角色列表
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/a/u/adminRole/list", method = RequestMethod.GET)
    public String getMultiAdminRoleJson(ModelMap model)
            throws Exception {
        
        try {
            
            List<Long> idList = adminRoleService.getAdminRoleIds(0, Integer.MAX_VALUE);
            List<AdminRole> adminRoleList = adminRoleService.getObjectsByIds(idList);
            log.info("get  adminRole data is " + adminRoleList);
            
            model.addAttribute("code", 0);
            model.addAttribute("total", adminRoleList.size());
            
            model.addAttribute("adminRoleList", adminRoleList);
            
        } catch (Throwable t) {
            log.error(t.getMessage());
            log.error("get adminRole list error ");
            model.addAttribute("code", -100);
        }
        
        return "/polyFinance-lgd-server/adminRole/json/adminRoleListJson";
    }
    
    
}

