<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${suggestion.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="phone" value="${suggestion.phone}"></json:property>
           
           
	   
                    			
               
                    <json:property name="name" value="${suggestion.name}"></json:property>
           
           
	   
                    			
               
                    <json:property name="email" value="${suggestion.email}"></json:property>
           
           
	   
                    			
               
                    <json:property name="suggestionDetail" value="${suggestion.suggestionDetail}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${suggestion.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${suggestion.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${suggestion.createBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${suggestion.updateBy}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


