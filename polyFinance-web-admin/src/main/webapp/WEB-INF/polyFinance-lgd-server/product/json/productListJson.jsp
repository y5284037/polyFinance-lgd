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
		<c:forEach items="${productList}" var="product">
			<json:object>
					
               
                    <json:property name="id" value="${product.id}"></json:property>
           
           
	   
        			
               
                    <json:property name="productMark" value="${product.productMark}"></json:property>
           
           
	   
        			
               
                    <json:property name="name" value="${product.name}"></json:property>
           
           
	   
        			
               
                    <json:property name="interestRate" value="${product.interestRate}"></json:property>
           
           
	   
        			
               
                    <json:property name="financialPeriodDay" value="${product.financialPeriodDay}"></json:property>
           
           
	   
        			
               
                    <json:property name="financialPeriodMonth" value="${product.financialPeriodMonth}"></json:property>
           
           
	   
        			
               
                    <json:property name="paymentMethod" value="${product.paymentMethod}"></json:property>
           
           
	   
        			
               
                    <json:property name="interestDelayed" value="${product.interestDelayed}"></json:property>
           
           
	   
        			
               
                    <json:property name="productStatus" value="${product.productStatus}"></json:property>
           
           
	   
        			
               
                    <json:property name="interestAmountLine" value="${product.interestAmountLine}"></json:property>
           
           
	   
        			
               
                    <json:property name="remark" value="${product.remark}"></json:property>
           
           
	   
        			
               
                    <json:property name="detailsPic" value="${product.detailsPic}"></json:property>
           
           
	   
        			
               
                    <json:property name="hotCornerMark" value="${product.hotCornerMark}"></json:property>
           
           
	   
        			
               
                    <json:property name="newCornerMark" value="${product.newCornerMark}"></json:property>
           
           
	   
        			
               
                    <json:property name="recommended" value="${product.recommended}"></json:property>
           
           
	   
        			
               
                    <json:property name="limited" value="${product.limited}"></json:property>
           
           
	   
        			
               
                    <json:property name="createAt" value="${product.createAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateAt" value="${product.updateAt}"></json:property>
           
           
	   
        			
               
                    <json:property name="createBy" value="${product.createBy}"></json:property>
           
           
	   
        			
               
                    <json:property name="updateBy" value="${product.updateBy}"></json:property>
           
           
	   
        			</json:object>
		</c:forEach>
	</json:array>
</json:object>


