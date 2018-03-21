/**
 * 
 */
package com.ptteng.polyFinance.lgd.client;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.Admin;
import com.ptteng.polyFinance.lgd.service.AdminService;

import java.util.List;
import java.util.Map;

public class AdminSCAClient implements AdminService {
    
    private AdminService adminService;
    
    public AdminService getAdminService() {
        return adminService;
    }
    
    
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }
    
    
    @Override
    public Long insert(Admin admin) throws ServiceException, ServiceDaoException {
        
        return adminService.insert(admin);
        
        
    }
    
    
    @Override
    public List<Admin> insertList(List<Admin> adminList) throws ServiceException, ServiceDaoException {
        
        return adminService.insertList(adminList);
        
        
    }
    
    
    @Override
    public boolean delete(Long id) throws ServiceException, ServiceDaoException {
        
        return adminService.delete(id);
        
        
    }
    
    
    @Override
    public boolean update(Admin admin) throws ServiceException, ServiceDaoException {
        
        return adminService.update(admin);
        
        
    }
    
    
    @Override
    public boolean updateList(List<Admin> adminList) throws ServiceException, ServiceDaoException {
        
        return adminService.updateList(adminList);
        
        
    }
    
    
    @Override
    public Admin getObjectById(Long id) throws ServiceException, ServiceDaoException {
        
        return adminService.getObjectById(id);
        
        
    }
    
    
    @Override
    public List<Admin> getObjectsByIds(List<Long> ids) throws ServiceException, ServiceDaoException {
        
        return adminService.getObjectsByIds(ids);
        
        
    }
    
    @Override
    public Admin getObjectByLoginName(String loginName) throws ServiceException, ServiceDaoException {
        return adminService.getObjectByLoginName(loginName);
    }
    
    
    @Override
    public List<Long> getAdminIds(Integer start, Integer limit)
            throws ServiceException, ServiceDaoException {
        // TODO Auto-generated method stub
        return adminService.getAdminIds(start, limit);
    }
    
    @Override
    public Integer countAdminIds() throws ServiceException, ServiceDaoException {
        // TODO Auto-generated method stub
        return adminService.countAdminIds();
    }
    
    
    @Override
    public List<Long> getIdsByDynamicCondition(Class clz, Map<String, Object> conditions, Integer start, Integer limit)
            throws ServiceException, ServiceDaoException {
        // TODO Auto-generated method stub
        return adminService.getIdsByDynamicCondition(clz, conditions, start, limit);
    }
    
    
    @Override
    public boolean fakeDelete(Class clz, Long id) throws ServiceException, ServiceDaoException {
        // TODO Auto-generated method stub
        return adminService.fakeDelete(clz, id);
    }
    
    
    @Override
    public void deleteList(Class clz, List<Long> ids) throws ServiceException, ServiceDaoException {
        adminService.deleteList(clz, ids);
        
    }
    
    @Override
    public Object getObjectByDynamicCondition(Class clz,
                                              Map<String, Object> conditions, Integer start, Integer limit)
            throws ServiceException, ServiceDaoException {
        
        return this.adminService.getObjectByDynamicCondition(clz, conditions, start, limit);
    }
    
    
}

