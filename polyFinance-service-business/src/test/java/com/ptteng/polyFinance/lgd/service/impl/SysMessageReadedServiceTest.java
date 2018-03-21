package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.SysMessageReaded;
import com.ptteng.polyFinance.lgd.service.SysMessageReadedService;
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
public class SysMessageReadedServiceTest {

	private static final Log log = LogFactory.getLog(SysMessageReadedServiceTest.class);
	
	private SysMessageReadedService sysMessageReadedService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/polyFinance-lgd-server/applicationContext-server.xml");
	        sysMessageReadedService = (SysMessageReadedService) context.getBean("sysMessageReadedService");
			//local server
			/**
			sysMessageReadedService = (SysMessageReadedService)  Naming.lookup("//localhost:20310/SysMessageReadedRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 sysMessageReadedService = (SysMessageReadedService) context.getBean("sysMessageReadedService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  SysMessageReaded sysMessageReaded  = new SysMessageReaded();	   
	   					 
			   					                sysMessageReaded.setUserId(121L);
            
			   					                sysMessageReaded.setSysMessageId(2311L);
            
			   					 
			   					                sysMessageReaded.setCreateBy(132L);
            
			   					                sysMessageReaded.setReadStatus(1321);
            
			   					                sysMessageReaded.setDeleteStatus(123);
            
			   					 
			   					                sysMessageReaded.setUpdateBy(1333L);
            
			   	 
	 
	  Long id= this.sysMessageReadedService.insert(sysMessageReaded);

      sysMessageReaded = this.sysMessageReadedService.getObjectById(id);

	  SysMessageReaded sysMessageReaded2=this.sysMessageReadedService.getObjectById(id);
	    Assert.assertNotNull(sysMessageReaded2);
	  
		// 2. 更改 
				 		 				 				   sysMessageReaded.setUserId(3L);
		    		 				 				   sysMessageReaded.setSysMessageId(2L);
		    		 				 		 				 				   sysMessageReaded.setCreateBy(123L);
		    		 				 				   sysMessageReaded.setReadStatus(232);
		    		 				 				   sysMessageReaded.setDeleteStatus(13);
		    		 				 		 				 				   sysMessageReaded.setUpdateBy(133L);
		    		 				boolean success=this.sysMessageReadedService.update(sysMessageReaded);		
		Assert.assertEquals(true, success);
		 SysMessageReaded sysMessageReaded3=this.sysMessageReadedService.getObjectById(id);
				 		 				             		 				             		 				 		 				             		 				             		 				             		 				 		 				             		 				//3.删除
		boolean successDelete=this.sysMessageReadedService.delete(id);	
		Assert.assertEquals(true, success);
		SysMessageReaded sysMessageReaded4=this.sysMessageReadedService.getObjectById(id);
		Assert.assertNull(sysMessageReaded4);
		
		//4.batchInsert
		 List<SysMessageReaded> list=new ArrayList<SysMessageReaded>();
	  	  SysMessageReaded sysMessageReaded5  = new SysMessageReaded();	   
	   					 
			   					                sysMessageReaded5.setUserId(121L);
            
			   					                sysMessageReaded5.setSysMessageId(2311L);
            
			   					 
			   					                sysMessageReaded5.setCreateBy(132L);
            
			   					                sysMessageReaded5.setReadStatus(1321);
            
			   					                sysMessageReaded5.setDeleteStatus(123);
            
			   					 
			   					                sysMessageReaded5.setUpdateBy(1333L);
            
			   	    list.add(sysMessageReaded5);	   
	  	  SysMessageReaded sysMessageReaded6  = new SysMessageReaded();	   
	   					 
			   					                sysMessageReaded6.setUserId(3L);
            
			   					                sysMessageReaded6.setSysMessageId(2L);
            
			   					 
			   					                sysMessageReaded6.setCreateBy(123L);
            
			   					                sysMessageReaded6.setReadStatus(232);
            
			   					                sysMessageReaded6.setDeleteStatus(13);
            
			   					 
			   					                sysMessageReaded6.setUpdateBy(133L);
            
			   	   list.add(sysMessageReaded6);
	   List<SysMessageReaded> insertResults= this.sysMessageReadedService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(SysMessageReaded o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<SysMessageReaded> getResults= this.sysMessageReadedService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(SysMessageReaded o :insertResults){
			this.sysMessageReadedService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
			
		
	//@Test
	public void  getSysMessageReadedIdsByUserId()throws ServiceException, ServiceDaoException{
	 List<SysMessageReaded> list=new ArrayList<SysMessageReaded>();
	  	  SysMessageReaded sysMessageReaded1  = new SysMessageReaded();	   
	   					 
			   					                sysMessageReaded1.setUserId(121L);
            
			   					                sysMessageReaded1.setSysMessageId(2311L);
            
			   					 
			   					                sysMessageReaded1.setCreateBy(132L);
            
			   					                sysMessageReaded1.setReadStatus(1321);
            
			   					                sysMessageReaded1.setDeleteStatus(123);
            
			   					 
			   					                sysMessageReaded1.setUpdateBy(1333L);
            
			   	  list.add(sysMessageReaded1);	
	  	  SysMessageReaded sysMessageReaded2  = new SysMessageReaded();	   
	   					 
			   					                sysMessageReaded2.setUserId(3L);
            
			   					                sysMessageReaded2.setSysMessageId(2L);
            
			   					 
			   					                sysMessageReaded2.setCreateBy(123L);
            
			   					                sysMessageReaded2.setReadStatus(232);
            
			   					                sysMessageReaded2.setDeleteStatus(13);
            
			   					 
			   					                sysMessageReaded2.setUpdateBy(133L);
            
			   	  list.add(sysMessageReaded2);	  
	  List<SysMessageReaded> insertResults= this.sysMessageReadedService.insertList(list);
		
	
	   
		
	
		List<Long>  lists= sysMessageReadedService.getSysMessageReadedIdsByUserId(121L,0,Integer.MAX_VALUE);
		//TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);		
		
		 for(SysMessageReaded o :insertResults){
			this.sysMessageReadedService.delete(o.getId());
}
		 
		};

	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

