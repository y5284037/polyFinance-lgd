<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${authority.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="adminRoleId" value="${authority.adminRoleId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="moduleId" value="${authority.moduleId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${authority.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${authority.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${authority.createBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${authority.updateBy}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


