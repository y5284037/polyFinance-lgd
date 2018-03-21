package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.Debtor;
import com.ptteng.polyFinance.lgd.service.DebtorService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Ignore
public class DebtorServiceTest {

	private static final Log log = LogFactory.getLog(DebtorServiceTest.class);
	
	private DebtorService debtorService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/polyFinance-lgd-server/applicationContext-server.xml");
	        debtorService = (DebtorService) context.getBean("debtorService");
			//local server
			/**
			debtorService = (DebtorService)  Naming.lookup("//localhost:20310/DebtorRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 debtorService = (DebtorService) context.getBean("debtorService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  Debtor debtor  = new Debtor();	   
	   					 
			   					                debtor.setDebtorMark("1");
            
			   					                debtor.setDebtorName("2");
            
			   					                debtor.setDebtorPhone("2");
            
			   					                debtor.setDebtorIDcard("1");
            
			   					                debtor.setExpires(1);
            
			   					                debtor.setDebtStartTime(23L);
            
			   					                debtor.setDebtEndTime(234L);
            
			   					                debtor.setAmount(new BigDecimal(2344));
            
			   					                debtor.setDebtorInvest(new BigDecimal(2344));
            
			   					                debtor.setStatus(2355);
            
			   					                debtor.setMatchedAmount(new BigDecimal(23321));
            
			   					                debtor.setRemark("2334");
            
			   					                debtor.setNature("2344");
            
			   					 
			   					 
			   					                debtor.setCreateBy(2334L);
            
			   					                debtor.setUpdateBy(2334L);
            
			   	 
	 
	  Long id= this.debtorService.insert(debtor);

      debtor = this.debtorService.getObjectById(id);

	  Debtor debtor2=this.debtorService.getObjectById(id);
	    Assert.assertNotNull(debtor2);
	  
		// 2. 更改 
				 		 				 				   debtor.setDebtorMark("1");
		    		 				 				   debtor.setDebtorName("2");
		    		 				 				   debtor.setDebtorPhone("2");
		    		 				 				   debtor.setDebtorIDcard("1");
		    		 				 				   debtor.setExpires(1);
		    		 				 				   debtor.setDebtStartTime(23L);
		    		 				 				   debtor.setDebtEndTime(234L);
		    		 				 				   debtor.setAmount(new BigDecimal(234));
		    		 				 				   debtor.setDebtorInvest(new BigDecimal(2344));
		    		 				 				   debtor.setStatus(2355);
		    		 				 				   debtor.setMatchedAmount(new BigDecimal(23321));
		    		 				 				   debtor.setRemark("2334");
		    		 				 				   debtor.setNature("2344");
		    		 				 		 				 		 				 				   debtor.setCreateBy(2334L);
		    		 				 				   debtor.setUpdateBy(2334L);
		    		 				boolean success=this.debtorService.update(debtor);		
		Assert.assertEquals(true, success);
		 Debtor debtor3=this.debtorService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.debtorService.delete(id);	
		Assert.assertEquals(true, success);
		Debtor debtor4=this.debtorService.getObjectById(id);
		Assert.assertNull(debtor4);
		
		//4.batchInsert
		 List<Debtor> list=new ArrayList<Debtor>();
	  	  Debtor debtor5  = new Debtor();	   
	   					 
			   					                debtor5.setDebtorMark("1");
            
			   					                debtor5.setDebtorName("2");
            
			   					                debtor5.setDebtorPhone("2");
            
			   					                debtor5.setDebtorIDcard("1");
            
			   					                debtor5.setExpires(1);
            
			   					                debtor5.setDebtStartTime(23L);
            
			   					                debtor5.setDebtEndTime(234L);
            
			   					                debtor5.setAmount(new BigDecimal(234));
            
			   					                debtor5.setDebtorInvest(new BigDecimal(2344));
            
			   					                debtor5.setStatus(2355);
            
			   					                debtor5.setMatchedAmount(new BigDecimal(23321));
            
			   					                debtor5.setRemark("2334");
            
			   					                debtor5.setNature("2344");
            
			   					 
			   					 
			   					                debtor5.setCreateBy(2334L);
            
			   					                debtor5.setUpdateBy(2334L);
            
			   	    list.add(debtor5);	   
	  	  Debtor debtor6  = new Debtor();	   
	   					 
			   					                debtor6.setDebtorMark("1");
            
			   					                debtor6.setDebtorName("2");
            
			   					                debtor6.setDebtorPhone("2");
            
			   					                debtor6.setDebtorIDcard("1");
            
			   					                debtor6.setExpires(1);
            
			   					                debtor6.setDebtStartTime(23L);
            
			   					                debtor6.setDebtEndTime(234L);
            
			   					                debtor6.setAmount(new BigDecimal(234));
            
			   					                debtor6.setDebtorInvest(new BigDecimal(2344));
            
			   					                debtor6.setStatus(2355);
            
			   					                debtor6.setMatchedAmount(new BigDecimal(23321));
            
			   					                debtor6.setRemark("2334");
            
			   					                debtor6.setNature("2344");
            
			   					 
			   					 
			   					                debtor6.setCreateBy(2334L);
            
			   					                debtor6.setUpdateBy(2334L);
            
			   	   list.add(debtor6);
	   List<Debtor> insertResults= this.debtorService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(Debtor o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<Debtor> getResults= this.debtorService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(Debtor o :insertResults){
			this.debtorService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

