package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import com.ptteng.polyFinance.lgd.model.DebtorMatch;
import com.ptteng.polyFinance.lgd.service.DebtorMatchService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class DebtorMatchServiceImpl extends BaseDaoServiceImpl implements DebtorMatchService {

 

	private static final Log log = LogFactory.getLog(DebtorMatchServiceImpl.class);



		   
		@Override
		public Long insert(DebtorMatch debtorMatch)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + debtorMatch);

		if (debtorMatch == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		debtorMatch.setCreateAt(currentTimeMillis);
		debtorMatch.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(debtorMatch);
		} catch (DaoException e) {
			log.error(" insert wrong : " + debtorMatch);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<DebtorMatch> insertList(List<DebtorMatch> debtorMatchList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (debtorMatchList == null ? "null" : debtorMatchList.size()));
      
		List<DebtorMatch> resultList = null;

		if (CollectionUtils.isEmpty(debtorMatchList)) {
			return new ArrayList<DebtorMatch>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (DebtorMatch debtorMatch : debtorMatchList) {
			debtorMatch.setCreateAt(currentTimeMillis);
			debtorMatch.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<DebtorMatch>) dao.batchSave(debtorMatchList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + debtorMatchList);
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
			result = dao.delete(DebtorMatch.class, id);
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
		public boolean update(DebtorMatch debtorMatch)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (debtorMatch == null ? "null" : debtorMatch.getId()));

		boolean result = false;

		if (debtorMatch == null) {
			return true;
		}

		debtorMatch.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(debtorMatch);
		} catch (DaoException e) {
			log.error(" update wrong : " + debtorMatch);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + debtorMatch);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<DebtorMatch> debtorMatchList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (debtorMatchList == null ? "null" : debtorMatchList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(debtorMatchList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (DebtorMatch debtorMatch : debtorMatchList) {
			debtorMatch.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(debtorMatchList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + debtorMatchList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + debtorMatchList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public DebtorMatch getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		DebtorMatch debtorMatch = null;

		if (id == null) {
			return debtorMatch;
		}

		try {
			debtorMatch = (DebtorMatch) dao.get(DebtorMatch.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return debtorMatch;		
		}	
		  
    	   
		@Override
		public List<DebtorMatch> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<DebtorMatch> debtorMatch = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<DebtorMatch>();
		}

		try {
			debtorMatch = (List<DebtorMatch>) dao.getList(DebtorMatch.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (debtorMatch == null ? "null" : debtorMatch.size()));
    
		return debtorMatch;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getDebtorMatchIdsByDebtorId(Long debtorId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by debtorId,start,limit  : " + debtorId+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getDebtorMatchIdsByDebtorId", new Object[] { debtorId},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by debtorId,start,limit)  : " + debtorId+" , "+start+" , "+limit );
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
	public Integer  countDebtorMatchIdsByDebtorId(Long debtorId)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by debtorId  : " + debtorId );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getDebtorMatchIdsByDebtorId", new Object[] { debtorId});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by debtorId)  : " + debtorId );
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
	public List<Long> getDebtorMatchIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getDebtorMatchIdsAll",new Object[] {},start, limit, false);
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
	public Integer countDebtorMatchIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getDebtorMatchIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getDebtorMatchIds " ) ;
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

