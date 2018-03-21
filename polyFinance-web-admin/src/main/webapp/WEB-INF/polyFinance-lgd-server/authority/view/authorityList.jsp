<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="authority" id="current_nav">
<div id="authorityApp" ng-app="authorityApp">
	<div ng-controller="authorityController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Authority管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addAuthority(authority)">新增</span>
		    </span>
	
			<paging url="/web/a/authority">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>关联admin_role表ID</td>
			        				                    <td>关联module表id</td>
			        				                    <td>注册时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="authority in data">				
									                    <td ng-bind="authority.id" ></td>
			        				                    <td ng-bind="authority.adminRoleId" ></td>
			        				                    <td ng-bind="authority.moduleId" ></td>
			        				                    <td ng-bind="authority.createAt" ></td>
			        				                    <td ng-bind="authority.updateAt" ></td>
			        				                    <td ng-bind="authority.createBy" ></td>
			        				                    <td ng-bind="authority.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateAuthority(authority.id)" /> 
							<input type="button" value="删除" ng-click="deleteAuthority(authority.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/polyFinance-lgd-server/authority/authorityList.js"></script>
