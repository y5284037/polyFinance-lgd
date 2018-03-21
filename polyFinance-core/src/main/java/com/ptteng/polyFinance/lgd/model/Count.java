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
@Table(name = "count")
public class Count implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1143524237760961536L;	
	
		
   	 
    private  Long id;
	
  	 
    private  Long productId;
	
  	 
    private  Long date;
	
  	 
    private  Integer purchasePeople;
	
  	 
    private  Integer purchaseTimes;
	
  	 
    private BigDecimal purchaseAmount;
	
  	 
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
		 	@Column(name = "product_id")
	public Long getProductId() {
		return productId;
	}
	
	
	public void setProductId(Long productId) {
		this.productId = productId;
	}
		 	@Column(name = "date")
	public Long getDate() {
		return date;
	}
	
	
	public void setDate(Long date) {
		this.date = date;
	}
		 	@Column(name = "purchase_people")
	public Integer getPurchasePeople() {
		return purchasePeople;
	}
	
	
	public void setPurchasePeople(Integer purchasePeople) {
		this.purchasePeople = purchasePeople;
	}
		 	@Column(name = "purchase_times")
	public Integer getPurchaseTimes() {
		return purchaseTimes;
	}
	
	
	public void setPurchaseTimes(Integer purchaseTimes) {
		this.purchaseTimes = purchaseTimes;
	}
		 	@Column(name = "purchase_amount")
	public BigDecimal getPurchaseAmount() {
		return purchaseAmount;
	}
	
	
	public void setPurchaseAmount(BigDecimal purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
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

