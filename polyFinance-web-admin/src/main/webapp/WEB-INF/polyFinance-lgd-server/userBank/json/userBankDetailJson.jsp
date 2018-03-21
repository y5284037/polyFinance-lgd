<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${userBank.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="city" value="${userBank.city}"></json:property>
           
           
	   
                    			
               
                    <json:property name="bankListId" value="${userBank.bankListId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="bankName" value="${userBank.bankName}"></json:property>
           
           
	   
                    			
               
                    <json:property name="cardNo" value="${userBank.cardNo}"></json:property>
           
           
	   
                    			
               
                    <json:property name="bankPhone" value="${userBank.bankPhone}"></json:property>
           
           
	   
                    			
               
                    <json:property name="userId" value="${userBank.userId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="first" value="${userBank.first}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${userBank.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${userBank.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${userBank.createBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${userBank.updateBy}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


