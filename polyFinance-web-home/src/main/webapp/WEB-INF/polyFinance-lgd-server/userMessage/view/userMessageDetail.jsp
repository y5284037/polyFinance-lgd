<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="userMessage" id="current_nav">
	<div id="userMessageDetailApp" ng-app="userMessageDetailApp">
		<div ng-controller="userMessageDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="userMessageForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="userMessageId" ng-model="userMessage.id" ng-bind="userMessage.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="userId" class="col-sm-2 control-label">关联user表id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="userId" ng-model="userMessage.userId" ng-bind="userMessage.userId" placeholder="请输入关联user表id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="messageType" class="col-sm-2 control-label">消息类型</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="messageType" ng-model="userMessage.messageType" ng-bind="userMessage.messageType" placeholder="请输入消息类型" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="messageReadStatus" class="col-sm-2 control-label">消息阅读状态</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="messageReadStatus" ng-model="userMessage.messageReadStatus" ng-bind="userMessage.messageReadStatus" placeholder="请输入消息阅读状态" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="investRecordId" class="col-sm-2 control-label">投资详情表id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="investRecordId" ng-model="userMessage.investRecordId" ng-bind="userMessage.investRecordId" placeholder="请输入投资详情表id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="content" class="col-sm-2 control-label">消息内容</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="content" ng-model="userMessage.content" ng-bind="userMessage.content" placeholder="请输入消息内容" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="userMessage.createBy" ng-bind="userMessage.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="userMessage.updateBy" ng-bind="userMessage.updateBy" placeholder="请输入更新人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateUserMessage(userMessage)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/userMessage">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/polyFinance-lgd-server/userMessage/userMessageDetail.js"></script>
