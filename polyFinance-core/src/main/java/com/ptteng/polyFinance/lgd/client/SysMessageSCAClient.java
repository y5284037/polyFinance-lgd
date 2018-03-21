/**
 * 
 */
package com.ptteng.polyFinance.lgd.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.SysMessage;
import com.ptteng.polyFinance.lgd.service.SysMessageService;

import java.util.List;
import java.util.Map;

public class SysMessageSCAClient implements SysMessageService {

    private SysMessageService sysMessageService;

	public SysMessageService getSysMessageService() {
		return sysMessageService;
	}
	
	
	public void setSysMessageService(SysMessageService sysMessageService) {
		this.sysMessageService =sysMessageService;
	}
	
	
			   
		@Override
		public Long insert(SysMessage sysMessage)throws ServiceException, ServiceDaoException{
		
		return sysMessageService.insert(sysMessage);
		          
		
		}	
		  
    	   
		@Override
		public List<SysMessage> insertList(List<SysMessage> sysMessageList)throws ServiceException, ServiceDaoException{
		
		return sysMessageService.insertList(sysMessageList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return sysMessageService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(SysMessage sysMessage)throws ServiceException, ServiceDaoException{
		
		return sysMessageService.update(sysMessage);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<SysMessage> sysMessageList)throws ServiceException, ServiceDaoException{
		
		return sysMessageService.updateList(sysMessageList);
		          
		
		}	
		  
    	   
		@Override
		public SysMessage getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return sysMessageService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<SysMessage> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return sysMessageService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getSysMessageIdsByStatus(Integer status,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return sysMessageService.getSysMessageIdsByStatus(status,start,limit);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countSysMessageIdsByStatus(Integer status)throws ServiceException, ServiceDaoException{
		
		return sysMessageService.countSysMessageIdsByStatus(status);
	
	
	}
	
		
	
		@Override
	public List<Long> getSysMessageIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return sysMessageService.getSysMessageIds(start, limit);
	}

	@Override
	public Integer countSysMessageIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return sysMessageService.countSysMessageIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return sysMessageService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return sysMessageService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   sysMessageService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.sysMessageService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

