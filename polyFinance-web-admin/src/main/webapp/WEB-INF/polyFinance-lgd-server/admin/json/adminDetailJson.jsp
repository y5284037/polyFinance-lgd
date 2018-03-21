<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${admin.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="loginName" value="${admin.loginName}"></json:property>
           
           
	   
                    			
               
                    <json:property name="adminRoleId" value="${admin.adminRoleId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="pswd" value="${admin.pswd}"></json:property>
           
           
	   
                    			
               
                    <json:property name="salt" value="${admin.salt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${admin.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${admin.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${admin.createBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${admin.updateBy}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


