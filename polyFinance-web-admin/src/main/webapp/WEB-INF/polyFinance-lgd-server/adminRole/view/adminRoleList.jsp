<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="adminRole" id="current_nav">
<div id="adminRoleApp" ng-app="adminRoleApp">
	<div ng-controller="adminRoleController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>AdminRole管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addAdminRole(adminRole)">新增</span>
		    </span>
	
			<paging url="/web/a/adminRole">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>角色名</td>
			        				                    <td>注册时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="adminRole in data">				
									                    <td ng-bind="adminRole.id" ></td>
			        				                    <td ng-bind="adminRole.roleName" ></td>
			        				                    <td ng-bind="adminRole.createAt" ></td>
			        				                    <td ng-bind="adminRole.updateAt" ></td>
			        				                    <td ng-bind="adminRole.createBy" ></td>
			        				                    <td ng-bind="adminRole.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateAdminRole(adminRole.id)" /> 
							<input type="button" value="删除" ng-click="deleteAdminRole(adminRole.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/polyFinance-lgd-server/adminRole/adminRoleList.js"></script>
