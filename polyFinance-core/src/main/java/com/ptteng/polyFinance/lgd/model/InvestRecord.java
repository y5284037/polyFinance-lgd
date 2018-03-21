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
@Table(name = "invest_record")
public class InvestRecord implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2536605407075682304L;	
	
		
   	 
    private  Long id;
	
  	 
    private  Long userId;
	
  	 
    private  Long productId;
	
  	 
    private  String productName;
	
  	 
    private BigDecimal productInterestRate;
	
  	 
    private  Integer productPaymentMethod;
	
  	 
    private  BigDecimal productInterestAmountLine;
	
  	 
    private  String repaymentBank;
	
  	 
    private  String repaymentCard;
	
  	 
    private  String repaymentBankName;
	
  	 
    private  BigDecimal investAmount;
	
  	 
    private  String comodatoNum;
	
  	 
    private  String intercreditorAgreement;
	
  	 
    private  Integer investStatus;
	
  	 
    private  BigDecimal undistributedIncome;
	
  	 
    private  BigDecimal distributionIncome;
	
  	 
    private  Long valueDay;
	
  	 
    private  Long valueEndDay;
	
  	 
    private  Long createAt;
	
  	 
    private  Long createBy;
	
  	 
    private  Long updateAt;
	
  	 
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
		 	@Column(name = "product_id")
	public Long getProductId() {
		return productId;
	}
	
	
	public void setProductId(Long productId) {
		this.productId = productId;
	}
		 	@Column(name = "product_name")
	public String getProductName() {
		return productName;
	}
	
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
		 	@Column(name = "product_interest_rate")
	public BigDecimal getProductInterestRate() {
		return productInterestRate;
	}
	
	
	public void setProductInterestRate(BigDecimal productInterestRate) {
		this.productInterestRate = productInterestRate;
	}
		 	@Column(name = "product_payment_method")
	public Integer getProductPaymentMethod() {
		return productPaymentMethod;
	}
	
	
	public void setProductPaymentMethod(Integer productPaymentMethod) {
		this.productPaymentMethod = productPaymentMethod;
	}
		 	@Column(name = "product_interest_amount_line")
	public BigDecimal getProductInterestAmountLine() {
		return productInterestAmountLine;
	}
	
	
	public void setProductInterestAmountLine(BigDecimal productInterestAmountLine) {
		this.productInterestAmountLine = productInterestAmountLine;
	}
		 	@Column(name = "repayment_bank")
	public String getRepaymentBank() {
		return repaymentBank;
	}
	
	
	public void setRepaymentBank(String repaymentBank) {
		this.repaymentBank = repaymentBank;
	}
		 	@Column(name = "repayment_card")
	public String getRepaymentCard() {
		return repaymentCard;
	}
	
	
	public void setRepaymentCard(String repaymentCard) {
		this.repaymentCard = repaymentCard;
	}
		 	@Column(name = "repayment_bank_name")
	public String getRepaymentBankName() {
		return repaymentBankName;
	}
	
	
	public void setRepaymentBankName(String repaymentBankName) {
		this.repaymentBankName = repaymentBankName;
	}
		 	@Column(name = "invest_amount")
	public BigDecimal getInvestAmount() {
		return investAmount;
	}
	
	
	public void setInvestAmount(BigDecimal investAmount) {
		this.investAmount = investAmount;
	}
		 	@Column(name = "comodato_num")
	public String getComodatoNum() {
		return comodatoNum;
	}
	
	
	public void setComodatoNum(String comodatoNum) {
		this.comodatoNum = comodatoNum;
	}
		 	@Column(name = "intercreditor_agreement")
	public String getIntercreditorAgreement() {
		return intercreditorAgreement;
	}
	
	
	public void setIntercreditorAgreement(String intercreditorAgreement) {
		this.intercreditorAgreement = intercreditorAgreement;
	}
		 	@Column(name = "invest_status")
	public Integer getInvestStatus() {
		return investStatus;
	}
	
	
	public void setInvestStatus(Integer investStatus) {
		this.investStatus = investStatus;
	}
		 	@Column(name = "undistributed_income")
	public BigDecimal getUndistributedIncome() {
		return undistributedIncome;
	}
	
	
	public void setUndistributedIncome(BigDecimal undistributedIncome) {
		this.undistributedIncome = undistributedIncome;
	}
		 	@Column(name = "distribution_income")
	public BigDecimal getDistributionIncome() {
		return distributionIncome;
	}
	
	
	public void setDistributionIncome(BigDecimal distributionIncome) {
		this.distributionIncome = distributionIncome;
	}
		 	@Column(name = "value_start_day")
	public Long getValueDay() {
		return valueDay;
	}
	
	
	public void setValueDay(Long valueDay) {
		this.valueDay = valueDay;
	}
		 	@Column(name = "value_end_day")
	public Long getValueEndDay() {
		return valueEndDay;
	}
	
	
	public void setValueEndDay(Long valueEndDay) {
		this.valueEndDay = valueEndDay;
	}
		 	@Column(name = "create_at")
	public Long getCreateAt() {
		return createAt;
	}
	
	
	public void setCreateAt(Long createAt) {
		this.createAt = createAt;
	}
		 	@Column(name = "create_by")
	public Long getCreateBy() {
		return createBy;
	}
	
	
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
		 	@Column(name = "update_at")
	public Long getUpdateAt() {
		return updateAt;
	}
	
	
	public void setUpdateAt(Long updateAt) {
		this.updateAt = updateAt;
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

