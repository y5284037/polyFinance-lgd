package com.ptteng.polyFinance.lgd.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.polyFinance.lgd.model.Suggestion;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;
import org.springframework.stereotype.Service;

@Remotable
@Service
public interface SuggestionService extends BaseDaoService {

	



   		   
		
		public Long insert(Suggestion suggestion)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Suggestion> insertList(List<Suggestion> suggestionList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Suggestion suggestion)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Suggestion> suggestionList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Suggestion getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Suggestion> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getSuggestionIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countSuggestionIds() throws ServiceException, ServiceDaoException;
	

}

