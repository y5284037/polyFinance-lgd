package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.Authority;
import com.ptteng.polyFinance.lgd.service.AuthorityService;
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
public class AuthorityServiceTest {

	private static final Log log = LogFactory.getLog(AuthorityServiceTest.class);
	
	private AuthorityService authorityService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/polyFinance-lgd-server/applicationContext-server.xml");
	        authorityService = (AuthorityService) context.getBean("authorityService");
			//local server
			/**
			authorityService = (AuthorityService)  Naming.lookup("//localhost:20309/AuthorityRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 authorityService = (AuthorityService) context.getBean("authorityService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  Authority authority  = new Authority();	   
	   					 
			   					                authority.setAdminRoleId(23L);
            
			   					                authority.setModuleId(234L);
            
			   					 
			   					 
			   					                authority.setCreateBy(2355L);
            
			   					                authority.setUpdateBy(22468L);
            
			   	 
	 
	  Long id= this.authorityService.insert(authority);

      authority = this.authorityService.getObjectById(id);

	  Authority authority2=this.authorityService.getObjectById(id);
	    Assert.assertNotNull(authority2);
	  
		// 2. 更改 
				 		 				 				   authority.setAdminRoleId(23L);
		    		 				 				   authority.setModuleId(234L);
		    		 				 		 				 		 				 				   authority.setCreateBy(2355L);
		    		 				 				   authority.setUpdateBy(22468L);
		    		 				boolean success=this.authorityService.update(authority);		
		Assert.assertEquals(true, success);
		 Authority authority3=this.authorityService.getObjectById(id);
				 		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.authorityService.delete(id);	
		Assert.assertEquals(true, success);
		Authority authority4=this.authorityService.getObjectById(id);
		Assert.assertNull(authority4);
		
		//4.batchInsert
		 List<Authority> list=new ArrayList<Authority>();
	  	  Authority authority5  = new Authority();	   
	   					 
			   					                authority5.setAdminRoleId(23L);
            
			   					                authority5.setModuleId(234L);
            
			   					 
			   					 
			   					                authority5.setCreateBy(2355L);
            
			   					                authority5.setUpdateBy(22468L);
            
			   	    list.add(authority5);	   
	  	  Authority authority6  = new Authority();	   
	   					 
			   					                authority6.setAdminRoleId(23L);
            
			   					                authority6.setModuleId(234L);
            
			   					 
			   					 
			   					                authority6.setCreateBy(2355L);
            
			   					                authority6.setUpdateBy(22468L);
            
			   	   list.add(authority6);
	   List<Authority> insertResults= this.authorityService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(Authority o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<Authority> getResults= this.authorityService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(Authority o :insertResults){
			this.authorityService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
			
		
	//@Test
	public void  getAuthorityIdsByAdminRoleId()throws ServiceException, ServiceDaoException{
	 List<Authority> list=new ArrayList<Authority>();
	  	  Authority authority1  = new Authority();	   
	   					 
			   					                authority1.setAdminRoleId(23L);
            
			   					                authority1.setModuleId(234L);
            
			   					 
			   					 
			   					                authority1.setCreateBy(2355L);
            
			   					                authority1.setUpdateBy(22468L);
            
			   	  list.add(authority1);	
	  	  Authority authority2  = new Authority();	   
	   					 
			   					                authority2.setAdminRoleId(23L);
            
			   					                authority2.setModuleId(234L);
            
			   					 
			   					 
			   					                authority2.setCreateBy(2355L);
            
			   					                authority2.setUpdateBy(22468L);
            
			   	  list.add(authority2);	  
	  List<Authority> insertResults= this.authorityService.insertList(list);
		
	
	   
		
	
		List<Long>  lists= authorityService.getAuthorityIdsByAdminRoleId(23L,0,Integer.MAX_VALUE);
		//TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);		
		
		 for(Authority o :insertResults){
			this.authorityService.delete(o.getId());
}
		 
		};

	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

