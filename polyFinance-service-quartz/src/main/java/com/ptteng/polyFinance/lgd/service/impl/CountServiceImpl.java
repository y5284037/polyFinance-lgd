package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import com.ptteng.polyFinance.lgd.model.Count;
import com.ptteng.polyFinance.lgd.service.CountService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class CountServiceImpl extends BaseDaoServiceImpl implements CountService {

 

	private static final Log log = LogFactory.getLog(CountServiceImpl.class);



		   
		@Override
		public Long insert(Count count)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + count);

		if (count == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		count.setCreateAt(currentTimeMillis);
		count.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(count);
		} catch (DaoException e) {
			log.error(" insert wrong : " + count);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Count> insertList(List<Count> countList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (countList == null ? "null" : countList.size()));
      
		List<Count> resultList = null;

		if (CollectionUtils.isEmpty(countList)) {
			return new ArrayList<Count>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Count count : countList) {
			count.setCreateAt(currentTimeMillis);
			count.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Count>) dao.batchSave(countList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + countList);
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
			result = dao.delete(Count.class, id);
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
		public boolean update(Count count)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (count == null ? "null" : count.getId()));

		boolean result = false;

		if (count == null) {
			return true;
		}

		count.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(count);
		} catch (DaoException e) {
			log.error(" update wrong : " + count);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + count);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Count> countList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (countList == null ? "null" : countList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(countList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Count count : countList) {
			count.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(countList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + countList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + countList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Count getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Count count = null;

		if (id == null) {
			return count;
		}

		try {
			count = (Count) dao.get(Count.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return count;		
		}	
		  
    	   
		@Override
		public List<Count> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Count> count = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Count>();
		}

		try {
			count = (List<Count>) dao.getList(Count.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (count == null ? "null" : count.size()));
    
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
	public List<Long>  getCountIdsByProductIdOrderByCreateAt(Long productId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
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
		idList = dao.getIdList("getCountIdsByProductIdOrderByCreateAt", new Object[] { productId},start,limit, false);

   
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
	public Integer  countCountIdsByProductIdOrderByCreateAt(Long productId)throws ServiceException, ServiceDaoException{
		
		       if(log.isInfoEnabled()){
      log.info(" count ids by productId  : " + productId );
	  }
	 	Integer count=null;
        
       

	try {
	   
		count = dao.count("getCountIdsByProductIdOrderByCreateAt", new Object[] { productId});

   
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
	
		
	
	
	
		
	@Override
	public List<Long> getCountIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getCountIdsAll",new Object[] {},start, limit, false);
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
	public Integer countCountIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getCountIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getCountIds " ) ;
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

