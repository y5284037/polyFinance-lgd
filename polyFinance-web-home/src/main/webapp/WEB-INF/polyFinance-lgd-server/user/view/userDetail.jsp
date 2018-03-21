<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
    <input type="hidden" value="user" id="current_nav">
	<div id="userDetailApp" ng-app="userDetailApp">
		<div ng-controller="userDetailController">
			
			<div class="portlet">
			    <div class="portlet-title">
			        <div class="caption"><i class="fa fa-cogs"></i>
											  	<c:choose>
					   		<c:when test="${id > 0}">编辑</c:when> 
					   	    <c:otherwise>新增</c:otherwise>
				   	    </c:choose>		
					</div>
			    </div>
		
		
			    <form class="form-horizontal" role="form" name="userForm">
			   	 	
				  
				 				 
				 				      <input type="hidden" name="id" id="userId" ng-model="user.id" ng-bind="user.id" value="${id}">
			      				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="serialNum" class="col-sm-2 control-label">用户编号</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="serialNum" ng-model="user.serialNum" ng-bind="user.serialNum" placeholder="请输入用户编号" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="phoneNum" class="col-sm-2 control-label">手机号码</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="phoneNum" ng-model="user.phoneNum" ng-bind="user.phoneNum" placeholder="请输入手机号码" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="pswd" class="col-sm-2 control-label">密码</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="pswd" ng-model="user.pswd" ng-bind="user.pswd" placeholder="请输入密码" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="salt" class="col-sm-2 control-label">盐值</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="salt" ng-model="user.salt" ng-bind="user.salt" placeholder="请输入盐值" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="managerNum" class="col-sm-2 control-label">理财经理工号</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="managerNum" ng-model="user.managerNum" ng-bind="user.managerNum" placeholder="请输入理财经理工号" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="name" class="col-sm-2 control-label">真实姓名</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="name" ng-model="user.name" ng-bind="user.name" placeholder="请输入真实姓名" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="totalProperty" class="col-sm-2 control-label">总资产</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="totalProperty" ng-model="user.totalProperty" ng-bind="user.totalProperty" placeholder="请输入总资产" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="income" class="col-sm-2 control-label">总收益</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="income" ng-model="user.income" ng-bind="user.income" placeholder="请输入总收益" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="accountsStatus" class="col-sm-2 control-label">帐户状态</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="accountsStatus" ng-model="user.accountsStatus" ng-bind="user.accountsStatus" placeholder="请输入帐户状态" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="address" class="col-sm-2 control-label">详情地址</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="address" ng-model="user.address" ng-bind="user.address" placeholder="请输入详情地址" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="email" class="col-sm-2 control-label">电子邮箱</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="email" ng-model="user.email" ng-bind="user.email" placeholder="请输入电子邮箱" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="idCardFornt" class="col-sm-2 control-label">身份证正面</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="idCardFornt" ng-model="user.idCardFornt" ng-bind="user.idCardFornt" placeholder="请输入身份证正面" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="idCardBack" class="col-sm-2 control-label">身份证反面</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="idCardBack" ng-model="user.idCardBack" ng-bind="user.idCardBack" placeholder="请输入身份证反面" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="idCard" class="col-sm-2 control-label">身份证号码</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="idCard" ng-model="user.idCard" ng-bind="user.idCard" placeholder="请输入身份证号码" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="identityStatus" class="col-sm-2 control-label">实名状态</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="identityStatus" ng-model="user.identityStatus" ng-bind="user.identityStatus" placeholder="请输入实名状态" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="refuseReason" class="col-sm-2 control-label">拒绝理由</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="refuseReason" ng-model="user.refuseReason" ng-bind="user.refuseReason" placeholder="请输入拒绝理由" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="refuseStatus" class="col-sm-2 control-label">被拒绝状态(1代表非第一次)</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="refuseStatus" ng-model="user.refuseStatus" ng-bind="user.refuseStatus" placeholder="请输入被拒绝状态(1代表非第一次)" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="identityTime" class="col-sm-2 control-label">申请实名时间</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="identityTime" ng-model="user.identityTime" ng-bind="user.identityTime" placeholder="请输入申请实名时间" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="userBankId" class="col-sm-2 control-label">默认银行卡(关联user_bank_id)</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="userBankId" ng-model="user.userBankId" ng-bind="user.userBankId" placeholder="请输入默认银行卡(关联user_bank_id)" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       				     
				     
				    
			        			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="createBy" class="col-sm-2 control-label">创建人id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="createBy" ng-model="user.createBy" ng-bind="user.createBy" placeholder="请输入创建人id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            				 
				 			       	           
	                <div class="form-group">
			        <label for="updateBy" class="col-sm-2 control-label">更新人id</label>
			        <div class="col-sm-6">
			          <input type="text" class="form-control" name="updateBy" ng-model="user.updateBy" ng-bind="user.updateBy" placeholder="请输入更新人id" required>
			        </div>
			        </div>
	           
		   
	               			      
				  				  
				    
				 
				
		   
	            					  <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			          <button class="btn btn-primary col-sm-2" type="submit" ng-click="updateUser(user)">保存</button>
			          <a class="btn btn-primary col-sm-2 col-sm-offset-2" ng-href="/web/c/user">取消</a>
			        </div>
			      </div>
			     
			    </form>
			 </div>
		 </div>
	 </div>
	 
	 <script src="/r/js-src/web/polyFinance-lgd-server/user/userDetail.js"></script>
