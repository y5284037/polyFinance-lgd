<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${debtorMatch.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="debtorId" value="${debtorMatch.debtorId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="comodatoNum" value="${debtorMatch.comodatoNum}"></json:property>
           
           
	   
                    			
               
                    <json:property name="intercreditorAgreement" value="${debtorMatch.intercreditorAgreement}"></json:property>
           
           
	   
                    			
               
                    <json:property name="name" value="${debtorMatch.name}"></json:property>
           
           
	   
                    			
               
                    <json:property name="productName" value="${debtorMatch.productName}"></json:property>
           
           
	   
                    			
               
                    <json:property name="valueDay" value="${debtorMatch.valueDay}"></json:property>
           
           
	   
                    			
               
                    <json:property name="valueEndDay" value="${debtorMatch.valueEndDay}"></json:property>
           
           
	   
                    			
               
                    <json:property name="investAmount" value="${debtorMatch.investAmount}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${debtorMatch.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${debtorMatch.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${debtorMatch.createBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${debtorMatch.updateBy}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


