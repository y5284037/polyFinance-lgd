<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="sysMessage" id="current_nav">
	<div id="sysMessageDetailApp" ng-app="sysMessageDetailApp">
		<div ng-controller="sysMessageDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="sysMessageForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="sysMessageId" ng-model="sysMessage.id" ng-bind="sysMessage.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="title" class="col-sm-2 control-label">标题</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="title" ng-model="sysMessage.title" ng-bind="sysMessage.title" placeholder="请输入标题" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="status" class="col-sm-2 control-label">状态(上线,草稿)</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="status" ng-model="sysMessage.status" ng-bind="sysMessage.status" placeholder="请输入状态(上线,草稿)" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="resume" class="col-sm-2 control-label">摘要</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="resume" ng-model="sysMessage.resume" ng-bind="sysMessage.resume" placeholder="请输入摘要" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="messagePic" class="col-sm-2 control-label">图片内容</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="messagePic" ng-model="sysMessage.messagePic" ng-bind="sysMessage.messagePic" placeholder="请输入图片内容" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="messageType" class="col-sm-2 control-label">消息类型</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="messageType" ng-model="sysMessage.messageType" ng-bind="sysMessage.messageType" placeholder="请输入消息类型" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="sendType" class="col-sm-2 control-label">发送类型</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="sendType" ng-model="sysMessage.sendType" ng-bind="sysMessage.sendType" placeholder="请输入发送类型" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="sendTime" class="col-sm-2 control-label">发送时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="sendTime" ng-model="sysMessage.sendTime" ng-bind="sysMessage.sendTime" placeholder="请输入发送时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="sendTo" class="col-sm-2 control-label">发送人群</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="sendTo" ng-model="sysMessage.sendTo" ng-bind="sysMessage.sendTo" placeholder="请输入发送人群" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="sysMessage.createBy" ng-bind="sysMessage.createBy" placeholder="请输入创建人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">编辑人</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="sysMessage.updateBy" ng-bind="sysMessage.updateBy" placeholder="请输入编辑人" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateSysMessage(sysMessage)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/sysMessage">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/polyFinance-lgd-server/sysMessage/sysMessageDetail.js"></script>
