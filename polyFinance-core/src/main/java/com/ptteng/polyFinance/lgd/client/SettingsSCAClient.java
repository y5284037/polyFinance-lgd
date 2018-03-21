/**
 * 
 */
package com.ptteng.polyFinance.lgd.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.Settings;
import com.ptteng.polyFinance.lgd.service.SettingsService;

import java.util.List;
import java.util.Map;

public class SettingsSCAClient implements SettingsService {

    private SettingsService settingsService;

	public SettingsService getSettingsService() {
		return settingsService;
	}
	
	
	public void setSettingsService(SettingsService settingsService) {
		this.settingsService =settingsService;
	}
	
	
			   
		@Override
		public Long insert(Settings settings)throws ServiceException, ServiceDaoException{
		
		return settingsService.insert(settings);
		          
		
		}	
		  
    	   
		@Override
		public List<Settings> insertList(List<Settings> settingsList)throws ServiceException, ServiceDaoException{
		
		return settingsService.insertList(settingsList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return settingsService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Settings settings)throws ServiceException, ServiceDaoException{
		
		return settingsService.update(settings);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Settings> settingsList)throws ServiceException, ServiceDaoException{
		
		return settingsService.updateList(settingsList);
		          
		
		}	
		  
    	   
		@Override
		public Settings getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return settingsService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Settings> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return settingsService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getSettingsIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return settingsService.getSettingsIds(start, limit);
	}

	@Override
	public Integer countSettingsIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return settingsService.countSettingsIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return settingsService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return settingsService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   settingsService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.settingsService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

