package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.TradingRecord;
import com.ptteng.polyFinance.lgd.service.TradingRecordService;
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
public class TradingRecordServiceTest {

	private static final Log log = LogFactory.getLog(TradingRecordServiceTest.class);
	
	private TradingRecordService tradingRecordService;
	
	
	//@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/polyFinance-lgd-server/applicationContext-server.xml");
	        tradingRecordService = (TradingRecordService) context.getBean("tradingRecordService");
			//local server
			/**
			tradingRecordService = (TradingRecordService)  Naming.lookup("//localhost:20310/TradingRecordRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 tradingRecordService = (TradingRecordService) context.getBean("tradingRecordService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	//@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  TradingRecord tradingRecord  = new TradingRecord();	   
	   					 
			   					                tradingRecord.setUserId(1L);
            
			   					                tradingRecord.setTradingNum("020012345689");
            
			   					                tradingRecord.setProductName("yangmao");
            
			   					                tradingRecord.setTradingAmount(new BigDecimal(2000));
            
			   					                tradingRecord.setTradingType(1);
            
			   					                tradingRecord.setTradingStatus(1);
            
			   					                tradingRecord.setTradingMode("工商银行（2508）");
            
			   					                tradingRecord.setTradingTime(34L);
            
			   					 
			   					 
			   					                tradingRecord.setCreateBy(34343L);
            
			   					                tradingRecord.setUpdateBy(12212L);
            
			   	 
	 
	  Long id= this.tradingRecordService.insert(tradingRecord);

      tradingRecord = this.tradingRecordService.getObjectById(id);

	  TradingRecord tradingRecord2=this.tradingRecordService.getObjectById(id);
	    Assert.assertNotNull(tradingRecord2);
	  
		// 2. 更改 
				 		 				 				   tradingRecord.setUserId(1L);
		    		 				 				   tradingRecord.setTradingNum("020012345689");
		    		 				 				   tradingRecord.setProductName("yangmao");
		    		 				 				   tradingRecord.setTradingAmount(new BigDecimal(2000));
		    		 				 				   tradingRecord.setTradingType(1);
		    		 				 				   tradingRecord.setTradingStatus(1);
		    		 				 				   tradingRecord.setTradingMode("工商银行（2508）");
		    		 				 				   tradingRecord.setTradingTime(34L);
		    		 				 		 				 		 				 				   tradingRecord.setCreateBy(34343L);
		    		 				 				   tradingRecord.setUpdateBy(12212L);
		    		 				boolean success=this.tradingRecordService.update(tradingRecord);		
		Assert.assertEquals(true, success);
		 TradingRecord tradingRecord3=this.tradingRecordService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		boolean successDelete=this.tradingRecordService.delete(id);	
		Assert.assertEquals(true, success);
		TradingRecord tradingRecord4=this.tradingRecordService.getObjectById(id);
		Assert.assertNull(tradingRecord4);
		
		//4.batchInsert
		 List<TradingRecord> list=new ArrayList<TradingRecord>();
	  	  TradingRecord tradingRecord5  = new TradingRecord();	   
	   					 
			   					                tradingRecord5.setUserId(1L);
            
			   					                tradingRecord5.setTradingNum("020012345689");
            
			   					                tradingRecord5.setProductName("yangmao");
            
			   					                tradingRecord5.setTradingAmount(new BigDecimal(2000));
            
			   					                tradingRecord5.setTradingType(1);
            
			   					                tradingRecord5.setTradingStatus(1);
            
			   					                tradingRecord5.setTradingMode("工商银行（2508）");
            
			   					                tradingRecord5.setTradingTime(34L);
            
			   					 
			   					 
			   					                tradingRecord5.setCreateBy(34343L);
            
			   					                tradingRecord5.setUpdateBy(12212L);
            
			   	    list.add(tradingRecord5);	   
	  	  TradingRecord tradingRecord6  = new TradingRecord();	   
	   					 
			   					                tradingRecord6.setUserId(1L);
            
			   					                tradingRecord6.setTradingNum("020012345689");
            
			   					                tradingRecord6.setProductName("yangmao");
            
			   					                tradingRecord6.setTradingAmount(new BigDecimal(2000));
            
			   					                tradingRecord6.setTradingType(1);
            
			   					                tradingRecord6.setTradingStatus(1);
            
			   					                tradingRecord6.setTradingMode("工商银行（2508）");
            
			   					                tradingRecord6.setTradingTime(34L);
            
			   					 
			   					 
			   					                tradingRecord6.setCreateBy(34343L);
            
			   					                tradingRecord6.setUpdateBy(12212L);
            
			   	   list.add(tradingRecord6);
	   List<TradingRecord> insertResults= this.tradingRecordService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(TradingRecord o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<TradingRecord> getResults= this.tradingRecordService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(TradingRecord o :insertResults){
			this.tradingRecordService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
			
		
	//@Test
	public void  getTradingRecordIdsByUserIdOrderByTradingTime()throws ServiceException, ServiceDaoException{
	 List<TradingRecord> list=new ArrayList<TradingRecord>();
	  	  TradingRecord tradingRecord1  = new TradingRecord();	   
	   					 
			   					                tradingRecord1.setUserId(1L);
            
			   					                tradingRecord1.setTradingNum("020012345689");
            
			   					                tradingRecord1.setProductName("yangmao");
            
			   					                tradingRecord1.setTradingAmount(new BigDecimal(2000));
            
			   					                tradingRecord1.setTradingType(1);
            
			   					                tradingRecord1.setTradingStatus(1);
            
			   					                tradingRecord1.setTradingMode("工商银行（2508）");
            
			   					                tradingRecord1.setTradingTime(34L);
            
			   					 
			   					 
			   					                tradingRecord1.setCreateBy(34343L);
            
			   					                tradingRecord1.setUpdateBy(12212L);
            
			   	  list.add(tradingRecord1);	
	  	  TradingRecord tradingRecord2  = new TradingRecord();	   
	   					 
			   					                tradingRecord2.setUserId(1L);
            
			   					                tradingRecord2.setTradingNum("020012345689");
            
			   					                tradingRecord2.setProductName("yangmao");
            
			   					                tradingRecord2.setTradingAmount( new BigDecimal(2000));
            
			   					                tradingRecord2.setTradingType(1);
            
			   					                tradingRecord2.setTradingStatus(1);
            
			   					                tradingRecord2.setTradingMode("工商银行（2508）");
            
			   					                tradingRecord2.setTradingTime(34L);
            
			   					 
			   					 
			   					                tradingRecord2.setCreateBy(34343L);
            
			   					                tradingRecord2.setUpdateBy(12212L);
            
			   	  list.add(tradingRecord2);	  
	  List<TradingRecord> insertResults= this.tradingRecordService.insertList(list);
		
	
	   
		
	
		List<Long>  lists= tradingRecordService.getTradingRecordIdsByUserIdOrderByTradingTime(1L,0,Integer.MAX_VALUE);
		//TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);		
		
		 for(TradingRecord o :insertResults){
			this.tradingRecordService.delete(o.getId());
}
		 
		};

	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

