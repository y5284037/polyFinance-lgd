/**
 * 
 */
package com.ptteng.polyFinance.lgd.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.Debtor;
import com.ptteng.polyFinance.lgd.service.DebtorService;

import java.util.List;
import java.util.Map;

public class DebtorSCAClient implements DebtorService {

    private DebtorService debtorService;

	public DebtorService getDebtorService() {
		return debtorService;
	}
	
	
	public void setDebtorService(DebtorService debtorService) {
		this.debtorService =debtorService;
	}
	
	
			   
		@Override
		public Long insert(Debtor debtor)throws ServiceException, ServiceDaoException{
		
		return debtorService.insert(debtor);
		          
		
		}	
		  
    	   
		@Override
		public List<Debtor> insertList(List<Debtor> debtorList)throws ServiceException, ServiceDaoException{
		
		return debtorService.insertList(debtorList);
		          
		
		}	
		  
    	   
		@Override
		public boolean delete(Long id)throws ServiceException, ServiceDaoException{
		
		return debtorService.delete(id);
		          
		
		}	
		  
    	   
		@Override
		public boolean update(Debtor debtor)throws ServiceException, ServiceDaoException{
		
		return debtorService.update(debtor);
		          
		
		}	
		  
    	   
		@Override
		public boolean updateList(List<Debtor> debtorList)throws ServiceException, ServiceDaoException{
		
		return debtorService.updateList(debtorList);
		          
		
		}	
		  
    	   
		@Override
		public Debtor getObjectById(Long id)throws ServiceException, ServiceDaoException{
		
		return debtorService.getObjectById(id);
		          
		
		}	
		  
    	   
		@Override
		public List<Debtor> getObjectsByIds(List<Long> ids)throws ServiceException, ServiceDaoException{
		
		return debtorService.getObjectsByIds(ids);
		          
		
		}	
		  
    	
	
	
	
	
		
	
	
    		
	
		@Override
	public List<Long> getDebtorIds(Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return debtorService.getDebtorIds(start, limit);
	}

	@Override
	public Integer countDebtorIds() throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return debtorService.countDebtorIds();
	}
	
	
	@Override
	public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return debtorService.getIdsByDynamicCondition(clz, conditions, start, limit);
	}


	@Override
	public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
		// TODO Auto-generated method stub
		return debtorService.fakeDelete(clz, id);
	}
	
	
	
	@Override
	public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
		   debtorService.deleteList(clz, ids);
		
	}
	
	@Override
	public Object getObjectByDynamicCondition(Class clz,
			Map<String, Object> conditions, Integer start, Integer limit)
			throws ServiceException, ServiceDaoException {
	
		return this.debtorService.getObjectByDynamicCondition(clz, conditions, start, limit);
	}


 
}

