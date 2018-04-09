/**
 * 
 */
package com.ptteng.polyFinance.lgd.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.Content;
import com.ptteng.polyFinance.lgd.service.ContentService;

import java.util.List;
import java.util.Map;

public class ContentSCAClient implements ContentService {

    private ContentService contentService;

	public ContentService getContentService() {
		return contentService;
	}
	
	
	public void setContentService(ContentService contentService) {
		this.contentService =contentService;
	}
	
	
			   
		@Override
		public Long insert(Content content)throws ServiceException, ServiceDaoException{
		
		return contentService.insert(content);
		          
		
		}	
		  
    	   
		@Override
		public List<Content> insertList(List<Content> contentList)throws ServiceException, ServiceDaoException{
		
		return contentService.insertList(contentList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return contentService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Content content)throws ServiceException, ServiceDaoException{
		
		return contentService.update(content);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Content> contentList)throws ServiceException, ServiceDaoException{
		
		return contentService.updateList(contentList);
		          
		
		}	
		  
    	   
		@Override
		public Content getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return contentService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Content> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return contentService.getObjectsByIds(ids);
		          
		
		}
	
	@Override
	public List<Long> getContentIdsByTypeAndStatus(Integer type, Integer status) throws ServiceException, ServiceDaoException {
		return contentService.getContentIdsByTypeAndStatus(type,status);
	}
	
	
	@Override
	public List<Long> getContentIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return contentService.getContentIds(start, limit);
	}

	@Override
	public Integer countContentIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return contentService.countContentIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return contentService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return contentService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   contentService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.contentService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

