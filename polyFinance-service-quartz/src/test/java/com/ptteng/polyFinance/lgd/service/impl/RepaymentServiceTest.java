package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.Repayment;
import com.ptteng.polyFinance.lgd.service.RepaymentService;
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
public class RepaymentServiceTest {

	private static final Log log = LogFactory.getLog(RepaymentServiceTest.class);
	
	private RepaymentService repaymentService;
	
	
	@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-server.xml");
	        repaymentService = (RepaymentService) context.getBean("repaymentService");
			//local server
			/**
			repaymentService = (RepaymentService)  Naming.lookup("//localhost:20311/RepaymentRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 repaymentService = (RepaymentService) context.getBean("repaymentService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  Repayment repayment  = new Repayment();	   
	   					 
			   					                repayment.setUserId(2L);
            
			   					                repayment.setInvestRecordId(2L);
            
			   					                repayment.setRepaymentDate(2L);
            
			   					                repayment.setRepaymentAmount(new BigDecimal(1));
            
			   					                repayment.setMoneyType(32);
            
			   					                repayment.setRepaymentStatus(1);
            
			   					 
			   					 
			   					                repayment.setCreateBy(3223L);
            
			   					                repayment.setUpdateBy(2232L);
            
			   	 
	 
	  Long id= this.repaymentService.insert(repayment);

      repayment = this.repaymentService.getObjectById(id);

	  Repayment repayment2=this.repaymentService.getObjectById(id);
	    Assert.assertNotNull(repayment2);
	  
		// 2. 更改 
				 		 				 				   repayment.setUserId(3L);
		    		 				 				   repayment.setInvestRecordId(2L);
		    		 				 				   repayment.setRepaymentDate(2L);
		    		 				 				   repayment.setRepaymentAmount(new BigDecimal(2));
		    		 				 				   repayment.setMoneyType(23);
		    		 				 				   repayment.setRepaymentStatus(2);
		    		 				 		 				 		 				 				   repayment.setCreateBy(242L);
		    		 				 				   repayment.setUpdateBy(2422L);
		    		 				boolean success=this.repaymentService.update(repayment);		
		Assert.assertEquals(true, success);
		 Repayment repayment3=this.repaymentService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.repaymentService.delete(id);	
		Assert.assertEquals(true, success);
		Repayment repayment4=this.repaymentService.getObjectById(id);
		Assert.assertNull(repayment4);
		
		//4.batchInsert
		 List<Repayment> list=new ArrayList<Repayment>();
	  	  Repayment repayment5  = new Repayment();	   
	   					 
			   					                repayment5.setUserId(2L);
            
			   					                repayment5.setInvestRecordId(2L);
            
			   					                repayment5.setRepaymentDate(2L);
            
			   					                repayment5.setRepaymentAmount(new BigDecimal(1));
            
			   					                repayment5.setMoneyType(32);
            
			   					                repayment5.setRepaymentStatus(1);
            
			   					 
			   					 
			   					                repayment5.setCreateBy(3223L);
            
			   					                repayment5.setUpdateBy(2232L);
            
			   	    list.add(repayment5);	   
	  	  Repayment repayment6  = new Repayment();	   
	   					 
			   					                repayment6.setUserId(3L);
            
			   					                repayment6.setInvestRecordId(2L);
            
			   					                repayment6.setRepaymentDate(2L);
            
			   					                repayment6.setRepaymentAmount(new BigDecimal(2));
            
			   					                repayment6.setMoneyType(23);
            
			   					                repayment6.setRepaymentStatus(2);
            
			   					 
			   					 
			   					                repayment6.setCreateBy(242L);
            
			   					                repayment6.setUpdateBy(2422L);
            
			   	   list.add(repayment6);
	   List<Repayment> insertResults= this.repaymentService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(Repayment o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<Repayment> getResults= this.repaymentService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(Repayment o :insertResults){
			this.repaymentService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
			
		
	//@Test
	public void  getRepaymentIdsByRepaymentStatus()throws ServiceException, ServiceDaoException{
	 List<Repayment> list=new ArrayList<Repayment>();
	  	  Repayment repayment1  = new Repayment();	   
	   					 
			   					                repayment1.setUserId(2L);
            
			   					                repayment1.setInvestRecordId(2L);
            
			   					                repayment1.setRepaymentDate(2L);
            
			   					                repayment1.setRepaymentAmount(new BigDecimal(1));
            
			   					                repayment1.setMoneyType(32);
            
			   					                repayment1.setRepaymentStatus(1);
            
			   					 
			   					 
			   					                repayment1.setCreateBy(3223L);
            
			   					                repayment1.setUpdateBy(2232L);
            
			   	  list.add(repayment1);	
	  	  Repayment repayment2  = new Repayment();	   
	   					 
			   					                repayment2.setUserId(3L);
            
			   					                repayment2.setInvestRecordId(2L);
            
			   					                repayment2.setRepaymentDate(2L);
            
			   					                repayment2.setRepaymentAmount(new BigDecimal(2));
            
			   					                repayment2.setMoneyType(23);
            
			   					                repayment2.setRepaymentStatus(2);
            
			   					 
			   					 
			   					                repayment2.setCreateBy(242L);
            
			   					                repayment2.setUpdateBy(2422L);
            
			   	  list.add(repayment2);	  
	  List<Repayment> insertResults= this.repaymentService.insertList(list);
		
	
	   
		
	
		List<Long>  lists= repaymentService.getRepaymentIdsByRepaymentStatus(1,0,Integer.MAX_VALUE);
		//TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);		
		
		 for(Repayment o :insertResults){
			this.repaymentService.delete(o.getId());
}
		 
		};

	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

