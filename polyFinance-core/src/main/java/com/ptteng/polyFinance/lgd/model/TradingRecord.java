package com.ptteng.polyFinance.lgd.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


@Entity
@Table(name = "trading_record")
public class TradingRecord implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6121501286055243776L;	
	
		
   	 
    private  Long id;
	
  	 
    private  Long userId;
	
  	 
    private  String tradingNum;
	
  	 
    private  String productName;
	
  	 
    private BigDecimal tradingAmount;
	
  	 
    private  Integer tradingType;
	
  	 
    private  Integer tradingStatus;
	
  	 
    private  String tradingMode;
	
  	 
    private  Long tradingTime;
	
  	 
    private  Long createAt;
	
  	 
    private  Long updateAt;
	
  	 
    private  Long createBy;
	
  	 
    private  Long updateBy;
	
  
	
		 	
         	 	   @Id
     	   @GeneratedValue(strategy = GenerationType.AUTO)
              	@Column(name = "id")
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
		 	@Column(name = "user_id")
	public Long getUserId() {
		return userId;
	}
	
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
		 	@Column(name = "trading_num")
	public String getTradingNum() {
		return tradingNum;
	}
	
	
	public void setTradingNum(String tradingNum) {
		this.tradingNum = tradingNum;
	}
		 	@Column(name = "product_name")
	public String getProductName() {
		return productName;
	}
	
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
		 	@Column(name = "trading_amount")
	public BigDecimal getTradingAmount() {
		return tradingAmount;
	}
	
	
	public void setTradingAmount(BigDecimal tradingAmount) {
		this.tradingAmount = tradingAmount;
	}
		 	@Column(name = "trading_type")
	public Integer getTradingType() {
		return tradingType;
	}
	
	
	public void setTradingType(Integer tradingType) {
		this.tradingType = tradingType;
	}
		 	@Column(name = "trading_status")
	public Integer getTradingStatus() {
		return tradingStatus;
	}
	
	
	public void setTradingStatus(Integer tradingStatus) {
		this.tradingStatus = tradingStatus;
	}
		 	@Column(name = "trading_mode")
	public String getTradingMode() {
		return tradingMode;
	}
	
	
	public void setTradingMode(String tradingMode) {
		this.tradingMode = tradingMode;
	}
		 	@Column(name = "trading_time")
	public Long getTradingTime() {
		return tradingTime;
	}
	
	
	public void setTradingTime(Long tradingTime) {
		this.tradingTime = tradingTime;
	}
		 	@Column(name = "create_at")
	public Long getCreateAt() {
		return createAt;
	}
	
	
	public void setCreateAt(Long createAt) {
		this.createAt = createAt;
	}
		 	@Column(name = "update_at")
	public Long getUpdateAt() {
		return updateAt;
	}
	
	
	public void setUpdateAt(Long updateAt) {
		this.updateAt = updateAt;
	}
		 	@Column(name = "create_by")
	public Long getCreateBy() {
		return createBy;
	}
	
	
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
		 	@Column(name = "update_by")
	public Long getUpdateBy() {
		return updateBy;
	}
	
	
	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}

