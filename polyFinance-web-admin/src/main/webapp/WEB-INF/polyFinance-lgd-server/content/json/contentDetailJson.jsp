<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
    <json:property name="contentCoverPicUrl" value="${contentCoverPicUrl}"/>
    <json:property name="contentPicUrl" value="${contentPicUrl}"/>



			<json:object name="data">
		
								
               
                    <json:property name="id" value="${content.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="title" value="${content.title}"></json:property>
           
           
	   
                    			
               
                    <json:property name="type" value="${content.type}"></json:property>
           
           
	   
                    			
               
                    <json:property name="status" value="${content.status}"></json:property>
           
           
	   
                    			
               
                    <json:property name="contentCoverPic" value="${content.contentCoverPic}"></json:property>
           
           
	   
                    			
               
                    <json:property name="contentPic" value="${content.contentPic}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${content.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${content.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${content.createBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${content.updateBy}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


