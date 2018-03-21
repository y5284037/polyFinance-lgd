package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.AdminRole;
import com.ptteng.polyFinance.lgd.service.AdminRoleService;
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
public class AdminRoleServiceTest {

	private static final Log log = LogFactory.getLog(AdminRoleServiceTest.class);
	
	private AdminRoleService adminRoleService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-server.xml");
	        adminRoleService = (AdminRoleService) context.getBean("adminRoleService");
			//local server
			/**
			adminRoleService = (AdminRoleService)  Naming.lookup("//localhost:20309/AdminRoleRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 adminRoleService = (AdminRoleService) context.getBean("adminRoleService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  AdminRole adminRole  = new AdminRole();	   
	   					 
			   					                adminRole.setRoleName("23");
            
			   					 
			   					 
			   					                adminRole.setCreateBy(2344L);
            
			   					                adminRole.setUpdateBy(2355L);
            
			   	 
	 
	  Long id= this.adminRoleService.insert(adminRole);

      adminRole = this.adminRoleService.getObjectById(id);

	  AdminRole adminRole2=this.adminRoleService.getObjectById(id);
	    Assert.assertNotNull(adminRole2);
	  
		// 2. 更改 
				 		 				 				   adminRole.setRoleName("23");
		    		 				 		 				 		 				 				   adminRole.setCreateBy(2344L);
		    		 				 				   adminRole.setUpdateBy(2355L);
		    		 				boolean success=this.adminRoleService.update(adminRole);		
		Assert.assertEquals(true, success);
		 AdminRole adminRole3=this.adminRoleService.getObjectById(id);
				 		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.adminRoleService.delete(id);	
		Assert.assertEquals(true, success);
		AdminRole adminRole4=this.adminRoleService.getObjectById(id);
		Assert.assertNull(adminRole4);
		
		//4.batchInsert
		 List<AdminRole> list=new ArrayList<AdminRole>();
	  	  AdminRole adminRole5  = new AdminRole();	   
	   					 
			   					                adminRole5.setRoleName("23");
            
			   					 
			   					 
			   					                adminRole5.setCreateBy(2344L);
            
			   					                adminRole5.setUpdateBy(2355L);
            
			   	    list.add(adminRole5);	   
	  	  AdminRole adminRole6  = new AdminRole();	   
	   					 
			   					                adminRole6.setRoleName("23");
            
			   					 
			   					 
			   					                adminRole6.setCreateBy(2344L);
            
			   					                adminRole6.setUpdateBy(2355L);
            
			   	   list.add(adminRole6);
	   List<AdminRole> insertResults= this.adminRoleService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(AdminRole o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<AdminRole> getResults= this.adminRoleService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(AdminRole o :insertResults){
			this.adminRoleService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

