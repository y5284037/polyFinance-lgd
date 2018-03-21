package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import com.ptteng.polyFinance.lgd.model.Suggestion;
import com.ptteng.polyFinance.lgd.service.SuggestionService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class SuggestionServiceImpl extends BaseDaoServiceImpl implements SuggestionService {

 

	private static final Log log = LogFactory.getLog(SuggestionServiceImpl.class);



		   
		@Override
		public Long insert(Suggestion suggestion)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + suggestion);

		if (suggestion == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		suggestion.setCreateAt(currentTimeMillis);
		suggestion.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(suggestion);
		} catch (DaoException e) {
			log.error(" insert wrong : " + suggestion);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Suggestion> insertList(List<Suggestion> suggestionList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (suggestionList == null ? "null" : suggestionList.size()));
      
		List<Suggestion> resultList = null;

		if (CollectionUtils.isEmpty(suggestionList)) {
			return new ArrayList<Suggestion>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Suggestion suggestion : suggestionList) {
			suggestion.setCreateAt(currentTimeMillis);
			suggestion.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Suggestion>) dao.batchSave(suggestionList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + suggestionList);
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
			result = dao.delete(Suggestion.class, id);
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
		public boolean update(Suggestion suggestion)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (suggestion == null ? "null" : suggestion.getId()));

		boolean result = false;

		if (suggestion == null) {
			return true;
		}

		suggestion.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(suggestion);
		} catch (DaoException e) {
			log.error(" update wrong : " + suggestion);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + suggestion);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Suggestion> suggestionList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (suggestionList == null ? "null" : suggestionList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(suggestionList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Suggestion suggestion : suggestionList) {
			suggestion.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(suggestionList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + suggestionList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + suggestionList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Suggestion getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Suggestion suggestion = null;

		if (id == null) {
			return suggestion;
		}

		try {
			suggestion = (Suggestion) dao.get(Suggestion.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return suggestion;		
		}	
		  
    	   
		@Override
		public List<Suggestion> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Suggestion> suggestion = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Suggestion>();
		}

		try {
			suggestion = (List<Suggestion>) dao.getList(Suggestion.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (suggestion == null ? "null" : suggestion.size()));
    
		return suggestion;	
		}	
		  
    	
		
	
	
		
	
		
	
	
	
		
	@Override
	public List<Long> getSuggestionIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getSuggestionIdsAll",new Object[] {},start, limit, false);
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
	public Integer countSuggestionIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getSuggestionIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getSuggestionIds " ) ;
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

