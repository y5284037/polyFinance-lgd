<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="userBank" id="current_nav">
<div id="userBankApp" ng-app="userBankApp">
	<div ng-controller="userBankController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>UserBank管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addUserBank(userBank)">新增</span>
		    </span>
	
			<paging url="/web/a/userBank">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>城市</td>
			        				                    <td>关联bank_list表id</td>
			        				                    <td>银行名称</td>
			        				                    <td>银行卡号</td>
			        				                    <td>预留手机号</td>
			        				                    <td>关联user表id</td>
			        				                    <td>默认银行卡</td>
			        				                    <td>注册时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="userBank in data">				
									                    <td ng-bind="userBank.id" ></td>
			        				                    <td ng-bind="userBank.city" ></td>
			        				                    <td ng-bind="userBank.bankListId" ></td>
			        				                    <td ng-bind="userBank.bankName" ></td>
			        				                    <td ng-bind="userBank.cardNo" ></td>
			        				                    <td ng-bind="userBank.bankPhone" ></td>
			        				                    <td ng-bind="userBank.userId" ></td>
			        				                    <td ng-bind="userBank.first" ></td>
			        				                    <td ng-bind="userBank.createAt" ></td>
			        				                    <td ng-bind="userBank.updateAt" ></td>
			        				                    <td ng-bind="userBank.createBy" ></td>
			        				                    <td ng-bind="userBank.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateUserBank(userBank.id)" /> 
							<input type="button" value="删除" ng-click="deleteUserBank(userBank.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/polyFinance-lgd-server/userBank/userBankList.js"></script>
