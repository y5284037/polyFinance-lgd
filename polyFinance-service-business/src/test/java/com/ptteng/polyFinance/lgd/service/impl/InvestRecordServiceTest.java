package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.InvestRecord;
import com.ptteng.polyFinance.lgd.service.InvestRecordService;
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
public class InvestRecordServiceTest {
    
    private static final Log log = LogFactory.getLog(InvestRecordServiceTest.class);
    
    private InvestRecordService investRecordService;
    
    
    @Before
    public void setUp() throws Exception {
        
        
        //dao
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-server.xml");
        investRecordService = (InvestRecordService) context.getBean("investRecordService");
        //local server
        /**
         investRecordService = (InvestRecordService)  Naming.lookup("//localhost:20310/InvestRecordRMIService");
         **/
        
        /** test client
         ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
         investRecordService = (InvestRecordService) context.getBean("investRecordService");
         
         **/
        
        
    }
    
    
    @Test
    public void test333() {
        
        try {
            InvestRecord a = investRecordService.getObjectById(1L);
            System.out.println(a);
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (ServiceDaoException e) {
            e.printStackTrace();
        }
    }
    
    
    @Test
    public void testCRUD() throws ServiceException, ServiceDaoException {
        
        // 1.增加
        
        InvestRecord investRecord = new InvestRecord();
        
        investRecord.setUserId(2L);
        
        investRecord.setProductId(23L);
        
        investRecord.setProductName("养老计划");
        
        investRecord.setProductInterestRate(new BigDecimal(10));
        
        investRecord.setProductPaymentMethod(2);
        
        investRecord.setProductInterestAmountLine(new BigDecimal(2));
        
        investRecord.setRepaymentBank("2");
        
        investRecord.setRepaymentCard("2");
        
        investRecord.setRepaymentBankName("33");
        
        investRecord.setInvestAmount(new BigDecimal(2));
        
        investRecord.setComodatoNum("1");
        
        investRecord.setIntercreditorAgreement("1");
        
        investRecord.setInvestStatus(323);
        
        investRecord.setUndistributedIncome(new BigDecimal(23232));
        
        investRecord.setDistributionIncome(new BigDecimal(2323));
        
        investRecord.setValueDay(232L);
        
        investRecord.setValueEndDay(2322L);
        
        
        investRecord.setCreateBy(22322L);
        
        
        investRecord.setUpdateBy(32332L);
        
        
        Long id = this.investRecordService.insert(investRecord);
        
        investRecord = this.investRecordService.getObjectById(id);
        
        InvestRecord investRecord2 = this.investRecordService.getObjectById(id);
        Assert.assertNotNull(investRecord2);
        
        // 2. 更改
        investRecord.setUserId(2L);
        investRecord.setProductId(23L);
        investRecord.setProductName("养老计划");
        investRecord.setProductInterestRate(new BigDecimal(10));
        investRecord.setProductPaymentMethod(2);
        investRecord.setProductInterestAmountLine(new BigDecimal(2));
        investRecord.setRepaymentBank("2");
        investRecord.setRepaymentCard("2");
        investRecord.setRepaymentBankName("33");
        investRecord.setInvestAmount(new BigDecimal(2));
        investRecord.setComodatoNum("1");
        investRecord.setIntercreditorAgreement("1");
        investRecord.setInvestStatus(323);
        investRecord.setUndistributedIncome(new BigDecimal(23232));
        investRecord.setDistributionIncome(new BigDecimal(2323));
        investRecord.setValueDay(232L);
        investRecord.setValueEndDay(2322L);
        investRecord.setCreateBy(22322L);
        investRecord.setUpdateBy(32332L);
        boolean success = this.investRecordService.update(investRecord);
        Assert.assertEquals(true, success);
        InvestRecord investRecord3 = this.investRecordService.getObjectById(id);
        //3.删除
        boolean successDelete = this.investRecordService.delete(id);
        Assert.assertEquals(true, success);
        InvestRecord investRecord4 = this.investRecordService.getObjectById(id);
        Assert.assertNull(investRecord4);
        
        //4.batchInsert
        List<InvestRecord> list = new ArrayList<InvestRecord>();
        InvestRecord investRecord5 = new InvestRecord();
        
        investRecord5.setUserId(2L);
        
        investRecord5.setProductId(23L);
        
        investRecord5.setProductName("养老计划");
        
        investRecord5.setProductInterestRate(new BigDecimal(10));
        
        investRecord5.setProductPaymentMethod(2);
        
        investRecord5.setProductInterestAmountLine(new BigDecimal(2));
        
        investRecord5.setRepaymentBank("2");
        
        investRecord5.setRepaymentCard("2");
        
        investRecord5.setRepaymentBankName("33");
        
        investRecord5.setInvestAmount(new BigDecimal(2));
        
        investRecord5.setComodatoNum("1");
        
        investRecord5.setIntercreditorAgreement("1");
        
        investRecord5.setInvestStatus(323);
        
        investRecord5.setUndistributedIncome(new BigDecimal(23232));
        
        investRecord5.setDistributionIncome(new BigDecimal(2323));
        
        investRecord5.setValueDay(232L);
        
        investRecord5.setValueEndDay(2322L);
        
        
        investRecord5.setCreateBy(22322L);
        
        
        investRecord5.setUpdateBy(32332L);
        
        list.add(investRecord5);
        InvestRecord investRecord6 = new InvestRecord();
        
        investRecord6.setUserId(2L);
        
        investRecord6.setProductId(23L);
        
        investRecord6.setProductName("养老计划");
        
        investRecord6.setProductInterestRate(new BigDecimal(10));
        
        investRecord6.setProductPaymentMethod(2);
        
        investRecord6.setProductInterestAmountLine(new BigDecimal(2));
        
        investRecord6.setRepaymentBank("2");
        
        investRecord6.setRepaymentCard("2");
        
        investRecord6.setRepaymentBankName("33");
        
        investRecord6.setInvestAmount(new BigDecimal(2));
        
        investRecord6.setComodatoNum("1");
        
        investRecord6.setIntercreditorAgreement("1");
        
        investRecord6.setInvestStatus(323);
        
        investRecord6.setUndistributedIncome(new BigDecimal(23232));
        
        investRecord6.setDistributionIncome(new BigDecimal(2323));
        
        investRecord6.setValueDay(232L);
        
        investRecord6.setValueEndDay(2322L);
        
        
        investRecord6.setCreateBy(22322L);
        
        
        investRecord6.setUpdateBy(32332L);
        
        list.add(investRecord6);
        List<InvestRecord> insertResults = this.investRecordService.insertList(list);
        Assert.assertEquals(2, insertResults.size());
        //5.batchGet
        List<Long> ids = new ArrayList<Long>();
        for (InvestRecord o : insertResults) {
            ids.add(o.getId());
        }
        
        List<InvestRecord> getResults = this.investRecordService.getObjectsByIds(ids);
        Assert.assertEquals(2, getResults.size());
        
        
        for (InvestRecord o : insertResults) {
            this.investRecordService.delete(o.getId());
        }
        
        //6.batchUpdate
        
    }
	
	
	
	/*
		
	@Test
	public void  getInvestRecordIdsByUserIdAndInvestStatusOrderByCreateAt()throws ServiceException, ServiceDaoException{
	 List<InvestRecord> list=new ArrayList<InvestRecord>();
	  	  InvestRecord investRecord1  = new InvestRecord();	   
	   					 
			   					                investRecord1.setUserId(2L);
            
			   					                investRecord1.setProductId(23L);
            
			   					                investRecord1.setProductName("养老计划");
            
			   					                investRecord1.setProductInterestRate(10);
            
			   					                investRecord1.setProductPaymentMethod(2);
            
			   					                investRecord1.setProductInterestAmountLine(2);
            
			   					                investRecord1.setRepaymentBank("2");
            
			   					                investRecord1.setRepaymentCard("2");
            
			   					                investRecord1.setRepaymentBankName("33");
            
			   					                investRecord1.setInvestAmount(2);
            
			   					                investRecord1.setComodatoNum("1");
            
			   					                investRecord1.setIntercreditorAgreement("1");
            
			   					                investRecord1.setInvestStatus(323);
            
			   					                investRecord1.setUndistributedIncome(23232);
            
			   					                investRecord1.setDistributionIncome(2323);
            
			   					                investRecord1.setValueDay(232L);
            
			   					                investRecord1.setValueEndDay(2322L);
            
			   					 
			   					                investRecord1.setCreateBy(22322L);
            
			   					 
			   					                investRecord1.setUpdateBy(32332L);
            
			   	  list.add(investRecord1);	
	  	  InvestRecord investRecord2  = new InvestRecord();	   
	   					 
			   					                investRecord2.setUserId(2L);
            
			   					                investRecord2.setProductId(23L);
            
			   					                investRecord2.setProductName("养老计划");
            
			   					                investRecord2.setProductInterestRate(10);
            
			   					                investRecord2.setProductPaymentMethod(2);
            
			   					                investRecord2.setProductInterestAmountLine(2);
            
			   					                investRecord2.setRepaymentBank("2");
            
			   					                investRecord2.setRepaymentCard("2");
            
			   					                investRecord2.setRepaymentBankName("33");
            
			   					                investRecord2.setInvestAmount(2);
            
			   					                investRecord2.setComodatoNum("1");
            
			   					                investRecord2.setIntercreditorAgreement("1");
            
			   					                investRecord2.setInvestStatus(323);
            
			   					                investRecord2.setUndistributedIncome(23232);
            
			   					                investRecord2.setDistributionIncome(2323);
            
			   					                investRecord2.setValueDay(232L);
            
			   					                investRecord2.setValueEndDay(2322L);
            
			   					 
			   					                investRecord2.setCreateBy(22322L);
            
			   					 
			   					                investRecord2.setUpdateBy(32332L);
            
			   	  list.add(investRecord2);	  
	  List<InvestRecord> insertResults= this.investRecordService.insertList(list);
		
	
	   
		
	
		List<Long>  lists= investRecordService.getInvestRecordIdsByUserIdAndInvestStatusOrderByCreateAt(2L,323,0,Integer.MAX_VALUE);
		//TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);		
		
		 for(InvestRecord o :insertResults){
			this.investRecordService.delete(o.getId());
}
		 
		};

	
			
		
	@Test
	public void  getInvestRecordIdsByProductId()throws ServiceException, ServiceDaoException{
	 List<InvestRecord> list=new ArrayList<InvestRecord>();
	  	  InvestRecord investRecord1  = new InvestRecord();	   
	   					 
			   					                investRecord1.setUserId(2L);
            
			   					                investRecord1.setProductId(23L);
            
			   					                investRecord1.setProductName("养老计划");
            
			   					                investRecord1.setProductInterestRate(10);
            
			   					                investRecord1.setProductPaymentMethod(2);
            
			   					                investRecord1.setProductInterestAmountLine(2);
            
			   					                investRecord1.setRepaymentBank("2");
            
			   					                investRecord1.setRepaymentCard("2");
            
			   					                investRecord1.setRepaymentBankName("33");
            
			   					                investRecord1.setInvestAmount(2);
            
			   					                investRecord1.setComodatoNum("1");
            
			   					                investRecord1.setIntercreditorAgreement("1");
            
			   					                investRecord1.setInvestStatus(323);
            
			   					                investRecord1.setUndistributedIncome(23232);
            
			   					                investRecord1.setDistributionIncome(2323);
            
			   					                investRecord1.setValueDay(232L);
            
			   					                investRecord1.setValueEndDay(2322L);
            
			   					 
			   					                investRecord1.setCreateBy(22322L);
            
			   					 
			   					                investRecord1.setUpdateBy(32332L);
            
			   	  list.add(investRecord1);	
	  	  InvestRecord investRecord2  = new InvestRecord();	   
	   					 
			   					                investRecord2.setUserId(2L);
            
			   					                investRecord2.setProductId(23L);
            
			   					                investRecord2.setProductName("养老计划");
            
			   					                investRecord2.setProductInterestRate(10);
            
			   					                investRecord2.setProductPaymentMethod(2);
            
			   					                investRecord2.setProductInterestAmountLine(2);
            
			   					                investRecord2.setRepaymentBank("2");
            
			   					                investRecord2.setRepaymentCard("2");
            
			   					                investRecord2.setRepaymentBankName("33");
            
			   					                investRecord2.setInvestAmount(2);
            
			   					                investRecord2.setComodatoNum("1");
            
			   					                investRecord2.setIntercreditorAgreement("1");
            
			   					                investRecord2.setInvestStatus(323);
            
			   					                investRecord2.setUndistributedIncome(23232);
            
			   					                investRecord2.setDistributionIncome(2323);
            
			   					                investRecord2.setValueDay(232L);
            
			   					                investRecord2.setValueEndDay(2322L);
            
			   					 
			   					                investRecord2.setCreateBy(22322L);
            
			   					 
			   					                investRecord2.setUpdateBy(32332L);
            
			   	  list.add(investRecord2);	  
	  List<InvestRecord> insertResults= this.investRecordService.insertList(list);
		
	
	   
		
	
		List<Long>  lists= investRecordService.getInvestRecordIdsByProductId(23L,0,Integer.MAX_VALUE);
		//TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);		
		
		 for(InvestRecord o :insertResults){
			this.investRecordService.delete(o.getId());
}
		 
		};

	
			
		
	@Test
	public void  getInvestRecordIdsByUserIdOrderByCreateAt()throws ServiceException, ServiceDaoException{
	 List<InvestRecord> list=new ArrayList<InvestRecord>();
	  	  InvestRecord investRecord1  = new InvestRecord();	   
	   					 
			   					                investRecord1.setUserId(2L);
            
			   					                investRecord1.setProductId(23L);
            
			   					                investRecord1.setProductName("养老计划");
            
			   					                investRecord1.setProductInterestRate(10);
            
			   					                investRecord1.setProductPaymentMethod(2);
            
			   					                investRecord1.setProductInterestAmountLine(2);
            
			   					                investRecord1.setRepaymentBank("2");
            
			   					                investRecord1.setRepaymentCard("2");
            
			   					                investRecord1.setRepaymentBankName("33");
            
			   					                investRecord1.setInvestAmount(2);
            
			   					                investRecord1.setComodatoNum("1");
            
			   					                investRecord1.setIntercreditorAgreement("1");
            
			   					                investRecord1.setInvestStatus(323);
            
			   					                investRecord1.setUndistributedIncome(23232);
            
			   					                investRecord1.setDistributionIncome(2323);
            
			   					                investRecord1.setValueDay(232L);
            
			   					                investRecord1.setValueEndDay(2322L);
            
			   					 
			   					                investRecord1.setCreateBy(22322L);
            
			   					 
			   					                investRecord1.setUpdateBy(32332L);
            
			   	  list.add(investRecord1);	
	  	  InvestRecord investRecord2  = new InvestRecord();	   
	   					 
			   					                investRecord2.setUserId(2L);
            
			   					                investRecord2.setProductId(23L);
            
			   					                investRecord2.setProductName("养老计划");
            
			   					                investRecord2.setProductInterestRate(10);
            
			   					                investRecord2.setProductPaymentMethod(2);
            
			   					                investRecord2.setProductInterestAmountLine(2);
            
			   					                investRecord2.setRepaymentBank("2");
            
			   					                investRecord2.setRepaymentCard("2");
            
			   					                investRecord2.setRepaymentBankName("33");
            
			   					                investRecord2.setInvestAmount(2);
            
			   					                investRecord2.setComodatoNum("1");
            
			   					                investRecord2.setIntercreditorAgreement("1");
            
			   					                investRecord2.setInvestStatus(323);
            
			   					                investRecord2.setUndistributedIncome(23232);
            
			   					                investRecord2.setDistributionIncome(2323);
            
			   					                investRecord2.setValueDay(232L);
            
			   					                investRecord2.setValueEndDay(2322L);
            
			   					 
			   					                investRecord2.setCreateBy(22322L);
            
			   					 
			   					                investRecord2.setUpdateBy(32332L);
            
			   	  list.add(investRecord2);	  
	  List<InvestRecord> insertResults= this.investRecordService.insertList(list);
		
	
	   
		
	
		List<Long>  lists= investRecordService.getInvestRecordIdsByUserIdOrderByCreateAt(2L,0,Integer.MAX_VALUE);
		//TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);		
		
		 for(InvestRecord o :insertResults){
			this.investRecordService.delete(o.getId());
}
		 
		};

	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};*/
}

