/**
 * 
 */
package com.ptteng.polyFinance.lgd.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.DebtorMatch;
import com.ptteng.polyFinance.lgd.service.DebtorMatchService;

import java.util.List;
import java.util.Map;

public class DebtorMatchSCAClient implements DebtorMatchService {

    private DebtorMatchService debtorMatchService;

	public DebtorMatchService getDebtorMatchService() {
		return debtorMatchService;
	}
	
	
	public void setDebtorMatchService(DebtorMatchService debtorMatchService) {
		this.debtorMatchService =debtorMatchService;
	}
	
	
			   
		@Override
		public Long insert(DebtorMatch debtorMatch)throws ServiceException, ServiceDaoException{
		
		return debtorMatchService.insert(debtorMatch);
		          
		
		}	
		  
    	   
		@Override
		public List<DebtorMatch> insertList(List<DebtorMatch> debtorMatchList)throws ServiceException, ServiceDaoException{
		
		return debtorMatchService.insertList(debtorMatchList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return debtorMatchService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(DebtorMatch debtorMatch)throws ServiceException, ServiceDaoException{
		
		return debtorMatchService.update(debtorMatch);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<DebtorMatch> debtorMatchList)throws ServiceException, ServiceDaoException{
		
		return debtorMatchService.updateList(debtorMatchList);
		          
		
		}	
		  
    	   
		@Override
		public DebtorMatch getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return debtorMatchService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<DebtorMatch> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return debtorMatchService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public List<Long>  getDebtorMatchIdsByDebtorId(Long debtorId,Integer start,Integer limit)throws ServiceException, ServiceDaoException{
		
		return debtorMatchService.getDebtorMatchIdsByDebtorId(debtorId,start,limit);
	
	
	}
	
		
	
	
    			
			
		/**
	 * 
	 * @param 
	 * @return 
	 * @throws ServiceException
	 * @throws ServiceDaoException
	 */
	 @Override
	public Integer  countDebtorMatchIdsByDebtorId(Long debtorId)throws ServiceException, ServiceDaoException{
		
		return debtorMatchService.countDebtorMatchIdsByDebtorId(debtorId);
	
	
	}
	
		
	
		@Override
	public List<Long> getDebtorMatchIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return debtorMatchService.getDebtorMatchIds(start, limit);
	}

	@Override
	public Integer countDebtorMatchIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return debtorMatchService.countDebtorMatchIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return debtorMatchService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return debtorMatchService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   debtorMatchService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.debtorMatchService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

