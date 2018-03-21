package com.ptteng.polyFinance.lgd.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.polyFinance.lgd.model.Content;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;

@Remotable
public interface ContentService extends BaseDaoService {

	



   		   
		
		public Long insert(Content content)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Content> insertList(List<Content> contentList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Content content)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Content> contentList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Content getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Content> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getContentIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countContentIds() throws ServiceException, ServiceDaoException;
	

}

