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
@Table(name = "debtor_match")
public class DebtorMatch implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5363497859118239744L;	
	
		
   	 
    private  Long id;
	
  	 
    private  Long debtorId;
	
  	 
    private  String comodatoNum;
	
  	 
    private  String intercreditorAgreement;
	
  	 
    private  String name;
	
  	 
    private  String productName;
	
  	 
    private  Long valueDay;
	
  	 
    private  Long valueEndDay;
	
  	 
    private BigDecimal investAmount;
	
  	 
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
		 	@Column(name = "debtor_id")
	public Long getDebtorId() {
		return debtorId;
	}
	
	
	public void setDebtorId(Long debtorId) {
		this.debtorId = debtorId;
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
		 	@Column(name = "name")
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
		 	@Column(name = "product_name")
	public String getProductName() {
		return productName;
	}
	
	
	public void setProductName(String productName) {
		this.productName = productName;
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
		 	@Column(name = "invest_amount")
	public BigDecimal getInvestAmount() {
		return investAmount;
	}
	
	
	public void setInvestAmount(BigDecimal investAmount) {
		this.investAmount = investAmount;
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

