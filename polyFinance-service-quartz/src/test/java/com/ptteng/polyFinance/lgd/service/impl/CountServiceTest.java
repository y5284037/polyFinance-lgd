package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.Count;
import com.ptteng.polyFinance.lgd.service.CountService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Ignore
public class CountServiceTest {
    
    private static final Log log = LogFactory.getLog(CountServiceTest.class);
    
    private CountService countService;
    
    
    @Before
    public void setUp() throws Exception {
        
        
        //dao
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-server.xml");
        countService = (CountService) context.getBean("countService");
        //local server
        /**
         countService = (CountService)  Naming.lookup("//localhost:20311/CountRMIService");
         **/
        
        /** TestDemo client
         ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
         countService = (CountService) context.getBean("countService");
         
         **/
        
        
    }
    
    
    @Test
    public void testCRUD() throws ServiceException, ServiceDaoException {
        
        // 1.增加
        
        Count count = new Count();
        
        count.setProductId(2L);
        
        count.setDate(23L);
        
        count.setPurchasePeople(234);
        
        count.setPurchaseTimes(234);
        
        count.setPurchaseAmount(new BigDecimal(2344));
        
        
        count.setCreateBy(234L);
        
        count.setUpdateBy(234L);
        
        
        Long id = this.countService.insert(count);
        
        count = this.countService.getObjectById(id);
        
        Count count2 = this.countService.getObjectById(id);
        Assert.assertNotNull(count2);
        
        // 2. 更改
        count.setProductId(2L);
        count.setDate(23L);
        count.setPurchasePeople(234);
        count.setPurchaseTimes(234);
        count.setPurchaseAmount(new BigDecimal(2344));
        count.setCreateBy(234L);
        count.setUpdateBy(234L);
        boolean success = this.countService.update(count);
        Assert.assertEquals(true, success);
        Count count3 = this.countService.getObjectById(id);
//        //3.删除
//        boolean successDelete = this.countService.delete(id);
//        Assert.assertEquals(true, success);
//        Count count4 = this.countService.getObjectById(id);
//        Assert.assertNull(count4);
        
        //4.batchInsert
        List<Count> list = new ArrayList<Count>();
        Count count5 = new Count();
        
        count5.setProductId(2L);
        
        count5.setDate(23L);
        
        count5.setPurchasePeople(234);
        
        count5.setPurchaseTimes(234);
        
        count5.setPurchaseAmount(new BigDecimal(2344));
        
        
        count5.setCreateBy(234L);
        
        count5.setUpdateBy(234L);
        
        list.add(count5);
        Count count6 = new Count();
        
        count6.setProductId(2L);
        
        count6.setDate(23L);
        
        count6.setPurchasePeople(234);
        
        count6.setPurchaseTimes(234);
        
        count6.setPurchaseAmount(new BigDecimal(2344));
        
        
        count6.setCreateBy(234L);
        
        count6.setUpdateBy(234L);
        
        list.add(count6);
        List<Count> insertResults = this.countService.insertList(list);
        Assert.assertEquals(2, insertResults.size());
        //5.batchGet
        List<Long> ids = new ArrayList<Long>();
        for (Count o : insertResults) {
            ids.add(o.getId());
        }
        
        List<Count> getResults = this.countService.getObjectsByIds(ids);
        Assert.assertEquals(2, getResults.size());
        
        
        for (Count o : insertResults) {
            this.countService.delete(o.getId());
        }
        
        //6.batchUpdate
        
    }
    
    
    //@Test
    public void getCountIdsByProductIdOrderByCreateAt() throws ServiceException, ServiceDaoException {
        List<Count> list = new ArrayList<Count>();
        Count count1 = new Count();
        
        count1.setProductId(2L);
        
        count1.setDate(23L);
        
        count1.setPurchasePeople(234);
        
        count1.setPurchaseTimes(234);
        
        count1.setPurchaseAmount(new BigDecimal(2344));
        
        
        count1.setCreateBy(234L);
        
        count1.setUpdateBy(234L);
        
        list.add(count1);
        Count count2 = new Count();
        
        count2.setProductId(2L);
        
        count2.setDate(23L);
        
        count2.setPurchasePeople(234);
        
        count2.setPurchaseTimes(234);
        
        count2.setPurchaseAmount(new BigDecimal(2344));
        
        
        count2.setCreateBy(234L);
        
        count2.setUpdateBy(234L);
        
        list.add(count2);
        List<Count> insertResults = this.countService.insertList(list);
        
        
        List<Long> lists = countService.getCountIdsByProductIdOrderByCreateAt(2L, 0, Integer.MAX_VALUE);
        //TODO 增加自己的验证逻辑
        Assert.assertNotNull(lists);
        
        for (Count o : insertResults) {
            this.countService.delete(o.getId());
        }
        
    }
    
    ;
    
    
    @Test
    public void testNULL() throws ServiceException, ServiceDaoException {
    
    
    }
    
    ;
}

