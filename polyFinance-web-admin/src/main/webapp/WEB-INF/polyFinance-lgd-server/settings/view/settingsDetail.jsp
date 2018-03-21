<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="settings" id="current_nav">
	<div id="settingsDetailApp" ng-app="settingsDetailApp">
		<div ng-controller="settingsDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="settingsForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="settingsId" ng-model="settings.id" ng-bind="settings.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="companyChop" class="col-sm-2 control-label">公章</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="companyChop" ng-model="settings.companyChop" ng-bind="settings.companyChop" placeholder="请输入公章" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="invsetExpireWarn" class="col-sm-2 control-label">投资到期消息提前天数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="invsetExpireWarn" ng-model="settings.invsetExpireWarn" ng-bind="settings.invsetExpireWarn" placeholder="请输入投资到期消息提前天数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="DaysBeforeMaturity" class="col-sm-2 control-label">债权到期提前天数</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="DaysBeforeMaturity" ng-model="settings.DaysBeforeMaturity" ng-bind="settings.DaysBeforeMaturity" placeholder="请输入债权到期提前天数" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="investFullLine" class="col-sm-2 control-label">总债权投满警戒线</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="investFullLine" ng-model="settings.investFullLine" ng-bind="settings.investFullLine" placeholder="请输入总债权投满警戒线" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="status" class="col-sm-2 control-label">设置状态</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="status" ng-model="settings.status" ng-bind="settings.status" placeholder="请输入设置状态" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="settings.createBy" ng-bind="settings.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="settings.updateBy" ng-bind="settings.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateSettings(settings)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/settings">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/polyFinance-lgd-server/settings/settingsDetail.js"></script>
