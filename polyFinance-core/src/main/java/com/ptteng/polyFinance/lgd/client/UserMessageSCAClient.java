/**
 * 
 */
package com.ptteng.polyFinance.lgd.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.UserMessage;
import com.ptteng.polyFinance.lgd.service.UserMessageService;

import java.util.List;
import java.util.Map;

public class UserMessageSCAClient implements UserMessageService {

    private UserMessageService userMessageService;

	public UserMessageService getUserMessageService() {
		return userMessageService;
	}
	
	
	public void setUserMessageService(UserMessageService userMessageService) {
		this.userMessageService =userMessageService;
	}
	
	
			   
		@Override
		public Long insert(UserMessage userMessage)throws ServiceException, ServiceDaoException{
		
		return userMessageService.insert(userMessage);
		          
		
		}	
		  
    	   
		@Override
		public List<UserMessage> insertList(List<UserMessage> userMessageList)throws ServiceException, ServiceDaoException{
		
		return userMessageService.insertList(userMessageList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return userMessageService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(UserMessage userMessage)throws ServiceException, ServiceDaoException{
		
		return userMessageService.update(userMessage);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<UserMessage> userMessageList)throws ServiceException, ServiceDaoException{
		
		return userMessageService.updateList(userMessageList);
		          
		
		}	
		  
    	   
		@Override
		public UserMessage getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return userMessageService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<UserMessage> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return userMessageService.getObjectsByIds(ids);
		          
		
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
		
		return userMessageService.getUserMessageIdsByUserIdAndMessageReadStatus(userId,messageReadStatus,start,limit);
	
	
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
		
		return userMessageService.getUserMessageIdsByUserId(userId,start,limit);
	
	
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
		
		return userMessageService.countUserMessageIdsByUserIdAndMessageReadStatus(userId,messageReadStatus);
	
	
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
		
		return userMessageService.countUserMessageIdsByUserId(userId);
	
	
	}
	
		
	
		@Override
	public List<Long> getUserMessageIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return userMessageService.getUserMessageIds(start, limit);
	}

	@Override
	public Integer countUserMessageIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return userMessageService.countUserMessageIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return userMessageService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return userMessageService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   userMessageService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.userMessageService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

