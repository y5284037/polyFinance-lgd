<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="debtor" id="current_nav">
<div id="debtorApp" ng-app="debtorApp">
	<div ng-controller="debtorController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Debtor管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addDebtor(debtor)">新增</span>
		    </span>
	
			<paging url="/web/a/debtor">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>债务人编号</td>
			        				                    <td>姓名</td>
			        				                    <td>手机号</td>
			        				                    <td>债务人身份证号码</td>
			        				                    <td>出借期限</td>
			        				                    <td>出借日期</td>
			        				                    <td>到期日期</td>
			        				                    <td>出借金额</td>
			        				                    <td>债权年利率</td>
			        				                    <td>状态</td>
			        				                    <td>匹配金额</td>
			        				                    <td>备注</td>
			        				                    <td>债权性质</td>
			        				                    <td>注册时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="debtor in data">				
									                    <td ng-bind="debtor.id" ></td>
			        				                    <td ng-bind="debtor.debtorMark" ></td>
			        				                    <td ng-bind="debtor.debtorName" ></td>
			        				                    <td ng-bind="debtor.debtorPhone" ></td>
			        				                    <td ng-bind="debtor.debtorIDcard" ></td>
			        				                    <td ng-bind="debtor.expires" ></td>
			        				                    <td ng-bind="debtor.debtStartTime" ></td>
			        				                    <td ng-bind="debtor.debtEndTime" ></td>
			        				                    <td ng-bind="debtor.amount" ></td>
			        				                    <td ng-bind="debtor.debtorInvest" ></td>
			        				                    <td ng-bind="debtor.status" ></td>
			        				                    <td ng-bind="debtor.matchedAmount" ></td>
			        				                    <td ng-bind="debtor.remark" ></td>
			        				                    <td ng-bind="debtor.nature" ></td>
			        				                    <td ng-bind="debtor.createAt" ></td>
			        				                    <td ng-bind="debtor.updateAt" ></td>
			        				                    <td ng-bind="debtor.createBy" ></td>
			        				                    <td ng-bind="debtor.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateDebtor(debtor.id)" /> 
							<input type="button" value="删除" ng-click="deleteDebtor(debtor.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/polyFinance-lgd-server/debtor/debtorList.js"></script>
