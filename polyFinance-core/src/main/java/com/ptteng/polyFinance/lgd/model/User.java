package com.ptteng.polyFinance.lgd.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name = "user")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 140675531287703552L;	
	
		
   	 
    private  Long id;
	
  	 
    private  String serialNum;
	
  	 
    private  String phoneNum;
	
  	 
    private  String pswd;
	
  	 
    private  String salt;
	
  	 
    private  String managerNum;
	
  	 
    private  String name;
	
  	 
    private BigDecimal totalProperty;
	
  	 
    private  BigDecimal income;
	
  	 
    private  Integer accountsStatus;
	
  	 
    private  String address;
	
  	 
    private  String email;
	
  	 
    private  String idCardFornt;
	
  	 
    private  String idCardBack;
	
  	 
    private  String idCard;
	
  	 
    private  Integer identityStatus;
	
  	 
    private  String refuseReason;
	
  	 
    private  Integer refuseStatus;
	
  	 
    private  Long identityTime;
	
  	 
    private  Long userBankId;
	
  	 
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
		 	@Column(name = "serial_num")
	public String getSerialNum() {
		return serialNum;
	}
	
	
	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}
		 	@Column(name = "phone_num")
	public String getPhoneNum() {
		return phoneNum;
	}
	
	
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
		 	@Column(name = "pswd")
	public String getPswd() {
		return pswd;
	}
	
	
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
		 	@Column(name = "salt")
	public String getSalt() {
		return salt;
	}
	
	
	public void setSalt(String salt) {
		this.salt = salt;
	}
		 	@Column(name = "manager_num")
	public String getManagerNum() {
		return managerNum;
	}
	
	
	public void setManagerNum(String managerNum) {
		this.managerNum = managerNum;
	}
		 	@Column(name = "name")
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
		 	@Column(name = "total_property")
	public BigDecimal getTotalProperty() {
		return totalProperty;
	}
	
	
	public void setTotalProperty(BigDecimal totalProperty) {
		this.totalProperty = totalProperty;
	}
		 	@Column(name = "income")
	public BigDecimal getIncome() {
		return income;
	}
	
	
	public void setIncome(BigDecimal income) {
		this.income = income;
	}
		 	@Column(name = "accounts_status")
	public Integer getAccountsStatus() {
		return accountsStatus;
	}
	
	
	public void setAccountsStatus(Integer accountsStatus) {
		this.accountsStatus = accountsStatus;
	}
		 	@Column(name = "address")
	public String getAddress() {
		return address;
	}
	
	
	public void setAddress(String address) {
		this.address = address;
	}
		 	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
		 	@Column(name = "idCard_fornt")
	public String getIdCardFornt() {
		return idCardFornt;
	}
	
	
	public void setIdCardFornt(String idCardFornt) {
		this.idCardFornt = idCardFornt;
	}
		 	@Column(name = "idCard_back")
	public String getIdCardBack() {
		return idCardBack;
	}
	
	
	public void setIdCardBack(String idCardBack) {
		this.idCardBack = idCardBack;
	}
		 	@Column(name = "idCard")
	public String getIdCard() {
		return idCard;
	}
	
	
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
		 	@Column(name = "identity_status")
	public Integer getIdentityStatus() {
		return identityStatus;
	}
	
	
	public void setIdentityStatus(Integer identityStatus) {
		this.identityStatus = identityStatus;
	}
		 	@Column(name = "refuse_reason")
	public String getRefuseReason() {
		return refuseReason;
	}
	
	
	public void setRefuseReason(String refuseReason) {
		this.refuseReason = refuseReason;
	}
		 	@Column(name = "refuse_status")
	public Integer getRefuseStatus() {
		return refuseStatus;
	}
	
	
	public void setRefuseStatus(Integer refuseStatus) {
		this.refuseStatus = refuseStatus;
	}
		 	@Column(name = "identity_time")
	public Long getIdentityTime() {
		return identityTime;
	}
	
	
	public void setIdentityTime(Long identityTime) {
		this.identityTime = identityTime;
	}
		 	@Column(name = "user_bank_id")
	public Long getUserBankId() {
		return userBankId;
	}
	
	
	public void setUserBankId(Long userBankId) {
		this.userBankId = userBankId;
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

