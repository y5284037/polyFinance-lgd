<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="user" id="current_nav">
<div id="userApp" ng-app="userApp">
	<div ng-controller="userController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>User管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addUser(user)">新增</span>
		    </span>
	
			<paging url="/web/a/user">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>用户编号</td>
			        				                    <td>手机号码</td>
			        				                    <td>密码</td>
			        				                    <td>盐值</td>
			        				                    <td>理财经理工号</td>
			        				                    <td>真实姓名</td>
			        				                    <td>总资产</td>
			        				                    <td>总收益</td>
			        				                    <td>帐户状态</td>
			        				                    <td>详情地址</td>
			        				                    <td>电子邮箱</td>
			        				                    <td>身份证正面</td>
			        				                    <td>身份证反面</td>
			        				                    <td>身份证号码</td>
			        				                    <td>实名状态</td>
			        				                    <td>拒绝理由</td>
			        				                    <td>被拒绝状态(1代表非第一次)</td>
			        				                    <td>申请实名时间</td>
			        				                    <td>默认银行卡(关联user_bank_id)</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人id</td>
			        				                    <td>更新人id</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="user in data">				
									                    <td ng-bind="user.id" ></td>
			        				                    <td ng-bind="user.serialNum" ></td>
			        				                    <td ng-bind="user.phoneNum" ></td>
			        				                    <td ng-bind="user.pswd" ></td>
			        				                    <td ng-bind="user.salt" ></td>
			        				                    <td ng-bind="user.managerNum" ></td>
			        				                    <td ng-bind="user.name" ></td>
			        				                    <td ng-bind="user.totalProperty" ></td>
			        				                    <td ng-bind="user.income" ></td>
			        				                    <td ng-bind="user.accountsStatus" ></td>
			        				                    <td ng-bind="user.address" ></td>
			        				                    <td ng-bind="user.email" ></td>
			        				                    <td ng-bind="user.idCardFornt" ></td>
			        				                    <td ng-bind="user.idCardBack" ></td>
			        				                    <td ng-bind="user.idCard" ></td>
			        				                    <td ng-bind="user.identityStatus" ></td>
			        				                    <td ng-bind="user.refuseReason" ></td>
			        				                    <td ng-bind="user.refuseStatus" ></td>
			        				                    <td ng-bind="user.identityTime" ></td>
			        				                    <td ng-bind="user.userBankId" ></td>
			        				                    <td ng-bind="user.createAt" ></td>
			        				                    <td ng-bind="user.updateAt" ></td>
			        				                    <td ng-bind="user.createBy" ></td>
			        				                    <td ng-bind="user.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateUser(user.id)" /> 
							<input type="button" value="删除" ng-click="deleteUser(user.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/polyFinance-lgd-server/user/userList.js"></script>
