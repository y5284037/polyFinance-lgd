<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="bankList" id="current_nav">
<div id="bankListApp" ng-app="bankListApp">
	<div ng-controller="bankListController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>BankList管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addBankList(bankList)">新增</span>
		    </span>
	
			<paging url="/web/a/bankList">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>银行名称</td>
			        				                    <td>支付机构号</td>
			        				                    <td>提现机构号</td>
			        				                    <td>单笔限额</td>
			        				                    <td>日累计限额</td>
			        				                    <td>ICON</td>
			        				                    <td>注册时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="bankList in data">				
									                    <td ng-bind="bankList.id" ></td>
			        				                    <td ng-bind="bankList.name" ></td>
			        				                    <td ng-bind="bankList.paymentAgencyNumber" ></td>
			        				                    <td ng-bind="bankList.withdrawAgencyNumber" ></td>
			        				                    <td ng-bind="bankList.singleTransactionLimit" ></td>
			        				                    <td ng-bind="bankList.dailyLimit" ></td>
			        				                    <td ng-bind="bankList.logoPic" ></td>
			        				                    <td ng-bind="bankList.createAt" ></td>
			        				                    <td ng-bind="bankList.updateAt" ></td>
			        				                    <td ng-bind="bankList.createBy" ></td>
			        				                    <td ng-bind="bankList.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateBankList(bankList.id)" /> 
							<input type="button" value="删除" ng-click="deleteBankList(bankList.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/polyFinance-lgd-server/bankList/bankListList.js"></script>
