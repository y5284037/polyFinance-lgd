package com.ptteng.polyFinance.lgd.controller;


import com.ptteng.polyFinance.lgd.model.Admin;
import com.ptteng.polyFinance.lgd.service.AdminService;
import com.ptteng.polyFinance.lgd.utils.SecureUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@ContextConfiguration({"classpath:applicationContext-client.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminControllerTest {
    @Autowired
    AdminService adminService;
    
    @Test
    public void generateSuperAdmin() throws Exception {
        String salt = SecureUtil.getSalt();
        Admin admin = new Admin();
        admin.setAdminRoleId(0L);
        admin.setCreateAt(System.currentTimeMillis());
        admin.setCreateBy(007L);
        admin.setLoginName("admin");
        admin.setSalt(salt);
        admin.setPswd(SecureUtil.messageDigest("admin" + salt));
        admin.setUpdateAt(System.currentTimeMillis());
        admin.setUpdateBy(007L);
        adminService.insert(admin);
        
    }
}
