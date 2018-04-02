package com.ptteng.polyFinance.lgd.service;

import java.util.List;
import java.util.Map;

import org.osoa.sca.annotations.Remotable;

import com.ptteng.polyFinance.lgd.model.AdminRole;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;
import org.springframework.stereotype.Component;

@Component
@Remotable
public interface AdminRoleService extends BaseDaoService {

	



   		   
		
		public Long insert(AdminRole adminRole)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<AdminRole> insertList(List<AdminRole> adminRoleList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(AdminRole adminRole)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<AdminRole> adminRoleList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public AdminRole getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<AdminRole> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getAdminRoleIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countAdminRoleIds() throws ServiceException, ServiceDaoException;
	

}

