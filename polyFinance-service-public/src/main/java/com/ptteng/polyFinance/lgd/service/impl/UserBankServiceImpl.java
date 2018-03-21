package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import com.ptteng.polyFinance.lgd.model.UserBank;
import com.ptteng.polyFinance.lgd.service.UserBankService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class UserBankServiceImpl extends BaseDaoServiceImpl implements UserBankService {

 

	private static final Log log = LogFactory.getLog(UserBankServiceImpl.class);



		   
		@Override
		public Long insert(UserBank userBank)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + userBank);

		if (userBank == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		userBank.setCreateAt(currentTimeMillis);
		userBank.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(userBank);
		} catch (DaoException e) {
			log.error(" insert wrong : " + userBank);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<UserBank> insertList(List<UserBank> userBankList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (userBankList == null ? "null" : userBankList.size()));
      
		List<UserBank> resultList = null;

		if (CollectionUtils.isEmpty(userBankList)) {
			return new ArrayList<UserBank>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (UserBank userBank : userBankList) {
			userBank.setCreateAt(currentTimeMillis);
			userBank.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<UserBank>) dao.batchSave(userBankList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + userBankList);
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
			result = dao.delete(UserBank.class, id);
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
		public boolean update(UserBank userBank)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (userBank == null ? "null" : userBank.getId()));

		boolean result = false;

		if (userBank == null) {
			return true;
		}

		userBank.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(userBank);
		} catch (DaoException e) {
			log.error(" update wrong : " + userBank);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + userBank);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<UserBank> userBankList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (userBankList == null ? "null" : userBankList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(userBankList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (UserBank userBank : userBankList) {
			userBank.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(userBankList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + userBankList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + userBankList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public UserBank getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		UserBank userBank = null;

		if (id == null) {
			return userBank;
		}

		try {
			userBank = (UserBank) dao.get(UserBank.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return userBank;		
		}	
		  
    	   
		@Override
		public List<UserBank> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<UserBank> userBank = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<UserBank>();
		}

		try {
			userBank = (List<UserBank>) dao.getList(UserBank.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (userBank == null ? "null" : userBank.size()));
    
		return userBank;	
		}	
		  
    	
		
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Long  getUserBankIdByUserIdAndFirst(Long userId,Integer first)throws ServiceException, ServiceDaoException{
		
		      if(log.isInfoEnabled()){
	  log.info(" get id by userId,first  : " + userId+" , "+first );
	  }
	  Long id = null;
	
      // TODO 参数检查!
      
	try {
		
	
	
        id = (Long) dao.getMapping("getUserBankIdByUserIdAndFirst", new Object[] {userId,first });
   } catch (DaoException e) {
				log.error(" get id wrong by userId,first  : " + userId+" , "+first );
				log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
  if(log.isInfoEnabled()){
   log.info(" get id success : " + id);
   }
		return id;
        
	
	
	
	
	}
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getUserBankIdsByUserId(Long userId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
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
		idList = dao.getIdList("getUserBankIdsByUserId", new Object[] { userId},start,limit, false);

   
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
	public Integer  countUserBankIdsByUserId(Long userId)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by userId  : " + userId );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getUserBankIdsByUserId", new Object[] { userId});

   
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
	public List<Long> getUserBankIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getUserBankIdsAll",new Object[] {},start, limit, false);
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
	public Integer countUserBankIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getUserBankIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getUserBankIds " ) ;
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

