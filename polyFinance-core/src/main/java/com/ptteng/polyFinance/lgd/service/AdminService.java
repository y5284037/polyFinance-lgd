package com.ptteng.polyFinance.lgd.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;
import com.ptteng.polyFinance.lgd.model.Admin;
import org.osoa.sca.annotations.Remotable;
import org.springframework.stereotype.Service;

import java.util.List;

@Remotable
@Service
public interface AdminService extends BaseDaoService {
		
		public Long insert(Admin admin)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Admin> insertList(List<Admin> adminList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Admin admin)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Admin> adminList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Admin getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Admin> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
	
	public Admin getObjectByLoginName(String loginName) throws ServiceException ,ServiceDaoException;
	


				
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getAdminIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countAdminIds() throws ServiceException, ServiceDaoException;
	

}

