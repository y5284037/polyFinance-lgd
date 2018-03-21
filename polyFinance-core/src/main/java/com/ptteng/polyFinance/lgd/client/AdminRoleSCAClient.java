/**
 * 
 */
package com.ptteng.polyFinance.lgd.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.AdminRole;
import com.ptteng.polyFinance.lgd.service.AdminRoleService;

import java.util.List;
import java.util.Map;

public class AdminRoleSCAClient implements AdminRoleService {

    private AdminRoleService adminRoleService;

	public AdminRoleService getAdminRoleService() {
		return adminRoleService;
	}
	
	
	public void setAdminRoleService(AdminRoleService adminRoleService) {
		this.adminRoleService =adminRoleService;
	}
	
	
			   
		@Override
		public Long insert(AdminRole adminRole)throws ServiceException, ServiceDaoException{
		
		return adminRoleService.insert(adminRole);
		          
		
		}	
		  
    	   
		@Override
		public List<AdminRole> insertList(List<AdminRole> adminRoleList)throws ServiceException, ServiceDaoException{
		
		return adminRoleService.insertList(adminRoleList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return adminRoleService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(AdminRole adminRole)throws ServiceException, ServiceDaoException{
		
		return adminRoleService.update(adminRole);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<AdminRole> adminRoleList)throws ServiceException, ServiceDaoException{
		
		return adminRoleService.updateList(adminRoleList);
		          
		
		}	
		  
    	   
		@Override
		public AdminRole getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return adminRoleService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<AdminRole> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return adminRoleService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getAdminRoleIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return adminRoleService.getAdminRoleIds(start, limit);
	}

	@Override
	public Integer countAdminRoleIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return adminRoleService.countAdminRoleIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return adminRoleService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return adminRoleService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   adminRoleService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.adminRoleService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

