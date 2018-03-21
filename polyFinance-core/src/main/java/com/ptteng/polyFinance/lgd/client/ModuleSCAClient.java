/**
 * 
 */
package com.ptteng.polyFinance.lgd.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.Module;
import com.ptteng.polyFinance.lgd.service.ModuleService;

import java.util.List;
import java.util.Map;

public class ModuleSCAClient implements ModuleService {

    private ModuleService moduleService;

	public ModuleService getModuleService() {
		return moduleService;
	}
	
	
	public void setModuleService(ModuleService moduleService) {
		this.moduleService =moduleService;
	}
	
	
			   
		@Override
		public Long insert(Module module)throws ServiceException, ServiceDaoException{
		
		return moduleService.insert(module);
		          
		
		}	
		  
    	   
		@Override
		public List<Module> insertList(List<Module> moduleList)throws ServiceException, ServiceDaoException{
		
		return moduleService.insertList(moduleList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return moduleService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Module module)throws ServiceException, ServiceDaoException{
		
		return moduleService.update(module);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Module> moduleList)throws ServiceException, ServiceDaoException{
		
		return moduleService.updateList(moduleList);
		          
		
		}	
		  
    	   
		@Override
		public Module getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return moduleService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Module> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return moduleService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getModuleIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return moduleService.getModuleIds(start, limit);
	}

	@Override
	public Integer countModuleIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return moduleService.countModuleIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return moduleService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return moduleService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   moduleService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.moduleService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

