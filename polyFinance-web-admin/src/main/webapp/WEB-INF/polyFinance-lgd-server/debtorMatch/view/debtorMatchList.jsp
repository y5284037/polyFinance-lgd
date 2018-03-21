<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="debtorMatch" id="current_nav">
<div id="debtorMatchApp" ng-app="debtorMatchApp">
	<div ng-controller="debtorMatchController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>DebtorMatch管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addDebtorMatch(debtorMatch)">新增</span>
		    </span>
	
			<paging url="/web/a/debtorMatch">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>关联debtor 的 ID</td>
			        				                    <td>出借合同编号</td>
			        				                    <td>债权协议编号</td>
			        				                    <td>用户姓名</td>
			        				                    <td>产品名称</td>
			        				                    <td>起息日</td>
			        				                    <td>到息日</td>
			        				                    <td>投资金额</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人id</td>
			        				                    <td>更新人id</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="debtorMatch in data">				
									                    <td ng-bind="debtorMatch.id" ></td>
			        				                    <td ng-bind="debtorMatch.debtorId" ></td>
			        				                    <td ng-bind="debtorMatch.comodatoNum" ></td>
			        				                    <td ng-bind="debtorMatch.intercreditorAgreement" ></td>
			        				                    <td ng-bind="debtorMatch.name" ></td>
			        				                    <td ng-bind="debtorMatch.productName" ></td>
			        				                    <td ng-bind="debtorMatch.valueDay" ></td>
			        				                    <td ng-bind="debtorMatch.valueEndDay" ></td>
			        				                    <td ng-bind="debtorMatch.investAmount" ></td>
			        				                    <td ng-bind="debtorMatch.createAt" ></td>
			        				                    <td ng-bind="debtorMatch.updateAt" ></td>
			        				                    <td ng-bind="debtorMatch.createBy" ></td>
			        				                    <td ng-bind="debtorMatch.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateDebtorMatch(debtorMatch.id)" /> 
							<input type="button" value="删除" ng-click="deleteDebtorMatch(debtorMatch.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/polyFinance-lgd-server/debtorMatch/debtorMatchList.js"></script>
