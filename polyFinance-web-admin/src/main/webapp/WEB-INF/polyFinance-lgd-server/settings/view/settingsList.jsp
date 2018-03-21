<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="settings" id="current_nav">
<div id="settingsApp" ng-app="settingsApp">
	<div ng-controller="settingsController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Settings管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addSettings(settings)">新增</span>
		    </span>
	
			<paging url="/web/a/settings">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>公章</td>
			        				                    <td>投资到期消息提前天数</td>
			        				                    <td>债权到期提前天数</td>
			        				                    <td>总债权投满警戒线</td>
			        				                    <td>设置状态</td>
			        				                    <td>注册时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="settings in data">				
									                    <td ng-bind="settings.id" ></td>
			        				                    <td ng-bind="settings.companyChop" ></td>
			        				                    <td ng-bind="settings.invsetExpireWarn" ></td>
			        				                    <td ng-bind="settings.DaysBeforeMaturity" ></td>
			        				                    <td ng-bind="settings.investFullLine" ></td>
			        				                    <td ng-bind="settings.status" ></td>
			        				                    <td ng-bind="settings.createAt" ></td>
			        				                    <td ng-bind="settings.updateAt" ></td>
			        				                    <td ng-bind="settings.createBy" ></td>
			        				                    <td ng-bind="settings.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateSettings(settings.id)" /> 
							<input type="button" value="删除" ng-click="deleteSettings(settings.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/polyFinance-lgd-server/settings/settingsList.js"></script>
