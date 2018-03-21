package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import com.ptteng.polyFinance.lgd.model.SysMessageReaded;
import com.ptteng.polyFinance.lgd.service.SysMessageReadedService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class SysMessageReadedServiceImpl extends BaseDaoServiceImpl implements SysMessageReadedService {

 

	private static final Log log = LogFactory.getLog(SysMessageReadedServiceImpl.class);



		   
		@Override
		public Long insert(SysMessageReaded sysMessageReaded)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + sysMessageReaded);

		if (sysMessageReaded == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		sysMessageReaded.setCreateAt(currentTimeMillis);
		sysMessageReaded.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(sysMessageReaded);
		} catch (DaoException e) {
			log.error(" insert wrong : " + sysMessageReaded);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<SysMessageReaded> insertList(List<SysMessageReaded> sysMessageReadedList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (sysMessageReadedList == null ? "null" : sysMessageReadedList.size()));
      
		List<SysMessageReaded> resultList = null;

		if (CollectionUtils.isEmpty(sysMessageReadedList)) {
			return new ArrayList<SysMessageReaded>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (SysMessageReaded sysMessageReaded : sysMessageReadedList) {
			sysMessageReaded.setCreateAt(currentTimeMillis);
			sysMessageReaded.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<SysMessageReaded>) dao.batchSave(sysMessageReadedList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + sysMessageReadedList);
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
			result = dao.delete(SysMessageReaded.class, id);
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
		public boolean update(SysMessageReaded sysMessageReaded)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (sysMessageReaded == null ? "null" : sysMessageReaded.getId()));

		boolean result = false;

		if (sysMessageReaded == null) {
			return true;
		}

		sysMessageReaded.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(sysMessageReaded);
		} catch (DaoException e) {
			log.error(" update wrong : " + sysMessageReaded);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + sysMessageReaded);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<SysMessageReaded> sysMessageReadedList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (sysMessageReadedList == null ? "null" : sysMessageReadedList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(sysMessageReadedList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (SysMessageReaded sysMessageReaded : sysMessageReadedList) {
			sysMessageReaded.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(sysMessageReadedList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + sysMessageReadedList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + sysMessageReadedList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public SysMessageReaded getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		SysMessageReaded sysMessageReaded = null;

		if (id == null) {
			return sysMessageReaded;
		}

		try {
			sysMessageReaded = (SysMessageReaded) dao.get(SysMessageReaded.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return sysMessageReaded;		
		}	
		  
    	   
		@Override
		public List<SysMessageReaded> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<SysMessageReaded> sysMessageReaded = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<SysMessageReaded>();
		}

		try {
			sysMessageReaded = (List<SysMessageReaded>) dao.getList(SysMessageReaded.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (sysMessageReaded == null ? "null" : sysMessageReaded.size()));
    
		return sysMessageReaded;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getSysMessageReadedIdsByUserId(Long userId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
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
		idList = dao.getIdList("getSysMessageReadedIdsByUserId", new Object[] { userId},start,limit, false);

   
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
	public Integer  countSysMessageReadedIdsByUserId(Long userId)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by userId  : " + userId );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getSysMessageReadedIdsByUserId", new Object[] { userId});

   
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
	public List<Long> getSysMessageReadedIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getSysMessageReadedIdsAll",new Object[] {},start, limit, false);
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
	public Integer countSysMessageReadedIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getSysMessageReadedIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getSysMessageReadedIds " ) ;
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

