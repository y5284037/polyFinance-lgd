<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="repayment" id="current_nav">
<div id="repaymentApp" ng-app="repaymentApp">
	<div ng-controller="repaymentController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Repayment管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addRepayment(repayment)">新增</span>
		    </span>
	
			<paging url="/web/a/repayment">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>关联user表id</td>
			        				                    <td>关联invest_record表id</td>
			        				                    <td>还款时间</td>
			        				                    <td>还款金额</td>
			        				                    <td>金额属性(利息,本金)</td>
			        				                    <td>还款状态(未还款,已还款,已续投)</td>
			        				                    <td>创建时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人id</td>
			        				                    <td>更新人id</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="repayment in data">				
									                    <td ng-bind="repayment.id" ></td>
			        				                    <td ng-bind="repayment.userId" ></td>
			        				                    <td ng-bind="repayment.investRecordId" ></td>
			        				                    <td ng-bind="repayment.repaymentDate" ></td>
			        				                    <td ng-bind="repayment.repaymentAmount" ></td>
			        				                    <td ng-bind="repayment.moneyType" ></td>
			        				                    <td ng-bind="repayment.repaymentStatus" ></td>
			        				                    <td ng-bind="repayment.createAt" ></td>
			        				                    <td ng-bind="repayment.updateAt" ></td>
			        				                    <td ng-bind="repayment.createBy" ></td>
			        				                    <td ng-bind="repayment.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateRepayment(repayment.id)" /> 
							<input type="button" value="删除" ng-click="deleteRepayment(repayment.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/polyFinance-lgd-server/repayment/repaymentList.js"></script>
