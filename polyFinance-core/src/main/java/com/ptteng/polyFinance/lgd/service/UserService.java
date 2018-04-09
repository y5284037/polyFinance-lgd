package com.ptteng.polyFinance.lgd.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;
import com.ptteng.polyFinance.lgd.model.User;
import org.osoa.sca.annotations.Remotable;
import org.springframework.stereotype.Service;

import java.util.List;


@Remotable
@Service
public interface UserService extends BaseDaoService {

	



   		   
		
		public Long insert(User user)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<User> insertList(List<User> userList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(User user)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<User> userList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public User getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<User> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
		
    	public User getObjectByPhoneNum(String phoneNum) throws ServiceException ,ServiceDaoException;
    	
    	
    	public void updateUserSerialNumById(Long id) throws ServiceException ,ServiceDaoException;
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getUserIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countUserIds() throws ServiceException, ServiceDaoException;
	
	
	

}

