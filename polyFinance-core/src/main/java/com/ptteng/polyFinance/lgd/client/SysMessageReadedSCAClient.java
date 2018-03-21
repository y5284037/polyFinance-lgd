/**
 * 
 */
package com.ptteng.polyFinance.lgd.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.SysMessageReaded;
import com.ptteng.polyFinance.lgd.service.SysMessageReadedService;

import java.util.List;
import java.util.Map;

public class SysMessageReadedSCAClient implements SysMessageReadedService {

    private SysMessageReadedService sysMessageReadedService;

	public SysMessageReadedService getSysMessageReadedService() {
		return sysMessageReadedService;
	}
	
	
	public void setSysMessageReadedService(SysMessageReadedService sysMessageReadedService) {
		this.sysMessageReadedService =sysMessageReadedService;
	}
	
	
			   
		@Override
		public Long insert(SysMessageReaded sysMessageReaded)throws ServiceException, ServiceDaoException{
		
		return sysMessageReadedService.insert(sysMessageReaded);
		          
		
		}	
		  
    	   
		@Override
		public List<SysMessageReaded> insertList(List<SysMessageReaded> sysMessageReadedList)throws ServiceException, ServiceDaoException{
		
		return sysMessageReadedService.insertList(sysMessageReadedList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return sysMessageReadedService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(SysMessageReaded sysMessageReaded)throws ServiceException, ServiceDaoException{
		
		return sysMessageReadedService.update(sysMessageReaded);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<SysMessageReaded> sysMessageReadedList)throws ServiceException, ServiceDaoException{
		
		return sysMessageReadedService.updateList(sysMessageReadedList);
		          
		
		}	
		  
    	   
		@Override
		public SysMessageReaded getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return sysMessageReadedService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<SysMessageReaded> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return sysMessageReadedService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getSysMessageReadedIdsByUserId(Long userId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return sysMessageReadedService.getSysMessageReadedIdsByUserId(userId,start,limit);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countSysMessageReadedIdsByUserId(Long userId)throws ServiceException, ServiceDaoException{
		
		return sysMessageReadedService.countSysMessageReadedIdsByUserId(userId);
	
	
	}
	
		
	
		@Override
	public List<Long> getSysMessageReadedIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return sysMessageReadedService.getSysMessageReadedIds(start, limit);
	}

	@Override
	public Integer countSysMessageReadedIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return sysMessageReadedService.countSysMessageReadedIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return sysMessageReadedService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return sysMessageReadedService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   sysMessageReadedService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.sysMessageReadedService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

