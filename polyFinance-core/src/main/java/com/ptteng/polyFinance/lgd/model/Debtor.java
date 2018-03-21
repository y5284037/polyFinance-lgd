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
@Table(name = "debtor")
public class Debtor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6016162318357393408L;	
	
		
   	 
    private  Long id;
	
  	 
    private  String debtorMark;
	
  	 
    private  String debtorName;
	
  	 
    private  String debtorPhone;
	
  	 
    private  String debtorIDcard;
	
  	 
    private  Integer expires;
	
  	 
    private  Long debtStartTime;
	
  	 
    private  Long debtEndTime;
	
  	 
    private BigDecimal amount;
	
  	 
    private  BigDecimal debtorInvest;
	
  	 
    private  Integer status;
	
  	 
    private  BigDecimal matchedAmount;
	
  	 
    private  String remark;
	
  	 
    private  String nature;
	
  	 
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
		 	@Column(name = "debtor_mark")
	public String getDebtorMark() {
		return debtorMark;
	}
	
	
	public void setDebtorMark(String debtorMark) {
		this.debtorMark = debtorMark;
	}
		 	@Column(name = "debtor_name")
	public String getDebtorName() {
		return debtorName;
	}
	
	
	public void setDebtorName(String debtorName) {
		this.debtorName = debtorName;
	}
		 	@Column(name = "debtor_phone")
	public String getDebtorPhone() {
		return debtorPhone;
	}
	
	
	public void setDebtorPhone(String debtorPhone) {
		this.debtorPhone = debtorPhone;
	}
		 	@Column(name = "debtor_IDcard")
	public String getDebtorIDcard() {
		return debtorIDcard;
	}
	
	
	public void setDebtorIDcard(String debtorIDcard) {
		this.debtorIDcard = debtorIDcard;
	}
		 	@Column(name = "expires")
	public Integer getExpires() {
		return expires;
	}
	
	
	public void setExpires(Integer expires) {
		this.expires = expires;
	}
		 	@Column(name = "debt_start_time")
	public Long getDebtStartTime() {
		return debtStartTime;
	}
	
	
	public void setDebtStartTime(Long debtStartTime) {
		this.debtStartTime = debtStartTime;
	}
		 	@Column(name = "debt_end_time")
	public Long getDebtEndTime() {
		return debtEndTime;
	}
	
	
	public void setDebtEndTime(Long debtEndTime) {
		this.debtEndTime = debtEndTime;
	}
		 	@Column(name = "amount")
	public BigDecimal getAmount() {
		return amount;
	}
	
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
		 	@Column(name = "debtor_invest")
	public BigDecimal getDebtorInvest() {
		return debtorInvest;
	}
	
	
	public void setDebtorInvest(BigDecimal debtorInvest) {
		this.debtorInvest = debtorInvest;
	}
		 	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}
	
	
	public void setStatus(Integer status) {
		this.status = status;
	}
		 	@Column(name = "matched_amount")
	public BigDecimal getMatchedAmount() {
		return matchedAmount;
	}
	
	
	public void setMatchedAmount(BigDecimal matchedAmount) {
		this.matchedAmount = matchedAmount;
	}
		 	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}
	
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
		 	@Column(name = "nature")
	public String getNature() {
		return nature;
	}
	
	
	public void setNature(String nature) {
		this.nature = nature;
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

