package com.ptteng.polyFinance.lgd.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.gemantic.dal.dao.exception.DaoException;
import com.ptteng.common.dao.BaseDaoServiceImpl;
import com.ptteng.polyFinance.lgd.model.Content;
import com.ptteng.polyFinance.lgd.service.ContentService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class ContentServiceImpl extends BaseDaoServiceImpl implements ContentService {

 

	private static final Log log = LogFactory.getLog(ContentServiceImpl.class);



		   
		@Override
		public Long insert(Content content)throws ServiceException, ServiceDaoException{
		
	
		          
    log.info(" insert data : " + content);

		if (content == null) {
			return null;
		}

		long currentTimeMillis = System.currentTimeMillis();
		content.setCreateAt(currentTimeMillis);
		content.setUpdateAt(currentTimeMillis);

		Long result = null;
		try {
			result = (Long) dao.save(content);
		} catch (DaoException e) {
			log.error(" insert wrong : " + content);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" insert data success : " + result);
    
return result;	
		}	
		  
    	   
		@Override
		public List<Content> insertList(List<Content> contentList)throws ServiceException, ServiceDaoException{
		
	
		          	
        log.info(" insert lists : " + (contentList == null ? "null" : contentList.size()));
      
		List<Content> resultList = null;

		if (CollectionUtils.isEmpty(contentList)) {
			return new ArrayList<Content>();
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Content content : contentList) {
			content.setCreateAt(currentTimeMillis);
			content.setUpdateAt(currentTimeMillis);
		}

		try {
			resultList = (List<Content>) dao.batchSave(contentList);
		} catch (DaoException e) {
			log.error(" insert list wrong : " + contentList);
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
			result = dao.delete(Content.class, id);
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
		public boolean update(Content content)throws ServiceException, ServiceDaoException{
		
	
		          
	log.info(" update data : " + (content == null ? "null" : content.getId()));

		boolean result = false;

		if (content == null) {
			return true;
		}

		content.setUpdateAt(System.currentTimeMillis());

		try {
			result = dao.update(content);
		} catch (DaoException e) {
			log.error(" update wrong : " + content);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
       if(log.isInfoEnabled()){
		log.info(" update data success : " + content);
       }
		return result;	
		}	
		  
    	   
		@Override
		public boolean updateList(List<Content> contentList)throws ServiceException, ServiceDaoException{
		
	
		          log.info(" update lists : " + (contentList == null ? "null" : contentList.size()));

		boolean result = false;

		if (CollectionUtils.isEmpty(contentList)) {
			return true;
		}

		long currentTimeMillis = System.currentTimeMillis();
		for (Content content : contentList) {
			content.setUpdateAt(currentTimeMillis);
		}

		try {
			result = dao.batchUpdate(contentList);
		} catch (DaoException e) {
			log.error(" update list wrong : " + contentList);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" update lists success : " + contentList.size());
         
		return result;	
		}	
		  
    	   
		@Override
		public Content getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
	
		              
        log.info(" get data : " + id);
      
		Content content = null;

		if (id == null) {
			return content;
		}

		try {
			content = (Content) dao.get(Content.class, id);
		} catch (DaoException e) {
			log.error(" get wrong : " + id);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
     
		log.info(" get data success : " + id);
      
		return content;		
		}	
		  
    	   
		@Override
		public List<Content> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
	
		          	  
	    log.info(" get lists : " + (ids == null ? "null" : ids));
     
		List<Content> content = null;

		if (CollectionUtils.isEmpty(ids)) {
			return new ArrayList<Content>();
		}

		try {
			content = (List<Content>) dao.getList(Content.class, ids);
		} catch (DaoException e) {
			log.error(" get wrong : " + ids);
			log.error(e);
			e.printStackTrace();
			throw new ServiceDaoException(e);
		}
    
		log.info(" get data success : " + (content == null ? "null" : content.size()));
    
		return content;	
		}
	
	@Override
	public List<Long> getContentIdsByTypeAndStatus(Integer type, Integer status) throws ServiceException, ServiceDaoException {
		
		log.info(" get ids   by type,status  ================== " + type + " , " + status);
		List<Long> idList = null;
		
		
		
		
		try {
			idList = dao.getIdList("getContentIdsByTypeAndStatus",new Object[] {type,status},0, Integer.MAX_VALUE, false);
		} catch (DaoException e) {
			log.error(" get ids  wrong by type,status)  : " + type + " , " + status);
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
	public List<Long> getContentIds(Integer start, Integer limit)
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
			idList = dao.getIdList("getContentIdsAll",new Object[] {},start, limit, false);
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
	public Integer countContentIds() throws ServiceException,
			ServiceDaoException {
		Integer count =  0;
		try {
			count = dao.count("getContentIdsAll",new Object[] {});
		} catch (DaoException e) {
			log.error(" count by getContentIds " ) ;
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

