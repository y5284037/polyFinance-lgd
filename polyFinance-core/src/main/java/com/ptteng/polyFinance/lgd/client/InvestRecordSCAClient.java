/**
 * 
 */
package com.ptteng.polyFinance.lgd.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.InvestRecord;
import com.ptteng.polyFinance.lgd.service.InvestRecordService;

import java.util.List;
import java.util.Map;

public class InvestRecordSCAClient implements InvestRecordService {

    private InvestRecordService investRecordService;

	public InvestRecordService getInvestRecordService() {
		return investRecordService;
	}
	
	
	public void setInvestRecordService(InvestRecordService investRecordService) {
		this.investRecordService =investRecordService;
	}
	
	
			   
		@Override
		public Long insert(InvestRecord investRecord)throws ServiceException, ServiceDaoException{
		
		return investRecordService.insert(investRecord);
		          
		
		}	
		  
    	   
		@Override
		public List<InvestRecord> insertList(List<InvestRecord> investRecordList)throws ServiceException, ServiceDaoException{
		
		return investRecordService.insertList(investRecordList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return investRecordService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(InvestRecord investRecord)throws ServiceException, ServiceDaoException{
		
		return investRecordService.update(investRecord);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<InvestRecord> investRecordList)throws ServiceException, ServiceDaoException{
		
		return investRecordService.updateList(investRecordList);
		          
		
		}	
		  
    	   
		@Override
		public InvestRecord getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return investRecordService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<InvestRecord> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return investRecordService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getInvestRecordIdsByUserIdAndInvestStatusOrderByCreateAt(Long userId,Integer investStatus,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return investRecordService.getInvestRecordIdsByUserIdAndInvestStatusOrderByCreateAt(userId,investStatus,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getInvestRecordIdsByProductId(Long productId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return investRecordService.getInvestRecordIdsByProductId(productId,start,limit);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getInvestRecordIdsByUserIdOrderByCreateAt(Long userId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return investRecordService.getInvestRecordIdsByUserIdOrderByCreateAt(userId,start,limit);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countInvestRecordIdsByUserIdAndInvestStatusOrderByCreateAt(Long userId,Integer investStatus)throws ServiceException, ServiceDaoException{
		
		return investRecordService.countInvestRecordIdsByUserIdAndInvestStatusOrderByCreateAt(userId,investStatus);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countInvestRecordIdsByProductId(Long productId)throws ServiceException, ServiceDaoException{
		
		return investRecordService.countInvestRecordIdsByProductId(productId);
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countInvestRecordIdsByUserIdOrderByCreateAt(Long userId)throws ServiceException, ServiceDaoException{
		
		return investRecordService.countInvestRecordIdsByUserIdOrderByCreateAt(userId);
	
	
	}
	
		
	
		@Override
	public List<Long> getInvestRecordIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return investRecordService.getInvestRecordIds(start, limit);
	}

	@Override
	public Integer countInvestRecordIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return investRecordService.countInvestRecordIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return investRecordService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return investRecordService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   investRecordService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.investRecordService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

