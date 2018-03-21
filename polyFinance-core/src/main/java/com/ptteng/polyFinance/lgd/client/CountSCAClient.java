/**
 * 
 */
package com.ptteng.polyFinance.lgd.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.Count;
import com.ptteng.polyFinance.lgd.service.CountService;

import java.util.List;
import java.util.Map;

public class CountSCAClient implements CountService {

    private CountService countService;

	public CountService getCountService() {
		return countService;
	}
	
	
	public void setCountService(CountService countService) {
		this.countService =countService;
	}
	
	
			   
		@Override
		public Long insert(Count count)throws ServiceException, ServiceDaoException{
		
		return countService.insert(count);
		          
		
		}	
		  
    	   
		@Override
		public List<Count> insertList(List<Count> countList)throws ServiceException, ServiceDaoException{
		
		return countService.insertList(countList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return countService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Count count)throws ServiceException, ServiceDaoException{
		
		return countService.update(count);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Count> countList)throws ServiceException, ServiceDaoException{
		
		return countService.updateList(countList);
		          
		
		}	
		  
    	   
		@Override
		public Count getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return countService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Count> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return countService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getCountIdsByProductIdOrderByCreateAt(Long productId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return countService.getCountIdsByProductIdOrderByCreateAt(productId,start,limit);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countCountIdsByProductIdOrderByCreateAt(Long productId)throws ServiceException, ServiceDaoException{
		
		return countService.countCountIdsByProductIdOrderByCreateAt(productId);
	
	
	}
	
		
	
		@Override
	public List<Long> getCountIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return countService.getCountIds(start, limit);
	}

	@Override
	public Integer countCountIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return countService.countCountIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return countService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return countService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   countService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.countService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

