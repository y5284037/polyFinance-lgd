<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="module" id="current_nav">
	<div id="moduleDetailApp" ng-app="moduleDetailApp">
		<div ng-controller="moduleDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="moduleForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="moduleId" ng-model="module.id" ng-bind="module.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="moduleName" class="col-sm-2 control-label">模块名字</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="moduleName" ng-model="module.moduleName" ng-bind="module.moduleName" placeholder="请输入模块名字" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="url" class="col-sm-2 control-label">模块对应url地址</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="url" ng-model="module.url" ng-bind="module.url" placeholder="请输入模块对应url地址" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="parentModuleId" class="col-sm-2 control-label">父模块ID</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="parentModuleId" ng-model="module.parentModuleId" ng-bind="module.parentModuleId" placeholder="请输入父模块ID" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="moduleType" class="col-sm-2 control-label">模块类型</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="moduleType" ng-model="module.moduleType" ng-bind="module.moduleType" placeholder="请输入模块类型" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="module.createBy" ng-bind="module.createBy" placeholder="请输入创建人id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="module.updateBy" ng-bind="module.updateBy" placeholder="请输入更新人id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateModule(module)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/module">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/polyFinance-lgd-server/module/moduleDetail.js"></script>
