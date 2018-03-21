package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.Module;
import com.ptteng.polyFinance.lgd.service.ModuleService;
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
public class ModuleServiceTest {

	private static final Log log = LogFactory.getLog(ModuleServiceTest.class);
	
	private ModuleService moduleService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/polyFinance-lgd-server/applicationContext-server.xml");
	        moduleService = (ModuleService) context.getBean("moduleService");
			//local server
			/**
			moduleService = (ModuleService)  Naming.lookup("//localhost:20309/ModuleRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 moduleService = (ModuleService) context.getBean("moduleService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  Module module  = new Module();	   
	   					 
			   					                module.setModuleName("2");
            
			   					                module.setUrl("23");
            
			   					                module.setParentModuleId(234);
            
			   					                module.setModuleType("234");
            
			   					 
			   					 
			   					                module.setCreateBy(23L);
            
			   					                module.setUpdateBy(234L);
            
			   	 
	 
	  Long id= this.moduleService.insert(module);

      module = this.moduleService.getObjectById(id);

	  Module module2=this.moduleService.getObjectById(id);
	    Assert.assertNotNull(module2);
	  
		// 2. 更改 
				 		 				 				   module.setModuleName("2");
		    		 				 				   module.setUrl("23");
		    		 				 				   module.setParentModuleId(234);
		    		 				 				   module.setModuleType("234");
		    		 				 		 				 		 				 				   module.setCreateBy(23L);
		    		 				 				   module.setUpdateBy(234L);
		    		 				boolean success=this.moduleService.update(module);		
		Assert.assertEquals(true, success);
		 Module module3=this.moduleService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.moduleService.delete(id);	
		Assert.assertEquals(true, success);
		Module module4=this.moduleService.getObjectById(id);
		Assert.assertNull(module4);
		
		//4.batchInsert
		 List<Module> list=new ArrayList<Module>();
	  	  Module module5  = new Module();	   
	   					 
			   					                module5.setModuleName("2");
            
			   					                module5.setUrl("23");
            
			   					                module5.setParentModuleId(234);
            
			   					                module5.setModuleType("234");
            
			   					 
			   					 
			   					                module5.setCreateBy(23L);
            
			   					                module5.setUpdateBy(234L);
            
			   	    list.add(module5);	   
	  	  Module module6  = new Module();	   
	   					 
			   					                module6.setModuleName("2");
            
			   					                module6.setUrl("23");
            
			   					                module6.setParentModuleId(234);
            
			   					                module6.setModuleType("234");
            
			   					 
			   					 
			   					                module6.setCreateBy(23L);
            
			   					                module6.setUpdateBy(234L);
            
			   	   list.add(module6);
	   List<Module> insertResults= this.moduleService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(Module o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<Module> getResults= this.moduleService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(Module o :insertResults){
			this.moduleService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

