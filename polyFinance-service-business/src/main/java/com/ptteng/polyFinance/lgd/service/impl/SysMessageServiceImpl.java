package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import com.ptteng.polyFinance.lgd.model.SysMessage;
import com.ptteng.polyFinance.lgd.service.SysMessageService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class SysMessageServiceImpl extends BaseDaoServiceImpl implements SysMessageService {

 

	private static final Log log = LogFactory.getLog(SysMessageServiceImpl.class);



		   
		@Override
		public Long insert(SysMessage sysMessage)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + sysMessage);

		if (sysMessage == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		sysMessage.setCreateAt(currentTimeMillis);
		sysMessage.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(sysMessage);
		} catch (DaoException e) {
			log.error(" insert wrong : " + sysMessage);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<SysMessage> insertList(List<SysMessage> sysMessageList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (sysMessageList == null ? "null" : sysMessageList.size()));
      
		List<SysMessage> resultList = null;

		if (CollectionUtils.isEmpty(sysMessageList)) {
			return new ArrayList<SysMessage>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (SysMessage sysMessage : sysMessageList) {
			sysMessage.setCreateAt(currentTimeMillis);
			sysMessage.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<SysMessage>) dao.batchSave(sysMessageList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + sysMessageList);
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
			result = dao.delete(SysMessage.class, id);
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
		public boolean update(SysMessage sysMessage)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (sysMessage == null ? "null" : sysMessage.getId()));

		boolean result = false;

		if (sysMessage == null) {
			return true;
		}

		sysMessage.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(sysMessage);
		} catch (DaoException e) {
			log.error(" update wrong : " + sysMessage);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + sysMessage);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<SysMessage> sysMessageList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (sysMessageList == null ? "null" : sysMessageList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(sysMessageList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (SysMessage sysMessage : sysMessageList) {
			sysMessage.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(sysMessageList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + sysMessageList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + sysMessageList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public SysMessage getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		SysMessage sysMessage = null;

		if (id == null) {
			return sysMessage;
		}

		try {
			sysMessage = (SysMessage) dao.get(SysMessage.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return sysMessage;		
		}	
		  
    	   
		@Override
		public List<SysMessage> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<SysMessage> sysMessage = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<SysMessage>();
		}

		try {
			sysMessage = (List<SysMessage>) dao.getList(SysMessage.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (sysMessage == null ? "null" : sysMessage.size()));
    
		return sysMessage;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getSysMessageIdsByStatus(Integer status,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by status,start,limit  : " + status+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getSysMessageIdsByStatus", new Object[] { status},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by status,start,limit)  : " + status+" , "+start+" , "+limit );
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
	public Integer  countSysMessageIdsByStatus(Integer status)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by status  : " + status );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getSysMessageIdsByStatus", new Object[] { status});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by status)  : " + status );
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
	public List<Long> getSysMessageIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getSysMessageIdsAll",new Object[] {},start, limit, false);
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
	public Integer countSysMessageIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getSysMessageIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getSysMessageIds " ) ;
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

