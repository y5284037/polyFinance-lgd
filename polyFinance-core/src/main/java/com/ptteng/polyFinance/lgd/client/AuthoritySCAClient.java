/**
 * 
 */
package com.ptteng.polyFinance.lgd.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.Authority;
import com.ptteng.polyFinance.lgd.service.AuthorityService;

import java.util.List;
import java.util.Map;

public class AuthoritySCAClient implements AuthorityService {

    private AuthorityService authorityService;

	public AuthorityService getAuthorityService() {
		return authorityService;
	}
	
	
	public void setAuthorityService(AuthorityService authorityService) {
		this.authorityService =authorityService;
	}
	
	
			   
		@Override
		public Long insert(Authority authority)throws ServiceException, ServiceDaoException{
		
		return authorityService.insert(authority);
		          
		
		}	
		  
    	   
		@Override
		public List<Authority> insertList(List<Authority> authorityList)throws ServiceException, ServiceDaoException{
		
		return authorityService.insertList(authorityList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return authorityService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Authority authority)throws ServiceException, ServiceDaoException{
		
		return authorityService.update(authority);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Authority> authorityList)throws ServiceException, ServiceDaoException{
		
		return authorityService.updateList(authorityList);
		          
		
		}	
		  
    	   
		@Override
		public Authority getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return authorityService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Authority> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return authorityService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getAuthorityIdsByAdminRoleId(Long adminRoleId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return authorityService.getAuthorityIdsByAdminRoleId(adminRoleId,start,limit);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countAuthorityIdsByAdminRoleId(Long adminRoleId)throws ServiceException, ServiceDaoException{
		
		return authorityService.countAuthorityIdsByAdminRoleId(adminRoleId);
	
	
	}
	
		
	
		@Override
	public List<Long> getAuthorityIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return authorityService.getAuthorityIds(start, limit);
	}

	@Override
	public Integer countAuthorityIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return authorityService.countAuthorityIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return authorityService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return authorityService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   authorityService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.authorityService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

