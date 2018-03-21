/**
 * 
 */
package com.ptteng.polyFinance.lgd.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.TradingRecord;
import com.ptteng.polyFinance.lgd.service.TradingRecordService;

import java.util.List;
import java.util.Map;

public class TradingRecordSCAClient implements TradingRecordService {

    private TradingRecordService tradingRecordService;

	public TradingRecordService getTradingRecordService() {
		return tradingRecordService;
	}
	
	
	public void setTradingRecordService(TradingRecordService tradingRecordService) {
		this.tradingRecordService =tradingRecordService;
	}
	
	
			   
		@Override
		public Long insert(TradingRecord tradingRecord)throws ServiceException, ServiceDaoException{
		
		return tradingRecordService.insert(tradingRecord);
		          
		
		}	
		  
    	   
		@Override
		public List<TradingRecord> insertList(List<TradingRecord> tradingRecordList)throws ServiceException, ServiceDaoException{
		
		return tradingRecordService.insertList(tradingRecordList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return tradingRecordService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(TradingRecord tradingRecord)throws ServiceException, ServiceDaoException{
		
		return tradingRecordService.update(tradingRecord);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<TradingRecord> tradingRecordList)throws ServiceException, ServiceDaoException{
		
		return tradingRecordService.updateList(tradingRecordList);
		          
		
		}	
		  
    	   
		@Override
		public TradingRecord getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return tradingRecordService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<TradingRecord> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return tradingRecordService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getTradingRecordIdsByUserIdOrderByTradingTime(Long userId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return tradingRecordService.getTradingRecordIdsByUserIdOrderByTradingTime(userId,start,limit);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countTradingRecordIdsByUserIdOrderByTradingTime(Long userId)throws ServiceException, ServiceDaoException{
		
		return tradingRecordService.countTradingRecordIdsByUserIdOrderByTradingTime(userId);
	
	
	}
	
		
	
		@Override
	public List<Long> getTradingRecordIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return tradingRecordService.getTradingRecordIds(start, limit);
	}

	@Override
	public Integer countTradingRecordIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return tradingRecordService.countTradingRecordIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return tradingRecordService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return tradingRecordService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   tradingRecordService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.tradingRecordService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

