package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.Content;
import com.ptteng.polyFinance.lgd.service.ContentService;
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
public class ContentServiceTest {
    
    private static final Log log = LogFactory.getLog(ContentServiceTest.class);
    
    private ContentService contentService;
    
    
    @Before
    public void setUp() throws Exception {
        
        
        //dao
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-server.xml");
        contentService = (ContentService) context.getBean("contentService");
        //local server
        /**
         contentService = (ContentService)  Naming.lookup("//localhost:20308/ContentRMIService");
         **/
        
        /** test client
         ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
         contentService = (ContentService) context.getBean("contentService");
         
         **/
        
        
    }
    
    
    @Test
    public void testCRUD() throws ServiceException, ServiceDaoException {
        
        // 1.增加
        
        Content content = new Content();
        
        content.setTitle("23");
        
        content.setType(234);
        
        content.setStatus(234);
        
        content.setContentCoverPic("2344");
        
        content.setContentPic("2355");
        
        
        content.setCreateBy(2344L);
        
        content.setUpdateBy(2355L);
        
        
        Long id = this.contentService.insert(content);
        
        content = this.contentService.getObjectById(id);
        
        Content content2 = this.contentService.getObjectById(id);
        Assert.assertNotNull(content2);
        
        // 2. 更改
        content.setTitle("23");
        content.setType(234);
        content.setStatus(234);
        content.setContentCoverPic("2344");
        content.setContentPic("2355");
        content.setCreateBy(2344L);
        content.setUpdateBy(2355L);
        boolean success = this.contentService.update(content);
        Assert.assertEquals(true, success);
        Content content3 = this.contentService.getObjectById(id);
//        //3.删除
//        boolean successDelete = this.contentService.delete(id);
//        Assert.assertEquals(true, success);
//        Content content4 = this.contentService.getObjectById(id);
//        Assert.assertNull(content4);
        
        //4.batchInsert
        List<Content> list = new ArrayList<Content>();
        Content content5 = new Content();
        
        content5.setTitle("23");
        
        content5.setType(234);
        
        content5.setStatus(234);
        
        content5.setContentCoverPic("2344");
        
        content5.setContentPic("2355");
        
        
        content5.setCreateBy(2344L);
        
        content5.setUpdateBy(2355L);
        
        list.add(content5);
        Content content6 = new Content();
        
        content6.setTitle("23");
        
        content6.setType(234);
        
        content6.setStatus(234);
        
        content6.setContentCoverPic("2344");
        
        content6.setContentPic("2355");
        
        
        content6.setCreateBy(2344L);
        
        content6.setUpdateBy(2355L);
        
        list.add(content6);
        List<Content> insertResults = this.contentService.insertList(list);
        Assert.assertEquals(2, insertResults.size());
        //5.batchGet
        List<Long> ids = new ArrayList<Long>();
        for (Content o : insertResults) {
            ids.add(o.getId());
        }
        
        List<Content> getResults = this.contentService.getObjectsByIds(ids);
        Assert.assertEquals(2, getResults.size());
        
        
        for (Content o : insertResults) {
            this.contentService.delete(o.getId());
        }
        
        //6.batchUpdate
        
    }
    
    
    @Test
    public void testNULL() throws ServiceException, ServiceDaoException {
    
    
    }
    
    ;
}

