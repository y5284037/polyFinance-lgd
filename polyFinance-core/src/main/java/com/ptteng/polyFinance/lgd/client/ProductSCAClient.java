/**
 * 
 */
package com.ptteng.polyFinance.lgd.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.Product;
import com.ptteng.polyFinance.lgd.service.ProductService;

import java.util.List;
import java.util.Map;

public class ProductSCAClient implements ProductService {

    private ProductService productService;

	public ProductService getProductService() {
		return productService;
	}
	
	
	public void setProductService(ProductService productService) {
		this.productService =productService;
	}
	
	
			   
		@Override
		public Long insert(Product product)throws ServiceException, ServiceDaoException{
		
		return productService.insert(product);
		          
		
		}	
		  
    	   
		@Override
		public List<Product> insertList(List<Product> productList)throws ServiceException, ServiceDaoException{
		
		return productService.insertList(productList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return productService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Product product)throws ServiceException, ServiceDaoException{
		
		return productService.update(product);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Product> productList)throws ServiceException, ServiceDaoException{
		
		return productService.updateList(productList);
		          
		
		}	
		  
    	   
		@Override
		public Product getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return productService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Product> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return productService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getProductIdsByRecommended(Integer recommended,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return productService.getProductIdsByRecommended(recommended,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getProductIdsByRecommendedAndProductStatus(Integer recommended,Integer productStatus,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return productService.getProductIdsByRecommendedAndProductStatus(recommended,productStatus,start,limit);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countProductIdsByRecommended(Integer recommended)throws ServiceException, ServiceDaoException{
		
		return productService.countProductIdsByRecommended(recommended);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countProductIdsByRecommendedAndProductStatus(Integer recommended,Integer productStatus)throws ServiceException, ServiceDaoException{
		
		return productService.countProductIdsByRecommendedAndProductStatus(recommended,productStatus);
	
	
	}
	
		
	
		@Override
	public List<Long> getProductIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return productService.getProductIds(start, limit);
	}

	@Override
	public Integer countProductIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return productService.countProductIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return productService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return productService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   productService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.productService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

