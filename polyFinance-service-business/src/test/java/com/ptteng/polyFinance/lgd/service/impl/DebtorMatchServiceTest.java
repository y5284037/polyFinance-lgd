package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.DebtorMatch;
import com.ptteng.polyFinance.lgd.service.DebtorMatchService;
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
public class DebtorMatchServiceTest {

	private static final Log log = LogFactory.getLog(DebtorMatchServiceTest.class);
	
	private DebtorMatchService debtorMatchService;
	
	
	@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/polyFinance-lgd-server/applicationContext-server.xml");
	        debtorMatchService = (DebtorMatchService) context.getBean("debtorMatchService");
			//local server
			/**
			debtorMatchService = (DebtorMatchService)  Naming.lookup("//localhost:20310/DebtorMatchRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 debtorMatchService = (DebtorMatchService) context.getBean("debtorMatchService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  DebtorMatch debtorMatch  = new DebtorMatch();	   
	   					 
			   					                debtorMatch.setDebtorId(1L);
            
			   					                debtorMatch.setComodatoNum("2");
            
			   					                debtorMatch.setIntercreditorAgreement("2");
            
			   					                debtorMatch.setName("1");
            
			   					                debtorMatch.setProductName("1");
            
			   					                debtorMatch.setValueDay(23L);
            
			   					                debtorMatch.setValueEndDay(234L);
            
			   					                debtorMatch.setInvestAmount(new BigDecimal(234));
            
			   					 
			   					 
			   					                debtorMatch.setCreateBy(23321L);
            
			   					                debtorMatch.setUpdateBy(2334L);
            
			   	 
	 
	  Long id= this.debtorMatchService.insert(debtorMatch);

      debtorMatch = this.debtorMatchService.getObjectById(id);

	  DebtorMatch debtorMatch2=this.debtorMatchService.getObjectById(id);
	    Assert.assertNotNull(debtorMatch2);
	  
		// 2. 更改 
				 		 				 				   debtorMatch.setDebtorId(3L);
		    		 				 				   debtorMatch.setComodatoNum("2");
		    		 				 				   debtorMatch.setIntercreditorAgreement("2");
		    		 				 				   debtorMatch.setName("2");
		    		 				 				   debtorMatch.setProductName("2");
		    		 				 				   debtorMatch.setValueDay(234L);
		    		 				 				   debtorMatch.setValueEndDay(234L);
		    		 				 				   debtorMatch.setInvestAmount(new BigDecimal(2344));
		    		 				 		 				 		 				 				   debtorMatch.setCreateBy(234423L);
		    		 				 				   debtorMatch.setUpdateBy(23423L);
		    		 				boolean success=this.debtorMatchService.update(debtorMatch);		
		Assert.assertEquals(true, success);
		 DebtorMatch debtorMatch3=this.debtorMatchService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.debtorMatchService.delete(id);	
		Assert.assertEquals(true, success);
		DebtorMatch debtorMatch4=this.debtorMatchService.getObjectById(id);
		Assert.assertNull(debtorMatch4);
		
		//4.batchInsert
		 List<DebtorMatch> list=new ArrayList<DebtorMatch>();
	  	  DebtorMatch debtorMatch5  = new DebtorMatch();	   
	   					 
			   					                debtorMatch5.setDebtorId(1L);
            
			   					                debtorMatch5.setComodatoNum("2");
            
			   					                debtorMatch5.setIntercreditorAgreement("2");
            
			   					                debtorMatch5.setName("1");
            
			   					                debtorMatch5.setProductName("1");
            
			   					                debtorMatch5.setValueDay(23L);
            
			   					                debtorMatch5.setValueEndDay(234L);
            
			   					                debtorMatch5.setInvestAmount(new BigDecimal(234));
            
			   					 
			   					 
			   					                debtorMatch5.setCreateBy(23321L);
            
			   					                debtorMatch5.setUpdateBy(2334L);
            
			   	    list.add(debtorMatch5);	   
	  	  DebtorMatch debtorMatch6  = new DebtorMatch();	   
	   					 
			   					                debtorMatch6.setDebtorId(3L);
            
			   					                debtorMatch6.setComodatoNum("2");
            
			   					                debtorMatch6.setIntercreditorAgreement("2");
            
			   					                debtorMatch6.setName("2");
            
			   					                debtorMatch6.setProductName("2");
            
			   					                debtorMatch6.setValueDay(234L);
            
			   					                debtorMatch6.setValueEndDay(234L);
            
			   					                debtorMatch6.setInvestAmount(new BigDecimal(2344));
            
			   					 
			   					 
			   					                debtorMatch6.setCreateBy(234423L);
            
			   					                debtorMatch6.setUpdateBy(23423L);
            
			   	   list.add(debtorMatch6);
	   List<DebtorMatch> insertResults= this.debtorMatchService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(DebtorMatch o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<DebtorMatch> getResults= this.debtorMatchService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(DebtorMatch o :insertResults){
			this.debtorMatchService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
			
		
	//@Test
	public void  getDebtorMatchIdsByDebtorId()throws ServiceException, ServiceDaoException{
	 List<DebtorMatch> list=new ArrayList<DebtorMatch>();
	  	  DebtorMatch debtorMatch1  = new DebtorMatch();	   
	   					 
			   					                debtorMatch1.setDebtorId(1L);
            
			   					                debtorMatch1.setComodatoNum("2");
            
			   					                debtorMatch1.setIntercreditorAgreement("2");
            
			   					                debtorMatch1.setName("1");
            
			   					                debtorMatch1.setProductName("1");
            
			   					                debtorMatch1.setValueDay(23L);
            
			   					                debtorMatch1.setValueEndDay(234L);
            
			   					                debtorMatch1.setInvestAmount(new BigDecimal(234));
            
			   					 
			   					 
			   					                debtorMatch1.setCreateBy(23321L);
            
			   					                debtorMatch1.setUpdateBy(2334L);
            
			   	  list.add(debtorMatch1);	
	  	  DebtorMatch debtorMatch2  = new DebtorMatch();	   
	   					 
			   					                debtorMatch2.setDebtorId(3L);
            
			   					                debtorMatch2.setComodatoNum("2");
            
			   					                debtorMatch2.setIntercreditorAgreement("2");
            
			   					                debtorMatch2.setName("2");
            
			   					                debtorMatch2.setProductName("2");
            
			   					                debtorMatch2.setValueDay(234L);
            
			   					                debtorMatch2.setValueEndDay(234L);
            
			   					                debtorMatch2.setInvestAmount(new BigDecimal(2344));
            
			   					 
			   					 
			   					                debtorMatch2.setCreateBy(234423L);
            
			   					                debtorMatch2.setUpdateBy(23423L);
            
			   	  list.add(debtorMatch2);	  
	  List<DebtorMatch> insertResults= this.debtorMatchService.insertList(list);
		
	
	   
		
	
		List<Long>  lists= debtorMatchService.getDebtorMatchIdsByDebtorId(1L,0,Integer.MAX_VALUE);
		//TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);		
		
		 for(DebtorMatch o :insertResults){
			this.debtorMatchService.delete(o.getId());
}
		 
		};

	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

