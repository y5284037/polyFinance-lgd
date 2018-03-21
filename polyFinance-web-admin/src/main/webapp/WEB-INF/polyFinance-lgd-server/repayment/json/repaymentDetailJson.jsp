<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${repayment.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="userId" value="${repayment.userId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="investRecordId" value="${repayment.investRecordId}"></json:property>
           
           
	   
                    			
               
                    <json:property name="repaymentDate" value="${repayment.repaymentDate}"></json:property>
           
           
	   
                    			
               
                    <json:property name="repaymentAmount" value="${repayment.repaymentAmount}"></json:property>
           
           
	   
                    			
               
                    <json:property name="moneyType" value="${repayment.moneyType}"></json:property>
           
           
	   
                    			
               
                    <json:property name="repaymentStatus" value="${repayment.repaymentStatus}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${repayment.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${repayment.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${repayment.createBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${repayment.updateBy}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


