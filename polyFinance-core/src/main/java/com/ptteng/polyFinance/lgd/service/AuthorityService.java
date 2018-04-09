package com.ptteng.polyFinance.lgd.service;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.common.dao.BaseDaoService;
import com.ptteng.polyFinance.lgd.model.Authority;
import org.osoa.sca.annotations.Remotable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Remotable
@Service
public interface AuthorityService extends BaseDaoService {

	



   		   
		
		public Long insert(Authority authority)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Authority> insertList(List<Authority> authorityList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean delete(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean update(Authority authority)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public boolean updateList(List<Authority> authorityList)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public Authority getObjectById(Long id)throws ServiceException, ServiceDaoException;
		  
    	   
		
		public List<Authority> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException;
		  
    	
	


			
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer  countAuthorityIdsByAdminRoleId(Long adminRoleId)throws ServiceException, ServiceDaoException;
					
			
	/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long>  getAuthorityIdsByAdminRoleId(Long adminRoleId,Integer start,Integer limit)throws ServiceException, ServiceDaoException;
		
	
	
	
	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public List<Long> getAuthorityIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException;

	/**
	 * 
	 * @param
	 * @return
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	public Integer countAuthorityIds() throws ServiceException, ServiceDaoException;
	

}

