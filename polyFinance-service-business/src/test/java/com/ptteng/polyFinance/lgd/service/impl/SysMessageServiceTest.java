package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.SysMessage;
import com.ptteng.polyFinance.lgd.service.SysMessageService;
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
public class SysMessageServiceTest {

	private static final Log log = LogFactory.getLog(SysMessageServiceTest.class);
	
	private SysMessageService sysMessageService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/polyFinance-lgd-server/applicationContext-server.xml");
	        sysMessageService = (SysMessageService) context.getBean("sysMessageService");
			//local server
			/**
			sysMessageService = (SysMessageService)  Naming.lookup("//localhost:20310/SysMessageRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 sysMessageService = (SysMessageService) context.getBean("sysMessageService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  SysMessage sysMessage  = new SysMessage();	   
	   					 
			   					                sysMessage.setTitle("2");
            
			   					                sysMessage.setStatus(2);
            
			   					                sysMessage.setResume("1");
            
			   					                sysMessage.setMessagePic("1");
            
			   					                sysMessage.setMessageType("2");
            
			   					                sysMessage.setSendType(222);
            
			   					                sysMessage.setSendTime(222L);
            
			   					                sysMessage.setSendTo(22);
            
			   					 
			   					 
			   					                sysMessage.setCreateBy(22L);
            
			   					                sysMessage.setUpdateBy(2222L);
            
			   	 
	 
	  Long id= this.sysMessageService.insert(sysMessage);

      sysMessage = this.sysMessageService.getObjectById(id);

	  SysMessage sysMessage2=this.sysMessageService.getObjectById(id);
	    Assert.assertNotNull(sysMessage2);
	  
		// 2. 更改 
				 		 				 				   sysMessage.setTitle("2");
		    		 				 				   sysMessage.setStatus(2);
		    		 				 				   sysMessage.setResume("1");
		    		 				 				   sysMessage.setMessagePic("1");
		    		 				 				   sysMessage.setMessageType("2");
		    		 				 				   sysMessage.setSendType(222);
		    		 				 				   sysMessage.setSendTime(222L);
		    		 				 				   sysMessage.setSendTo(22);
		    		 				 		 				 		 				 				   sysMessage.setCreateBy(22L);
		    		 				 				   sysMessage.setUpdateBy(2222L);
		    		 				boolean success=this.sysMessageService.update(sysMessage);		
		Assert.assertEquals(true, success);
		 SysMessage sysMessage3=this.sysMessageService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.sysMessageService.delete(id);	
		Assert.assertEquals(true, success);
		SysMessage sysMessage4=this.sysMessageService.getObjectById(id);
		Assert.assertNull(sysMessage4);
		
		//4.batchInsert
		 List<SysMessage> list=new ArrayList<SysMessage>();
	  	  SysMessage sysMessage5  = new SysMessage();	   
	   					 
			   					                sysMessage5.setTitle("2");
            
			   					                sysMessage5.setStatus(2);
            
			   					                sysMessage5.setResume("1");
            
			   					                sysMessage5.setMessagePic("1");
            
			   					                sysMessage5.setMessageType("2");
            
			   					                sysMessage5.setSendType(222);
            
			   					                sysMessage5.setSendTime(222L);
            
			   					                sysMessage5.setSendTo(22);
            
			   					 
			   					 
			   					                sysMessage5.setCreateBy(22L);
            
			   					                sysMessage5.setUpdateBy(2222L);
            
			   	    list.add(sysMessage5);	   
	  	  SysMessage sysMessage6  = new SysMessage();	   
	   					 
			   					                sysMessage6.setTitle("2");
            
			   					                sysMessage6.setStatus(2);
            
			   					                sysMessage6.setResume("1");
            
			   					                sysMessage6.setMessagePic("1");
            
			   					                sysMessage6.setMessageType("2");
            
			   					                sysMessage6.setSendType(222);
            
			   					                sysMessage6.setSendTime(222L);
            
			   					                sysMessage6.setSendTo(22);
            
			   					 
			   					 
			   					                sysMessage6.setCreateBy(22L);
            
			   					                sysMessage6.setUpdateBy(2222L);
            
			   	   list.add(sysMessage6);
	   List<SysMessage> insertResults= this.sysMessageService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(SysMessage o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<SysMessage> getResults= this.sysMessageService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(SysMessage o :insertResults){
			this.sysMessageService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
			
		
	//@Test
	public void  getSysMessageIdsByStatus()throws ServiceException, ServiceDaoException{
	 List<SysMessage> list=new ArrayList<SysMessage>();
	  	  SysMessage sysMessage1  = new SysMessage();	   
	   					 
			   					                sysMessage1.setTitle("2");
            
			   					                sysMessage1.setStatus(2);
            
			   					                sysMessage1.setResume("1");
            
			   					                sysMessage1.setMessagePic("1");
            
			   					                sysMessage1.setMessageType("2");
            
			   					                sysMessage1.setSendType(222);
            
			   					                sysMessage1.setSendTime(222L);
            
			   					                sysMessage1.setSendTo(22);
            
			   					 
			   					 
			   					                sysMessage1.setCreateBy(22L);
            
			   					                sysMessage1.setUpdateBy(2222L);
            
			   	  list.add(sysMessage1);	
	  	  SysMessage sysMessage2  = new SysMessage();	   
	   					 
			   					                sysMessage2.setTitle("2");
            
			   					                sysMessage2.setStatus(2);
            
			   					                sysMessage2.setResume("1");
            
			   					                sysMessage2.setMessagePic("1");
            
			   					                sysMessage2.setMessageType("2");
            
			   					                sysMessage2.setSendType(222);
            
			   					                sysMessage2.setSendTime(222L);
            
			   					                sysMessage2.setSendTo(22);
            
			   					 
			   					 
			   					                sysMessage2.setCreateBy(22L);
            
			   					                sysMessage2.setUpdateBy(2222L);
            
			   	  list.add(sysMessage2);	  
	  List<SysMessage> insertResults= this.sysMessageService.insertList(list);
		
	
	   
		
	
		List<Long>  lists= sysMessageService.getSysMessageIdsByStatus(2,0,Integer.MAX_VALUE);
		//TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);		
		
		 for(SysMessage o :insertResults){
			this.sysMessageService.delete(o.getId());
}
		 
		};

	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

