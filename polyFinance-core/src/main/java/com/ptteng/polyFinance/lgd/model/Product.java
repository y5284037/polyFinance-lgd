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
@Table(name = "product")
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6153193103900954624L;	
	
		
   	 
    private  Long id;
	
  	 
    private  String productMark;
	
  	 
    private  String name;
	
  	 
    private BigDecimal interestRate;
	
  	 
    private  Integer financialPeriodDay;
	
  	 
    private  Integer financialPeriodMonth;
	
  	 
    private  Integer paymentMethod;
	
  	 
    private  Integer interestDelayed;
	
  	 
    private  Integer productStatus;
	
  	 
    private  BigDecimal interestAmountLine;
	
  	 
    private  String remark;
	
  	 
    private  Integer detailsPic;
	
  	 
    private  Integer hotCornerMark;
	
  	 
    private  Integer newCornerMark;
	
  	 
    private  Integer recommended;
	
  	 
    private  Integer limited;
	
  	 
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
		 	@Column(name = "product_mark")
	public String getProductMark() {
		return productMark;
	}
	
	
	public void setProductMark(String productMark) {
		this.productMark = productMark;
	}
		 	@Column(name = "name")
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
		 	@Column(name = "interest_rate")
	public BigDecimal getInterestRate() {
		return interestRate;
	}
	
	
	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}
		 	@Column(name = "financial_period_day")
	public Integer getFinancialPeriodDay() {
		return financialPeriodDay;
	}
	
	
	public void setFinancialPeriodDay(Integer financialPeriodDay) {
		this.financialPeriodDay = financialPeriodDay;
	}
		 	@Column(name = "financial_period_month")
	public Integer getFinancialPeriodMonth() {
		return financialPeriodMonth;
	}
	
	
	public void setFinancialPeriodMonth(Integer financialPeriodMonth) {
		this.financialPeriodMonth = financialPeriodMonth;
	}
		 	@Column(name = "payment_method")
	public Integer getPaymentMethod() {
		return paymentMethod;
	}
	
	
	public void setPaymentMethod(Integer paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
		 	@Column(name = "interest_delayed")
	public Integer getInterestDelayed() {
		return interestDelayed;
	}
	
	
	public void setInterestDelayed(Integer interestDelayed) {
		this.interestDelayed = interestDelayed;
	}
		 	@Column(name = "product_status")
	public Integer getProductStatus() {
		return productStatus;
	}
	
	
	public void setProductStatus(Integer productStatus) {
		this.productStatus = productStatus;
	}
		 	@Column(name = "interest_amount_line")
	public BigDecimal getInterestAmountLine() {
		return interestAmountLine;
	}
	
	
	public void setInterestAmountLine(BigDecimal interestAmountLine) {
		this.interestAmountLine = interestAmountLine;
	}
		 	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}
	
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
		 	@Column(name = "details_pic")
	public Integer getDetailsPic() {
		return detailsPic;
	}
	
	
	public void setDetailsPic(Integer detailsPic) {
		this.detailsPic = detailsPic;
	}
		 	@Column(name = "hot_corner_mark")
	public Integer getHotCornerMark() {
		return hotCornerMark;
	}
	
	
	public void setHotCornerMark(Integer hotCornerMark) {
		this.hotCornerMark = hotCornerMark;
	}
		 	@Column(name = "new_corner_mark")
	public Integer getNewCornerMark() {
		return newCornerMark;
	}
	
	
	public void setNewCornerMark(Integer newCornerMark) {
		this.newCornerMark = newCornerMark;
	}
		 	@Column(name = "recommended")
	public Integer getRecommended() {
		return recommended;
	}
	
	
	public void setRecommended(Integer recommended) {
		this.recommended = recommended;
	}
		 	@Column(name = "limited")
	public Integer getLimited() {
		return limited;
	}
	
	
	public void setLimited(Integer limited) {
		this.limited = limited;
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

