package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import com.ptteng.polyFinance.lgd.model.UserMessage;
import com.ptteng.polyFinance.lgd.service.UserMessageService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class UserMessageServiceImpl extends BaseDaoServiceImpl implements UserMessageService {

 

	private static final Log log = LogFactory.getLog(UserMessageServiceImpl.class);



		   
		@Override
		public Long insert(UserMessage userMessage)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + userMessage);

		if (userMessage == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		userMessage.setCreateAt(currentTimeMillis);
		userMessage.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(userMessage);
		} catch (DaoException e) {
			log.error(" insert wrong : " + userMessage);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<UserMessage> insertList(List<UserMessage> userMessageList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (userMessageList == null ? "null" : userMessageList.size()));
      
		List<UserMessage> resultList = null;

		if (CollectionUtils.isEmpty(userMessageList)) {
			return new ArrayList<UserMessage>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (UserMessage userMessage : userMessageList) {
			userMessage.setCreateAt(currentTimeMillis);
			userMessage.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<UserMessage>) dao.batchSave(userMessageList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + userMessageList);
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
			result = dao.delete(UserMessage.class, id);
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
		public boolean update(UserMessage userMessage)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (userMessage == null ? "null" : userMessage.getId()));

		boolean result = false;

		if (userMessage == null) {
			return true;
		}

		userMessage.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(userMessage);
		} catch (DaoException e) {
			log.error(" update wrong : " + userMessage);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + userMessage);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<UserMessage> userMessageList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (userMessageList == null ? "null" : userMessageList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(userMessageList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (UserMessage userMessage : userMessageList) {
			userMessage.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(userMessageList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + userMessageList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + userMessageList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public UserMessage getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		UserMessage userMessage = null;

		if (id == null) {
			return userMessage;
		}

		try {
			userMessage = (UserMessage) dao.get(UserMessage.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return userMessage;		
		}	
		  
    	   
		@Override
		public List<UserMessage> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<UserMessage> userMessage = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<UserMessage>();
		}

		try {
			userMessage = (List<UserMessage>) dao.getList(UserMessage.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (userMessage == null ? "null" : userMessage.size()));
    
		return userMessage;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getUserMessageIdsByUserIdAndMessageReadStatus(Long userId,Integer messageReadStatus,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" get ids by userId,messageReadStatus,start,limit  : " + userId+" , "+messageReadStatus+" , "+start+" , "+limit );
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
		idList = dao.getIdList("getUserMessageIdsByUserIdAndMessageReadStatus", new Object[] { userId,messageReadStatus},start,limit, false);

   
   } catch (DaoException e) {
			log.error(" get ids  wrong by userId,messageReadStatus,start,limit)  : " + userId+" , "+messageReadStatus+" , "+start+" , "+limit );
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
	public List<Long>  getUserMessageIdsByUserId(Long userId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
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
		idList = dao.getIdList("getUserMessageIdsByUserId", new Object[] { userId},start,limit, false);

   
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
	public Integer  countUserMessageIdsByUserIdAndMessageReadStatus(Long userId,Integer messageReadStatus)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by userId,messageReadStatus  : " + userId+" , "+messageReadStatus );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getUserMessageIdsByUserIdAndMessageReadStatus", new Object[] { userId,messageReadStatus});

   
   } catch (DaoException e) {
			log.error(" count ids  wrong by userId,messageReadStatus)  : " + userId+" , "+messageReadStatus );
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
	public Integer  countUserMessageIdsByUserId(Long userId)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by userId  : " + userId );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getUserMessageIdsByUserId", new Object[] { userId});

   
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
	public List<Long> getUserMessageIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getUserMessageIdsAll",new Object[] {},start, limit, false);
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
	public Integer countUserMessageIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getUserMessageIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getUserMessageIds " ) ;
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

