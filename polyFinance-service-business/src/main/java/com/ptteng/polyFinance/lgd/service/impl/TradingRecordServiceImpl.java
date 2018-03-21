package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import com.ptteng.polyFinance.lgd.model.TradingRecord;
import com.ptteng.polyFinance.lgd.service.TradingRecordService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class TradingRecordServiceImpl extends BaseDaoServiceImpl implements TradingRecordService {

 

	private static final Log log = LogFactory.getLog(TradingRecordServiceImpl.class);



		   
		@Override
		public Long insert(TradingRecord tradingRecord)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + tradingRecord);

		if (tradingRecord == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		tradingRecord.setCreateAt(currentTimeMillis);
		tradingRecord.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(tradingRecord);
		} catch (DaoException e) {
			log.error(" insert wrong : " + tradingRecord);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<TradingRecord> insertList(List<TradingRecord> tradingRecordList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (tradingRecordList == null ? "null" : tradingRecordList.size()));
      
		List<TradingRecord> resultList = null;

		if (CollectionUtils.isEmpty(tradingRecordList)) {
			return new ArrayList<TradingRecord>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (TradingRecord tradingRecord : tradingRecordList) {
			tradingRecord.setCreateAt(currentTimeMillis);
			tradingRecord.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<TradingRecord>) dao.batchSave(tradingRecordList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + tradingRecordList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert lists  success : " + (resultList == null ? "null" : resultList.size()));
    
		return resultList;
		
		
			
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
	
		            
	    log.info(" delete data : " + id);
 
		boolean result = false;

		if (id == null) {
			return true;
		}

		try {
			result = dao.delete(TradingRecord.class, id);
		} catch (DaoException e) {
			log.error(" delete wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
 
		log.info(" delete data success : " + id);
   
		return result;
		
		}	
		  
    	   
		@Override
		public boolean update(TradingRecord tradingRecord)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (tradingRecord == null ? "null" : tradingRecord.getId()));

		boolean result = false;

		if (tradingRecord == null) {
			return true;
		}

		tradingRecord.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(tradingRecord);
		} catch (DaoException e) {
			log.error(" update wrong : " + tradingRecord);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + tradingRecord);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<TradingRecord> tradingRecordList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (tradingRecordList == null ? "null" : tradingRecordList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(tradingRecordList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (TradingRecord tradingRecord : tradingRecordList) {
			tradingRecord.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(tradingRecordList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + tradingRecordList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + tradingRecordList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public TradingRecord getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		TradingRecord tradingRecord = null;

		if (id == null) {
			return tradingRecord;
		}

		try {
			tradingRecord = (TradingRecord) dao.get(TradingRecord.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return tradingRecord;		
		}	
		  
    	   
		@Override
		public List<TradingRecord> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<TradingRecord> tradingRecord = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<TradingRecord>();
		}

		try {
			tradingRecord = (List<TradingRecord>) dao.getList(TradingRecord.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (tradingRecord == null ? "null" : tradingRecord.size()));
    
		return tradingRecord;	
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
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by userId,start,limit  : " + userId+" , "+start+" , "+limit );
	  }
	 	List<Long> idList = null;
        
        // TODO 参数检查!

        if (start == null) {
            start = 0;
        }

        if (limit == null) {
            limit = Integer.MAX_VALUE;
        }

	try {
		idList = dao.getIdList("getTradingRecordIdsByUserIdOrderByTradingTime", new Object[] { userId},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by userId,start,limit)  : " + userId+" , "+start+" , "+limit );
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
  if(log.isInfoEnabled()){
   log.info(" get ids success : " + (idList == null ? "null" : idList.size()));
  }
		return idList;
		
	
	
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
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by userId  : " + userId );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getTradingRecordIdsByUserIdOrderByTradingTime", new Object[] { userId});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by userId)  : " + userId );
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
  if(log.isInfoEnabled()){
    log.info(" count  success : " + count);
  }
		return count;
		
	
	
	}
	
		
	
	
	
		
	@Override
	public List<Long> getTradingRecordIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		
		log.info(" get ids   by start,limit  ================== " + start + " , " + limit);
		List<Long> idList = null;
		
		
		
		if (start == null) {
			start = 0;
		}

		if (limit == null) {
			limit = Integer.MAX_VALUE;
		}
		
		try {
			idList = dao.getIdList("getTradingRecordIdsAll",new Object[] {},start, limit, false);
		} catch (DaoException e) {
			log.error(" get ids  wrong by start,limit)  : " + start + " , " + limit);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" get ids success == : " + (idList == null ? "null" : idList.size()));
		}
		return idList;
	}
	
	
		@Override
	public Integer countTradingRecordIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getTradingRecordIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getTradingRecordIds " ) ;
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
		if (log.isInfoEnabled()) {
			log.info(" count  : " + count);
		}
		return count;
	}

}

