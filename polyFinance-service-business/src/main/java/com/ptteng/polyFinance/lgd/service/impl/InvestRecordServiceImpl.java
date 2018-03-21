package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import com.ptteng.polyFinance.lgd.model.InvestRecord;
import com.ptteng.polyFinance.lgd.service.InvestRecordService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class InvestRecordServiceImpl extends BaseDaoServiceImpl implements InvestRecordService {

 

	private static final Log log = LogFactory.getLog(InvestRecordServiceImpl.class);



		   
		@Override
		public Long insert(InvestRecord investRecord)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + investRecord);

		if (investRecord == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		investRecord.setCreateAt(currentTimeMillis);
		investRecord.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(investRecord);
		} catch (DaoException e) {
			log.error(" insert wrong : " + investRecord);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<InvestRecord> insertList(List<InvestRecord> investRecordList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (investRecordList == null ? "null" : investRecordList.size()));
      
		List<InvestRecord> resultList = null;

		if (CollectionUtils.isEmpty(investRecordList)) {
			return new ArrayList<InvestRecord>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (InvestRecord investRecord : investRecordList) {
			investRecord.setCreateAt(currentTimeMillis);
			investRecord.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<InvestRecord>) dao.batchSave(investRecordList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + investRecordList);
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
			result = dao.delete(InvestRecord.class, id);
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
		public boolean update(InvestRecord investRecord)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (investRecord == null ? "null" : investRecord.getId()));

		boolean result = false;

		if (investRecord == null) {
			return true;
		}

		investRecord.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(investRecord);
		} catch (DaoException e) {
			log.error(" update wrong : " + investRecord);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + investRecord);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<InvestRecord> investRecordList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (investRecordList == null ? "null" : investRecordList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(investRecordList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (InvestRecord investRecord : investRecordList) {
			investRecord.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(investRecordList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + investRecordList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + investRecordList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public InvestRecord getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		InvestRecord investRecord = null;

		if (id == null) {
			return investRecord;
		}

		try {
			investRecord = (InvestRecord) dao.get(InvestRecord.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return investRecord;		
		}	
		  
    	   
		@Override
		public List<InvestRecord> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<InvestRecord> investRecord = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<InvestRecord>();
		}

		try {
			investRecord = (List<InvestRecord>) dao.getList(InvestRecord.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (investRecord == null ? "null" : investRecord.size()));
    
		return investRecord;	
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
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by userId,investStatus,start,limit  : " + userId+" , "+investStatus+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getInvestRecordIdsByUserIdAndInvestStatusOrderByCreateAt", new Object[] { userId,investStatus},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by userId,investStatus,start,limit)  : " + userId+" , "+investStatus+" , "+start+" , "+limit );
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
	public List<Long>  getInvestRecordIdsByProductId(Long productId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by productId,start,limit  : " + productId+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getInvestRecordIdsByProductId", new Object[] { productId},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by productId,start,limit)  : " + productId+" , "+start+" , "+limit );
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
	public List<Long>  getInvestRecordIdsByUserIdOrderByCreateAt(Long userId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
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
		idList = dao.getIdList("getInvestRecordIdsByUserIdOrderByCreateAt", new Object[] { userId},start,limit, false);

   
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
	public Integer  countInvestRecordIdsByUserIdAndInvestStatusOrderByCreateAt(Long userId,Integer investStatus)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by userId,investStatus  : " + userId+" , "+investStatus );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getInvestRecordIdsByUserIdAndInvestStatusOrderByCreateAt", new Object[] { userId,investStatus});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by userId,investStatus)  : " + userId+" , "+investStatus );
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
  if(log.isInfoEnabled()){
    log.info(" count  success : " + count);
  }
		return count;
		
	
	
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
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by productId  : " + productId );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getInvestRecordIdsByProductId", new Object[] { productId});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by productId)  : " + productId );
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
  if(log.isInfoEnabled()){
    log.info(" count  success : " + count);
  }
		return count;
		
	
	
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
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by userId  : " + userId );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getInvestRecordIdsByUserIdOrderByCreateAt", new Object[] { userId});

   
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
	public List<Long> getInvestRecordIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getInvestRecordIdsAll",new Object[] {},start, limit, false);
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
	public Integer countInvestRecordIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getInvestRecordIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getInvestRecordIds " ) ;
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

