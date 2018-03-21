package com.ptteng.polyFinance.lgd.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.polyFinance.lgd.model.TradingRecord;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

@Remotable
public interface TradingRecordService extends BaseDaoService {

	



   		   
		
		public Long insert(TradingRecord tradingRecord)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<TradingRecord> insertList(List<TradingRecord> tradingRecordList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(TradingRecord tradingRecord)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<TradingRecord> tradingRecordList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public TradingRecord getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<TradingRecord> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countTradingRecordIdsByUserIdOrderByTradingTime(Long userId)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getTradingRecordIdsByUserIdOrderByTradingTime(Long userId,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getTradingRecordIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countTradingRecordIds() throws ServiceException, ServiceDaoException;
	

}

