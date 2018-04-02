<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../includes/includes.jsp"%>
<%@page contentType="text/html;charset=utf-8"%>

<json:object escapeXml="false">
<json:property name="code" value="${code}"></json:property>
	<json:property name="message">
		<spring:message code="${code}" />
	</json:property>
	<json:property name="size" value="${size}"></json:property>
	<json:property name="total" value="${total}"></json:property>
	<json:array name="data">
		<c:forEach items="${againRecords}" var="investRecord">
			<json:object>
					
               
                    <json:property name="id" value="${investRecord.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="userId" value="${investRecord.userId}"></json:property>
           
           
	   
        			
               
                    <json:property name="productId" value="${investRecord.productId}"></json:property>
           
           
	   
        			
               
                    <json:property name="productName" value="${investRecord.productName}"></json:property>
           
           
	   
        			
               
                    <json:property name="productInterestRate" value="${investRecord.productInterestRate}"></json:property>
           
           
	   
        			
               
                    <json:property name="productPaymentMethod" value="${investRecord.productPaymentMethod}"></json:property>
           
           
	   
        			
               
                    <json:property name="productInterestAmountLine" value="${investRecord.productInterestAmountLine}"></json:property>
           
           
	   
        			
               
                    <json:property name="repaymentBank" value="${investRecord.repaymentBank}"></json:property>
           
           
	   
        			
               
                    <json:property name="repaymentCard" value="${investRecord.repaymentCard}"></json:property>
           
           
	   
        			
               
                    <json:property name="repaymentBankName" value="${investRecord.repaymentBankName}"></json:property>
           
           
	   
        			
               
                    <json:property name="investAmount" value="${investRecord.investAmount}"></json:property>
           
           
	   
        			
               
                    <json:property name="comodatoNum" value="${investRecord.comodatoNum}"></json:property>
           
           
	   
        			
               
                    <json:property name="intercreditorAgreement" value="${investRecord.intercreditorAgreement}"></json:property>
           
           
	   
        			
               
                    <json:property name="investStatus" value="${investRecord.investStatus}"></json:property>
           
           
	   
        			
               
                    <json:property name="undistributedIncome" value="${investRecord.undistributedIncome}"></json:property>
           
           
	   
        			
               
                    <json:property name="distributionIncome" value="${investRecord.distributionIncome}"></json:property>
           
           
	   
        			
               
                    <json:property name="valueDay" value="${investRecord.valueDay}"></json:property>
           
           
	   
        			
               
                    <json:property name="valueEndDay" value="${investRecord.valueEndDay}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${investRecord.createAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${investRecord.createBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${investRecord.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${investRecord.updateBy}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


