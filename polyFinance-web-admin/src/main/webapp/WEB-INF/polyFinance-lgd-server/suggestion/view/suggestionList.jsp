<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>

<input type="hidden" value="suggestion" id="current_nav">
<div id="suggestionApp" ng-app="suggestionApp">
	<div ng-controller="suggestionController">

		<div class="portlet">
		    <div class="portlet-title">
		        <div class="caption"><i class="fa fa-cogs"></i>Suggestion管理</div>
		    </div>
		    <span class="btn green fileinput-button">
		        <i class="fa fa-plus"></i>
		        <span ng-click="addSuggestion(suggestion)">新增</span>
		    </span>
	
			<paging url="/web/a/suggestion">
				<table class="table table-striped table-bordered table-hover">
					<tr>
									                    <td>自增长ID</td>
			        				                    <td>手机号</td>
			        				                    <td>姓名</td>
			        				                    <td>email</td>
			        				                    <td>内容</td>
			        				                    <td>注册时间</td>
			        				                    <td>更新时间</td>
			        				                    <td>创建人</td>
			        				                    <td>更新人</td>
			        							<th>操作</th>
					</tr>
					<tr ng-repeat="suggestion in data">				
									                    <td ng-bind="suggestion.id" ></td>
			        				                    <td ng-bind="suggestion.phone" ></td>
			        				                    <td ng-bind="suggestion.name" ></td>
			        				                    <td ng-bind="suggestion.email" ></td>
			        				                    <td ng-bind="suggestion.suggestionDetail" ></td>
			        				                    <td ng-bind="suggestion.createAt" ></td>
			        				                    <td ng-bind="suggestion.updateAt" ></td>
			        				                    <td ng-bind="suggestion.createBy" ></td>
			        				                    <td ng-bind="suggestion.updateBy" ></td>
			        								
						<td>
							<input type="button" value="修改" ng-click="updateSuggestion(suggestion.id)" /> 
							<input type="button" value="删除" ng-click="deleteSuggestion(suggestion.id)" />
						</td>
					</tr>
				</table>		
			</paging>
	
		</div>
	</div>
</div>

<!-- Angular JS -->
<script src="/r/js-src/web/polyFinance-lgd-server/suggestion/suggestionList.js"></script>
