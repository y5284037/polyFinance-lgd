package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.Suggestion;
import com.ptteng.polyFinance.lgd.service.SuggestionService;
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
public class SuggestionServiceTest {
    
    private static final Log log = LogFactory.getLog(SuggestionServiceTest.class);
    
    private SuggestionService suggestionService;
    
    
    @Before
    public void setUp() throws Exception {
        
        
        //dao
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-server.xml");
        suggestionService = (SuggestionService) context.getBean("suggestionService");
        //local server
        /**
         suggestionService = (SuggestionService)  Naming.lookup("//localhost:20308/SuggestionRMIService");
         **/
        
        /** test client
         ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
         suggestionService = (SuggestionService) context.getBean("suggestionService");
         
         **/
        
        
    }
    
    
    @Test
    public void testCRUD() throws ServiceException, ServiceDaoException {
        
        // 1.增加
        
        Suggestion suggestion = new Suggestion();
        
        suggestion.setPhone("23");
        
        suggestion.setName("234");
        
        suggestion.setEmail("234");
        
        suggestion.setSuggestionDetail("2344");
        
        
        suggestion.setCreateBy(2334L);
        
        suggestion.setUpdateBy(2344L);
        
        
        Long id = this.suggestionService.insert(suggestion);
        
        suggestion = this.suggestionService.getObjectById(id);
        
        Suggestion suggestion2 = this.suggestionService.getObjectById(id);
        Assert.assertNotNull(suggestion2);
        
        // 2. 更改
        suggestion.setPhone("23");
        suggestion.setName("234");
        suggestion.setEmail("234");
        suggestion.setSuggestionDetail("2344");
        suggestion.setCreateBy(2334L);
        suggestion.setUpdateBy(2344L);
        boolean success = this.suggestionService.update(suggestion);
        Assert.assertEquals(true, success);
        Suggestion suggestion3 = this.suggestionService.getObjectById(id);
//        //3.删除
//        boolean successDelete = this.suggestionService.delete(id);
//        Assert.assertEquals(true, success);
//        Suggestion suggestion4 = this.suggestionService.getObjectById(id);
//        Assert.assertNull(suggestion4);
        
        //4.batchInsert
        List<Suggestion> list = new ArrayList<Suggestion>();
        Suggestion suggestion5 = new Suggestion();
        
        suggestion5.setPhone("23");
        
        suggestion5.setName("234");
        
        suggestion5.setEmail("234");
        
        suggestion5.setSuggestionDetail("2344");
        
        
        suggestion5.setCreateBy(2334L);
        
        suggestion5.setUpdateBy(2344L);
        
        list.add(suggestion5);
        Suggestion suggestion6 = new Suggestion();
        
        suggestion6.setPhone("23");
        
        suggestion6.setName("234");
        
        suggestion6.setEmail("234");
        
        suggestion6.setSuggestionDetail("2344");
        
        
        suggestion6.setCreateBy(2334L);
        
        suggestion6.setUpdateBy(2344L);
        
        list.add(suggestion6);
        List<Suggestion> insertResults = this.suggestionService.insertList(list);
        Assert.assertEquals(2, insertResults.size());
        //5.batchGet
        List<Long> ids = new ArrayList<Long>();
        for (Suggestion o : insertResults) {
            ids.add(o.getId());
        }
        
        List<Suggestion> getResults = this.suggestionService.getObjectsByIds(ids);
        Assert.assertEquals(2, getResults.size());
        
        
        for (Suggestion o : insertResults) {
            this.suggestionService.delete(o.getId());
        }
        
        //6.batchUpdate
        
    }
    
    
    @Test
    public void testNULL() throws ServiceException, ServiceDaoException {
    
    
    }
    
    ;
}

