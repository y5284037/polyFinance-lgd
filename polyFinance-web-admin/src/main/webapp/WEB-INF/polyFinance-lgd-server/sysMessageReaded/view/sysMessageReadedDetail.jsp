<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="sysMessageReaded" id="current_nav">
	<div id="sysMessageReadedDetailApp" ng-app="sysMessageReadedDetailApp">
		<div ng-controller="sysMessageReadedDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="sysMessageReadedForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="sysMessageReadedId" ng-model="sysMessageReaded.id" ng-bind="sysMessageReaded.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="userId" class="col-sm-2 control-label">关联user表id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="userId" ng-model="sysMessageReaded.userId" ng-bind="sysMessageReaded.userId" placeholder="请输入关联user表id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="sysMessageId" class="col-sm-2 control-label">关联sys_message表id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="sysMessageId" ng-model="sysMessageReaded.sysMessageId" ng-bind="sysMessageReaded.sysMessageId" placeholder="请输入关联sys_message表id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="sysMessageReaded.createBy" ng-bind="sysMessageReaded.createBy" placeholder="请输入创建人id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="readStatus" class="col-sm-2 control-label">阅读状态</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="readStatus" ng-model="sysMessageReaded.readStatus" ng-bind="sysMessageReaded.readStatus" placeholder="请输入阅读状态" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="deleteStatus" class="col-sm-2 control-label">删除状态</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="deleteStatus" ng-model="sysMessageReaded.deleteStatus" ng-bind="sysMessageReaded.deleteStatus" placeholder="请输入删除状态" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="sysMessageReaded.updateBy" ng-bind="sysMessageReaded.updateBy" placeholder="请输入更新人id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateSysMessageReaded(sysMessageReaded)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/sysMessageReaded">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/polyFinance-lgd-server/sysMessageReaded/sysMessageReadedDetail.js"></script>
