package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.UserMessage;
import com.ptteng.polyFinance.lgd.service.UserMessageService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

@Ignore
public class UserMessageServiceTest {

	private static final Log log = LogFactory.getLog(UserMessageServiceTest.class);
	
	private UserMessageService userMessageService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-server.xml");
	        userMessageService = (UserMessageService) context.getBean("userMessageService");
			//local server
			/**
			userMessageService = (UserMessageService)  Naming.lookup("//localhost:20309/UserMessageRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 userMessageService = (UserMessageService) context.getBean("userMessageService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  UserMessage userMessage  = new UserMessage();	   
	   					 
			   					                userMessage.setUserId(2L);
            
			   					                userMessage.setMessageType(2);
            
			   					                userMessage.setMessageReadStatus(2);
            
			   					
			   					                userMessage.setContent("2");
            
			   					 
			   					 
			   					                userMessage.setCreateBy(1L);
            
			   					                userMessage.setUpdateBy(1L);
            
			   	 
	 
	  Long id= this.userMessageService.insert(userMessage);

      userMessage = this.userMessageService.getObjectById(id);

	  UserMessage userMessage2=this.userMessageService.getObjectById(id);
	    Assert.assertNotNull(userMessage2);
	  
		// 2. 更改 
				 		 				 				   userMessage.setUserId(2L);
		    		 				 				   userMessage.setMessageType(2);
		    		 				 				   userMessage.setMessageReadStatus(2);
		    		 				 					 				 				   userMessage.setContent("2");
		    		 				 		 				 		 				 				   userMessage.setCreateBy(1L);
		    		 				 				   userMessage.setUpdateBy(1L);
		    		 				boolean success=this.userMessageService.update(userMessage);		
		Assert.assertEquals(true, success);
		 UserMessage userMessage3=this.userMessageService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.userMessageService.delete(id);	
		Assert.assertEquals(true, success);
		UserMessage userMessage4=this.userMessageService.getObjectById(id);
		Assert.assertNull(userMessage4);
		
		//4.batchInsert
		 List<UserMessage> list=new ArrayList<UserMessage>();
	  	  UserMessage userMessage5  = new UserMessage();	   
	   					 
			   					                userMessage5.setUserId(2L);
            
			   					                userMessage5.setMessageType(2);
            
			   					                userMessage5.setMessageReadStatus(2);
            
			   					
			   					                userMessage5.setContent("2");
            
			   					 
			   					 
			   					                userMessage5.setCreateBy(1L);
            
			   					                userMessage5.setUpdateBy(1L);
            
			   	    list.add(userMessage5);	   
	  	  UserMessage userMessage6  = new UserMessage();	   
	   					 
			   					                userMessage6.setUserId(2L);
            
			   					                userMessage6.setMessageType(2);
            
			   					                userMessage6.setMessageReadStatus(2);
            
			   					
			   					                userMessage6.setContent("2");
            
			   					 
			   					 
			   					                userMessage6.setCreateBy(1L);
            
			   					                userMessage6.setUpdateBy(1L);
            
			   	   list.add(userMessage6);
	   List<UserMessage> insertResults= this.userMessageService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(UserMessage o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<UserMessage> getResults= this.userMessageService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(UserMessage o :insertResults){
			this.userMessageService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
			
		
	//@Test
	public void  getUserMessageIdsByUserIdAndMessageReadStatus()throws ServiceException, ServiceDaoException{
	 List<UserMessage> list=new ArrayList<UserMessage>();
	  	  UserMessage userMessage1  = new UserMessage();	   
	   					 
			   					                userMessage1.setUserId(2L);
            
			   					                userMessage1.setMessageType(2);
            
			   					                userMessage1.setMessageReadStatus(2);
            
			   					
			   					                userMessage1.setContent("2");
            
			   					 
			   					 
			   					                userMessage1.setCreateBy(1L);
            
			   					                userMessage1.setUpdateBy(1L);
            
			   	  list.add(userMessage1);	
	  	  UserMessage userMessage2  = new UserMessage();	   
	   					 
			   					                userMessage2.setUserId(2L);
            
			   					                userMessage2.setMessageType(2);
            
			   					                userMessage2.setMessageReadStatus(2);
            
			   					
			   					                userMessage2.setContent("2");
            
			   					 
			   					 
			   					                userMessage2.setCreateBy(1L);
            
			   					                userMessage2.setUpdateBy(1L);
            
			   	  list.add(userMessage2);	  
	  List<UserMessage> insertResults= this.userMessageService.insertList(list);
		
	
	   
		
	
		List<Long>  lists= userMessageService.getUserMessageIdsByUserIdAndMessageReadStatus(2L,2,0,Integer.MAX_VALUE);
		//TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);		
		
		 for(UserMessage o :insertResults){
			this.userMessageService.delete(o.getId());
}
		 
		};

	
			
		
	//@Test
	public void  getUserMessageIdsByUserId()throws ServiceException, ServiceDaoException{
	 List<UserMessage> list=new ArrayList<UserMessage>();
	  	  UserMessage userMessage1  = new UserMessage();	   
	   					 
			   					                userMessage1.setUserId(2L);
            
			   					                userMessage1.setMessageType(2);
            
			   					                userMessage1.setMessageReadStatus(2);
            
			   					
			   					                userMessage1.setContent("2");
            
			   					 
			   					 
			   					                userMessage1.setCreateBy(1L);
            
			   					                userMessage1.setUpdateBy(1L);
            
			   	  list.add(userMessage1);	
	  	  UserMessage userMessage2  = new UserMessage();	   
	   					 
			   					                userMessage2.setUserId(2L);
            
			   					                userMessage2.setMessageType(2);
            
			   					                userMessage2.setMessageReadStatus(2);
            
			   					
			   					                userMessage2.setContent("2");
            
			   					 
			   					 
			   					                userMessage2.setCreateBy(1L);
            
			   					                userMessage2.setUpdateBy(1L);
            
			   	  list.add(userMessage2);	  
	  List<UserMessage> insertResults= this.userMessageService.insertList(list);
		
	
	   
		
	
		List<Long>  lists= userMessageService.getUserMessageIdsByUserId(2L,0,Integer.MAX_VALUE);
		//TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);		
		
		 for(UserMessage o :insertResults){
			this.userMessageService.delete(o.getId());
}
		 
		};

	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

