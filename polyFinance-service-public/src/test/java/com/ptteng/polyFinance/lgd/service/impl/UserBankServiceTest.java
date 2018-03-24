package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.common.util.MyListUtil;
import com.ptteng.polyFinance.lgd.model.UserBank;
import com.ptteng.polyFinance.lgd.service.UserBankService;
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
public class UserBankServiceTest {
    
    private static final Log log = LogFactory.getLog(UserBankServiceTest.class);
    
    private UserBankService userBankService;
    
    
    @Before
    public void setUp() throws Exception {
        
        
        //dao
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-server.xml");
        userBankService = (UserBankService) context.getBean("userBankService");
        //local server
        /**
         userBankService = (UserBankService)  Naming.lookup("//localhost:20309/UserBankRMIService");
         **/
        
        /** test client
         ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
         userBankService = (UserBankService) context.getBean("userBankService");
         
         **/
        
        
    }
    
    
    //@Test
    public void testCRUD() throws ServiceException, ServiceDaoException {
        
        // 1.增加
        
        UserBank userBank = new UserBank();
        
        userBank.setCity("成都市");
        
        userBank.setBankListId(1L);
        
        userBank.setBankName("中国银行");
        
        userBank.setCardNo("4562580000");
        
        userBank.setBankPhone("18255565451");
        
        userBank.setUserId(22L);
        
        userBank.setFirst(1);
        
        
        userBank.setCreateBy(1L);
        
        userBank.setUpdateBy(1L);
        
        
        Long id = this.userBankService.insert(userBank);
        
        userBank = this.userBankService.getObjectById(id);
        
        UserBank userBank2 = this.userBankService.getObjectById(id);
        Assert.assertNotNull(userBank2);
        
        // 2. 更改
        userBank.setCity("成都市");
        userBank.setBankListId(1L);
        userBank.setBankName("中国人民银行");
        userBank.setCardNo("4562580000");
        userBank.setBankPhone("18255565451");
        userBank.setUserId(22L);
        userBank.setFirst(1);
        userBank.setCreateBy(1L);
        userBank.setUpdateBy(1L);
        boolean success = this.userBankService.update(userBank);
        Assert.assertEquals(true, success);
        UserBank userBank3 = this.userBankService.getObjectById(id);
        //3.删除
        boolean successDelete = this.userBankService.delete(id);
        Assert.assertEquals(true, success);
        UserBank userBank4 = this.userBankService.getObjectById(id);
        Assert.assertNull(userBank4);
        
        //4.batchInsert
        List<UserBank> list = new ArrayList<UserBank>();
        UserBank userBank5 = new UserBank();
        
        userBank5.setCity("成都市");
        
        userBank5.setBankListId(1L);
        
        userBank5.setBankName("中国银行");
        
        userBank5.setCardNo("4562580000");
        
        userBank5.setBankPhone("18255565451");
        
        userBank5.setUserId(22L);
        
        userBank5.setFirst(1);
        
        
        userBank5.setCreateBy(1L);
        
        userBank5.setUpdateBy(1L);
        
        list.add(userBank5);
        UserBank userBank6 = new UserBank();
        
        userBank6.setCity("成都市");
        
        userBank6.setBankListId(1L);
        
        userBank6.setBankName("中国人民银行");
        
        userBank6.setCardNo("4562580000");
        
        userBank6.setBankPhone("18255565451");
        
        userBank6.setUserId(22L);
        
        userBank6.setFirst(1);
        
        
        userBank6.setCreateBy(1L);
        
        userBank6.setUpdateBy(1L);
        
        list.add(userBank6);
        List<UserBank> insertResults = this.userBankService.insertList(list);
        Assert.assertEquals(2, insertResults.size());
        //5.batchGet
        List<Long> ids = new ArrayList<Long>();
        for (UserBank o : insertResults) {
            ids.add(o.getId());
        }
        
        List<UserBank> getResults = this.userBankService.getObjectsByIds(ids);
        Assert.assertEquals(2, getResults.size());
        
        
        for (UserBank o : insertResults) {
            this.userBankService.delete(o.getId());
        }
        
        //6.batchUpdate
        
    }
    
    
    //@Test
    public void getUserBankIdByUserIdAndFirst() throws ServiceException, ServiceDaoException {
        List<UserBank> list = new ArrayList<UserBank>();
        UserBank userBank1 = new UserBank();
        
        userBank1.setCity("成都市");
        
        userBank1.setBankListId(1L);
        
        userBank1.setBankName("中国银行");
        
        userBank1.setCardNo("4562580000");
        
        userBank1.setBankPhone("18255565451");
        
        userBank1.setUserId(22L);
        
        userBank1.setFirst(1);
        
        
        userBank1.setCreateBy(1L);
        
        userBank1.setUpdateBy(1L);
        
        list.add(userBank1);
        UserBank userBank2 = new UserBank();
        
        userBank2.setCity("成都市");
        
        userBank2.setBankListId(1L);
        
        userBank2.setBankName("中国人民银行");
        
        userBank2.setCardNo("4562580000");
        
        userBank2.setBankPhone("18255565451");
        
        userBank2.setUserId(22L);
        
        userBank2.setFirst(1);
        
        
        userBank2.setCreateBy(1L);
        
        userBank2.setUpdateBy(1L);
        
        list.add(userBank2);
        List<UserBank> insertResults = this.userBankService.insertList(list);
        
        
        Long lists = userBankService.getUserBankIdByUserIdAndFirst(22L, 1);
        //TODO 增加自己的验证逻辑
        Assert.assertNotNull(lists);
        
        for (UserBank o : insertResults) {
            this.userBankService.delete(o.getId());
        }
        
    }
    
    ;
    
    
    @Test
    public void getUserBankIdsByUserId() throws ServiceException, ServiceDaoException {
        List<UserBank> list = new ArrayList<UserBank>();
        UserBank userBank1 = new UserBank();
        
        userBank1.setCity("成都市");
        
        userBank1.setBankListId(1L);
        
        userBank1.setBankName("中国银行");
        
        userBank1.setCardNo("4562580000");
        
        userBank1.setBankPhone("18255565451");
        
        userBank1.setUserId(6L);
        
        userBank1.setFirst(1);
        
        
        userBank1.setCreateBy(1L);
        
        userBank1.setUpdateBy(1L);
        
        list.add(userBank1);
        UserBank userBank2 = new UserBank();
        
        userBank2.setCity("成都市");
        
        userBank2.setBankListId(1L);
        
        userBank2.setBankName("中国人民银行");
        
        userBank2.setCardNo("4562580000");
        
        userBank2.setBankPhone("18255565451");
        
        userBank2.setUserId(6L);
        
        userBank2.setFirst(1);
        
        
        userBank2.setCreateBy(1L);
        
        userBank2.setUpdateBy(1L);
        
        list.add(userBank2);
        List<UserBank> insertResults = this.userBankService.insertList(list);
        
        
        List<Long> lists = userBankService.getUserBankIdsByUserId(6L, 0, Integer.MAX_VALUE);
        //TODO 增加自己的验证逻辑
//        Assert.assertNotNull(lists);
        System.out.println(lists);

//        for (UserBank o : insertResults) {
//            this.userBankService.delete(o.getId());
//        }
        
    }
    
    
    @Test
    public void testNULL() throws ServiceException, ServiceDaoException, NoSuchFieldException, IllegalAccessException {
        
        List<Long> ids = userBankService.getUserBankIdsByUserId(5l, 0, 10);
        List<UserBank> userBankList = userBankService.getObjectsByIds(ids);
        System.out.println(userBankList);
        
        List<Long> bankListIds = MyListUtil.getList(UserBank.class.getDeclaredField("bankListId"), userBankList);
        System.out.println(bankListIds);
    }
    
    
}

