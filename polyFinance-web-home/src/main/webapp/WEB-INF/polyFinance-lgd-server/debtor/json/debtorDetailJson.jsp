<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
	<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>

			<json:object name="data">
		
								
               
                    <json:property name="id" value="${debtor.id}"></json:property>
           
           
	   
                    			
               
                    <json:property name="debtorMark" value="${debtor.debtorMark}"></json:property>
           
           
	   
                    			
               
                    <json:property name="debtorName" value="${debtor.debtorName}"></json:property>
           
           
	   
                    			
               
                    <json:property name="debtorPhone" value="${debtor.debtorPhone}"></json:property>
           
           
	   
                    			
               
                    <json:property name="debtorIDcard" value="${debtor.debtorIDcard}"></json:property>
           
           
	   
                    			
               
                    <json:property name="expires" value="${debtor.expires}"></json:property>
           
           
	   
                    			
               
                    <json:property name="debtStartTime" value="${debtor.debtStartTime}"></json:property>
           
           
	   
                    			
               
                    <json:property name="debtEndTime" value="${debtor.debtEndTime}"></json:property>
           
           
	   
                    			
               
                    <json:property name="amount" value="${debtor.amount}"></json:property>
           
           
	   
                    			
               
                    <json:property name="debtorInvest" value="${debtor.debtorInvest}"></json:property>
           
           
	   
                    			
               
                    <json:property name="status" value="${debtor.status}"></json:property>
           
           
	   
                    			
               
                    <json:property name="matchedAmount" value="${debtor.matchedAmount}"></json:property>
           
           
	   
                    			
               
                    <json:property name="remark" value="${debtor.remark}"></json:property>
           
           
	   
                    			
               
                    <json:property name="nature" value="${debtor.nature}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createAt" value="${debtor.createAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateAt" value="${debtor.updateAt}"></json:property>
           
           
	   
                    			
               
                    <json:property name="createBy" value="${debtor.createBy}"></json:property>
           
           
	   
                    			
               
                    <json:property name="updateBy" value="${debtor.updateBy}"></json:property>
           
           
	   
                    				
	 
			</json:object>
		
</json:object>


