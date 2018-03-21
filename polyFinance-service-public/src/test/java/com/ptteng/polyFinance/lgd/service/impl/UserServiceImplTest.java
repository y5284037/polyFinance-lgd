package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.Dao;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.util.SQLUtil;
import com.ptteng.polyFinance.lgd.model.User;
import com.ptteng.polyFinance.lgd.service.AdminService;
import com.ptteng.polyFinance.lgd.service.UserService;
import com.ptteng.polyFinance.lgd.utils.DynamicUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author lujing
 * Create_at 2018/3/17 20:03
 */
public class UserServiceImplTest {
    
    private UserService userService;
    
    @Before
    public void setUp() throws Exception {
        
        
        //dao
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-server.xml");
        userService = (UserService) context.getBean("userService");
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
    public void getObjectById() {
    }
    
    @Test
    public void getIdsByDynamicCondition() throws ServiceException, ServiceDaoException {
     
        Map<String, Object> param = DynamicUtil.getUserListSql("","",null,null,null,"");
        System.out.println(SQLUtil.convert2Sql(param,0,10));
        
        List<Long> ids = userService.getIdsByDynamicCondition(User.class, param, 0, 10);
        
        System.out.println(ids);
        System.out.println(userService.getObjectsByIds(ids));
    }
   
    @Test
    public void getObjectByPhoneNum() throws ServiceException, ServiceDaoException, DaoException {
   
//        System.out.println(userService.getObjectByPhoneNum("1581"));
    
//        System.out.println(userService.getObjectById(1l));
//        User user = userService.getObjectById(5L);
//        user.setSerialNum("UK1009222");
//        userService.update(user);
//      userService.updateUserSerialNumById(5l);
       
    }
    
    
    
}