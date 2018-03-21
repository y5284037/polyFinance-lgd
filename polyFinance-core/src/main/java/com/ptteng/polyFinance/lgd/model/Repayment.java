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
@Table(name = "repayment")
public class Repayment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2692904298731237376L;	
	
		
   	 
    private  Long id;
	
  	 
    private  Long userId;
	
  	 
    private  Long investRecordId;
	
  	 
    private  Long repaymentDate;
	
  	 
    private BigDecimal repaymentAmount;
	
  	 
    private  Integer moneyType;
	
  	 
    private  Integer repaymentStatus;
	
  	 
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
		 	@Column(name = "invest_record_id")
	public Long getInvestRecordId() {
		return investRecordId;
	}
	
	
	public void setInvestRecordId(Long investRecordId) {
		this.investRecordId = investRecordId;
	}
		 	@Column(name = "repayment_date")
	public Long getRepaymentDate() {
		return repaymentDate;
	}
	
	
	public void setRepaymentDate(Long repaymentDate) {
		this.repaymentDate = repaymentDate;
	}
		 	@Column(name = "repayment_amount")
	public BigDecimal getRepaymentAmount() {
		return repaymentAmount;
	}
	
	
	public void setRepaymentAmount(BigDecimal repaymentAmount) {
		this.repaymentAmount = repaymentAmount;
	}
		 	@Column(name = "money_type")
	public Integer getMoneyType() {
		return moneyType;
	}
	
	
	public void setMoneyType(Integer moneyType) {
		this.moneyType = moneyType;
	}
		 	@Column(name = "repayment_status")
	public Integer getRepaymentStatus() {
		return repaymentStatus;
	}
	
	
	public void setRepaymentStatus(Integer repaymentStatus) {
		this.repaymentStatus = repaymentStatus;
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

