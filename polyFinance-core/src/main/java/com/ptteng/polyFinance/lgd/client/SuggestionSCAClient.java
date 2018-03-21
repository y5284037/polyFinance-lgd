/**
 * 
 */
package com.ptteng.polyFinance.lgd.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.Suggestion;
import com.ptteng.polyFinance.lgd.service.SuggestionService;

import java.util.List;
import java.util.Map;

public class SuggestionSCAClient implements SuggestionService {

    private SuggestionService suggestionService;

	public SuggestionService getSuggestionService() {
		return suggestionService;
	}
	
	
	public void setSuggestionService(SuggestionService suggestionService) {
		this.suggestionService =suggestionService;
	}
	
	
			   
		@Override
		public Long insert(Suggestion suggestion)throws ServiceException, ServiceDaoException{
		
		return suggestionService.insert(suggestion);
		          
		
		}	
		  
    	   
		@Override
		public List<Suggestion> insertList(List<Suggestion> suggestionList)throws ServiceException, ServiceDaoException{
		
		return suggestionService.insertList(suggestionList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return suggestionService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Suggestion suggestion)throws ServiceException, ServiceDaoException{
		
		return suggestionService.update(suggestion);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Suggestion> suggestionList)throws ServiceException, ServiceDaoException{
		
		return suggestionService.updateList(suggestionList);
		          
		
		}	
		  
    	   
		@Override
		public Suggestion getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return suggestionService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Suggestion> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return suggestionService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getSuggestionIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return suggestionService.getSuggestionIds(start, limit);
	}

	@Override
	public Integer countSuggestionIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return suggestionService.countSuggestionIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return suggestionService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return suggestionService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   suggestionService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.suggestionService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

