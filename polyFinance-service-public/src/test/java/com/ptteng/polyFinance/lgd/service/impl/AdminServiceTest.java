package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.Admin;
import com.ptteng.polyFinance.lgd.service.AdminService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

@Ignore
public class AdminServiceTest {
    
    private static final Log log = LogFactory.getLog(AdminServiceTest.class);
    
    private AdminService adminService;
    
    
    @Before
    public void setUp() throws Exception {
        
        
        //dao
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-server.xml");
        adminService = (AdminService) context.getBean("adminService");
        //local server
        /**
         adminService = (AdminService)  Naming.lookup("//localhost:20309/AdminRMIService");
         **/
        
        /** test client
         ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
         adminService = (AdminService) context.getBean("adminService");
         
         **/
        
        
    }
    
    
    @Test
    
    public void testCRUD() throws ServiceException, ServiceDaoException {
        
        // 1.增加
        
        Admin admin = new Admin();
        
        admin.setLoginName("23");
        
        admin.setAdminRoleId(234L);
        
        admin.setPswd("234");
        
        admin.setSalt("2344");
        
        
        admin.setCreateBy(2334L);
        
        admin.setUpdateBy(2344L);
        
        
        Long id = this.adminService.insert(admin);
        
        admin = this.adminService.getObjectById(id);
        
        Admin admin2 = this.adminService.getObjectById(id);
        Assert.assertNotNull(admin2);
        
        // 2. 更改
        admin.setLoginName("23");
        admin.setAdminRoleId(234L);
        admin.setPswd("234");
        admin.setSalt("2344");
        admin.setCreateBy(2334L);
        admin.setUpdateBy(2344L);
        boolean success = this.adminService.update(admin);
        Assert.assertEquals(true, success);
        Admin admin3 = this.adminService.getObjectById(id);
       
        
        //4.batchInsert
        List<Admin> list = new ArrayList<Admin>();
        Admin admin5 = new Admin();
        
        admin5.setLoginName("23");
        
        admin5.setAdminRoleId(234L);
        
        admin5.setPswd("234");
        
        admin5.setSalt("2344");
        
        
        admin5.setCreateBy(2334L);
        
        admin5.setUpdateBy(2344L);
        
        list.add(admin5);
        Admin admin6 = new Admin();
        
        admin6.setLoginName("23");
        
        admin6.setAdminRoleId(234L);
        
        admin6.setPswd("234");
        
        admin6.setSalt("2344");
        
        
        admin6.setCreateBy(2334L);
        
        admin6.setUpdateBy(2344L);
        
        list.add(admin6);
        List<Admin> insertResults = this.adminService.insertList(list);
        Assert.assertEquals(2, insertResults.size());
        //5.batchGet
        List<Long> ids = new ArrayList<Long>();
        for (Admin o : insertResults) {
            ids.add(o.getId());
        }
        
        List<Admin> getResults = this.adminService.getObjectsByIds(ids);
        Assert.assertEquals(2, getResults.size());
        
        
        for (Admin o : insertResults) {
            this.adminService.delete(o.getId());
        }
        
        //6.batchUpdate
        
    }
    
    
    @Test
    public void testNULL() throws ServiceException, ServiceDaoException {
    
    
    }
    
    ;
}

