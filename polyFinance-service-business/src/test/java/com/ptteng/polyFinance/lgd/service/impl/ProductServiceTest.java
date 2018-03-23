package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.Product;
import com.ptteng.polyFinance.lgd.service.ProductService;
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
public class ProductServiceTest {

	private static final Log log = LogFactory.getLog(ProductServiceTest.class);
	
	private ProductService productService;
	
	
	@Before
	    public void setUp() throws Exception{
		
		
		    //dao
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-server.xml");
	        productService = (ProductService) context.getBean("productService");
			//local server
			/**
			productService = (ProductService)  Naming.lookup("//localhost:20310/ProductRMIService");
			**/
			
			/** test client
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
	    	 productService = (ProductService) context.getBean("productService");
			
			**/
			
			
			
	    }
	
	
		
		
		
	

		
	@Test
	public void testCRUD() throws ServiceException, ServiceDaoException{
	
	 // 1.增加
	 
	  	  Product product  = new Product();	   
	   					 
			   					                product.setProductMark("XSB");
            
			   					                product.setName("养老计划");
            
			   					                product.setInterestRate(new BigDecimal(10));
            
			   					                product.setFinancialPeriodDay(30);
            
			   					                product.setFinancialPeriodMonth(12);
            
			   					                product.setPaymentMethod(2);
            
			   					                product.setInterestDelayed(23);
            
			   					                product.setProductStatus(332);
            
			   					                product.setInterestAmountLine(new BigDecimal(20000));
            
			   					                product.setRemark("23223");
            
			   					                product.setDetailsPic("1234");
            
			   					                product.setHotCornerMark(2323);
            
			   					                product.setNewCornerMark(2324);
            
			   					                product.setRecommended(23223);
            
			   					                product.setLimited(1);
            
			   					 
			   					 
			   					                product.setCreateBy(232L);
            
			   					                product.setUpdateBy(234L);
            
			   	 
	 
	  Long id= this.productService.insert(product);

      product = this.productService.getObjectById(id);

	  Product product2=this.productService.getObjectById(id);
	    Assert.assertNotNull(product2);
	  
		// 2. 更改 
				 		 				 				   product.setProductMark("XSB");
		    		 				 				   product.setName("养老计划");
		    		 				 				   product.setInterestRate(new BigDecimal(10));
		    		 				 				   product.setFinancialPeriodDay(30);
		    		 				 				   product.setFinancialPeriodMonth(12);
		    		 				 				   product.setPaymentMethod(2);
		    		 				 				   product.setInterestDelayed(23);
		    		 				 				   product.setProductStatus(332);
		    		 				 				   product.setInterestAmountLine(new BigDecimal(20000));
		    		 				 				   product.setRemark("23223");
		    		 				 				   product.setDetailsPic("sssss");
		    		 				 				   product.setHotCornerMark(2323);
		    		 				 				   product.setNewCornerMark(2324);
		    		 				 				   product.setRecommended(23223);
		    		 				 				   product.setLimited(1);
		    		 				 		 				 		 				 				   product.setCreateBy(232L);
		    		 				 				   product.setUpdateBy(234L);
		    		 				boolean success=this.productService.update(product);		
		Assert.assertEquals(true, success);
		 Product product3=this.productService.getObjectById(id);
				 		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				             		 				 		 				 		 				             		 				             		 				//3.删除
		/*boolean successDelete=this.productService.delete(id);
		Assert.assertEquals(true, success);
		Product product4=this.productService.getObjectById(id);
		Assert.assertNull(product4);*/
		
		//4.batchInsert
		 List<Product> list=new ArrayList<Product>();
	  	  Product product5  = new Product();	   
	   					 
			   					                product5.setProductMark("XSB");
            
			   					                product5.setName("养老计划");
            
			   					                product5.setInterestRate(new BigDecimal(10));
            
			   					                product5.setFinancialPeriodDay(30);
            
			   					                product5.setFinancialPeriodMonth(12);
            
			   					                product5.setPaymentMethod(2);
            
			   					                product5.setInterestDelayed(23);
            
			   					                product5.setProductStatus(332);
            
			   					                product5.setInterestAmountLine(new BigDecimal(20000));
            
			   					                product5.setRemark("23223");
            
			   					                product5.setDetailsPic("222");
            
			   					                product5.setHotCornerMark(2323);
            
			   					                product5.setNewCornerMark(2324);
            
			   					                product5.setRecommended(23223);
            
			   					                product5.setLimited(1);
            
			   					 
			   					 
			   					                product5.setCreateBy(232L);
            
			   					                product5.setUpdateBy(234L);
            
			   	    list.add(product5);	   
	  	  Product product6  = new Product();	   
	   					 
			   					                product6.setProductMark("XSB");
            
			   					                product6.setName("养老计划");
            
			   					                product6.setInterestRate(new BigDecimal(10));
            
			   					                product6.setFinancialPeriodDay(30);
            
			   					                product6.setFinancialPeriodMonth(12);
            
			   					                product6.setPaymentMethod(2);
            
			   					                product6.setInterestDelayed(23);
            
			   					                product6.setProductStatus(332);
            
			   					                product6.setInterestAmountLine(new BigDecimal(20000));
            
			   					                product6.setRemark("23223");
            
			   					                product6.setDetailsPic("222");
            
			   					                product6.setHotCornerMark(2323);
            
			   					                product6.setNewCornerMark(2324);
            
			   					                product6.setRecommended(23223);
            
			   					                product6.setLimited(1);
            
			   					 
			   					 
			   					                product6.setCreateBy(232L);
            
			   					                product6.setUpdateBy(234L);
            
			   	   list.add(product6);
	   List<Product> insertResults= this.productService.insertList(list);
	   Assert.assertEquals(2,insertResults.size());	
	   //5.batchGet
	   List<Long> ids=new ArrayList<Long>();
		for(Product o: insertResults){
		   ids.add(o.getId());
		}
				
	    List<Product> getResults= this.productService.getObjectsByIds(ids);
		Assert.assertEquals(2,getResults.size());
		
		
		 for(Product o :insertResults){
			this.productService.delete(o.getId());
}
			
		//6.batchUpdate
	   
		}
	
	
	
			
		
	//@Test
	public void  getProductIdsByRecommended()throws ServiceException, ServiceDaoException{
	 List<Product> list=new ArrayList<Product>();
	  	  Product product1  = new Product();	   
	   					 
			   					                product1.setProductMark("XSB");
            
			   					                product1.setName("养老计划");
            
			   					                product1.setInterestRate(new BigDecimal(10));
            
			   					                product1.setFinancialPeriodDay(30);
            
			   					                product1.setFinancialPeriodMonth(12);
            
			   					                product1.setPaymentMethod(2);
            
			   					                product1.setInterestDelayed(23);
            
			   					                product1.setProductStatus(332);
            
			   					                product1.setInterestAmountLine(new BigDecimal(20000));
            
			   					                product1.setRemark("23223");
            
			   					                product1.setDetailsPic("222");
            
			   					                product1.setHotCornerMark(2323);
            
			   					                product1.setNewCornerMark(2324);
            
			   					                product1.setRecommended(23223);
            
			   					                product1.setLimited(1);
            
			   					 
			   					 
			   					                product1.setCreateBy(232L);
            
			   					                product1.setUpdateBy(234L);
            
			   	  list.add(product1);	
	  	  Product product2  = new Product();	   
	   					 
			   					                product2.setProductMark("XSB");
            
			   					                product2.setName("养老计划");
            
			   					                product2.setInterestRate(new BigDecimal(10));
            
			   					                product2.setFinancialPeriodDay(30);
            
			   					                product2.setFinancialPeriodMonth(12);
            
			   					                product2.setPaymentMethod(2);
            
			   					                product2.setInterestDelayed(23);
            
			   					                product2.setProductStatus(332);
            
			   					                product2.setInterestAmountLine(new BigDecimal(20000));
            
			   					                product2.setRemark("23223");
            
			   					                product2.setDetailsPic("222");
            
			   					                product2.setHotCornerMark(2323);
            
			   					                product2.setNewCornerMark(2324);
            
			   					                product2.setRecommended(23223);
            
			   					                product2.setLimited(1);
            
			   					 
			   					 
			   					                product2.setCreateBy(232L);
            
			   					                product2.setUpdateBy(234L);
            
			   	  list.add(product2);	  
	  List<Product> insertResults= this.productService.insertList(list);
		
	
	   
		
	
		List<Long>  lists= productService.getProductIdsByProductStatus(23223,0,Integer.MAX_VALUE);
		//TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);		
		
		 for(Product o :insertResults){
			this.productService.delete(o.getId());
}
		 
		};

	
			
		
	//@Test
	public void  getProductIdsByRecommendedAndProductStatus()throws ServiceException, ServiceDaoException{
	 List<Product> list=new ArrayList<Product>();
	  	  Product product1  = new Product();	   
	   					 
			   					                product1.setProductMark("XSB");
            
			   					                product1.setName("养老计划");
            
			   					                product1.setInterestRate(new BigDecimal(10));
            
			   					                product1.setFinancialPeriodDay(30);
            
			   					                product1.setFinancialPeriodMonth(12);
            
			   					                product1.setPaymentMethod(2);
            
			   					                product1.setInterestDelayed(23);
            
			   					                product1.setProductStatus(332);
            
			   					                product1.setInterestAmountLine(new BigDecimal(20000));
            
			   					                product1.setRemark("23223");
            
			   					                product1.setDetailsPic("333");
            
			   					                product1.setHotCornerMark(2323);
            
			   					                product1.setNewCornerMark(2324);
            
			   					                product1.setRecommended(23223);
            
			   					                product1.setLimited(1);
            
			   					 
			   					 
			   					                product1.setCreateBy(232L);
            
			   					                product1.setUpdateBy(234L);
            
			   	  list.add(product1);	
	  	  Product product2  = new Product();	   
	   					 
			   					                product2.setProductMark("XSB");
            
			   					                product2.setName("养老计划");
            
			   					                product2.setInterestRate(new BigDecimal(10));
            
			   					                product2.setFinancialPeriodDay(30);
            
			   					                product2.setFinancialPeriodMonth(12);
            
			   					                product2.setPaymentMethod(2);
            
			   					                product2.setInterestDelayed(23);
            
			   					                product2.setProductStatus(332);
            
			   					                product2.setInterestAmountLine(new BigDecimal(20000));
            
			   					                product2.setRemark("23223");
            
			   					                product2.setDetailsPic("3333");
            
			   					                product2.setHotCornerMark(2323);
            
			   					                product2.setNewCornerMark(2324);
            
			   					                product2.setRecommended(23223);
            
			   					                product2.setLimited(1);
            
			   					 
			   					 
			   					                product2.setCreateBy(232L);
            
			   					                product2.setUpdateBy(234L);
            
			   	  list.add(product2);	  
	  List<Product> insertResults= this.productService.insertList(list);
		
	
	   
		
	
		List<Long>  lists= productService.getProductIdsByRecommendedAndProductStatus(23223,332,0,Integer.MAX_VALUE);
		//TODO 增加自己的验证逻辑
		Assert.assertNotNull(lists);		
		
		 for(Product o :insertResults){
			this.productService.delete(o.getId());
}
		 
		};

	
		
		@Test
	public void  testNULL()throws ServiceException, ServiceDaoException{
		
		
		
		};
}

