/**
 * 
 */
package com.ptteng.polyFinance.lgd.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.UserBank;
import com.ptteng.polyFinance.lgd.service.UserBankService;

import java.util.List;
import java.util.Map;

public class UserBankSCAClient implements UserBankService {

    private UserBankService userBankService;

	public UserBankService getUserBankService() {
		return userBankService;
	}
	
	
	public void setUserBankService(UserBankService userBankService) {
		this.userBankService =userBankService;
	}
	
	
			   
		@Override
		public Long insert(UserBank userBank)throws ServiceException, ServiceDaoException{
		
		return userBankService.insert(userBank);
		          
		
		}	
		  
    	   
		@Override
		public List<UserBank> insertList(List<UserBank> userBankList)throws ServiceException, ServiceDaoException{
		
		return userBankService.insertList(userBankList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return userBankService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(UserBank userBank)throws ServiceException, ServiceDaoException{
		
		return userBankService.update(userBank);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<UserBank> userBankList)throws ServiceException, ServiceDaoException{
		
		return userBankService.updateList(userBankList);
		          
		
		}	
		  
    	   
		@Override
		public UserBank getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return userBankService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<UserBank> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return userBankService.getObjectsByIds(ids);
		          
		
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
		
		return userBankService.getUserBankIdByUserIdAndFirst(userId,first);
	
	
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
		
		return userBankService.getUserBankIdsByUserId(userId,start,limit);
	
	
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
		
		return userBankService.countUserBankIdsByUserId(userId);
	
	
	}
	
		
	
		@Override
	public List<Long> getUserBankIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return userBankService.getUserBankIds(start, limit);
	}

	@Override
	public Integer countUserBankIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return userBankService.countUserBankIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return userBankService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return userBankService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   userBankService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.userBankService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

