package com.ptteng.polyFinance.lgd.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "bank_list")
public class BankList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7892906505496148992L;	
	
		
   	 
    private  Long id;
	
  	 
    private  String name;
	
  	 
    private  String paymentAgencyNumber;
	
  	 
    private  String withdrawAgencyNumber;
	
  	 
    private  String singleTransactionLimit;
	
  	 
    private  String dailyLimit;
	
  	 
    private  String logoPic;
	
  	 
    private  Long createAt;
	
  	 
    private  Long updateAt;
	
  	 
    private  String createBy;
	
  	 
    private  String updateBy;
	
  
	
		 	
         	 	   @Id
     	   @GeneratedValue(strategy = GenerationType.AUTO)
              	@Column(name = "id")
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
		 	@Column(name = "name")
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
		 	@Column(name = "payment_agency_number")
	public String getPaymentAgencyNumber() {
		return paymentAgencyNumber;
	}
	
	
	public void setPaymentAgencyNumber(String paymentAgencyNumber) {
		this.paymentAgencyNumber = paymentAgencyNumber;
	}
		 	@Column(name = "withdraw_agency_number")
	public String getWithdrawAgencyNumber() {
		return withdrawAgencyNumber;
	}
	
	
	public void setWithdrawAgencyNumber(String withdrawAgencyNumber) {
		this.withdrawAgencyNumber = withdrawAgencyNumber;
	}
		 	@Column(name = "single_transaction_limit")
	public String getSingleTransactionLimit() {
		return singleTransactionLimit;
	}
	
	
	public void setSingleTransactionLimit(String singleTransactionLimit) {
		this.singleTransactionLimit = singleTransactionLimit;
	}
		 	@Column(name = "daily_limit")
	public String getDailyLimit() {
		return dailyLimit;
	}
	
	
	public void setDailyLimit(String dailyLimit) {
		this.dailyLimit = dailyLimit;
	}
		 	@Column(name = "logo_pic")
	public String getLogoPic() {
		return logoPic;
	}
	
	
	public void setLogoPic(String logoPic) {
		this.logoPic = logoPic;
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
	public String getCreateBy() {
		return createBy;
	}
	
	
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
		 	@Column(name = "update_by")
	public String getUpdateBy() {
		return updateBy;
	}
	
	
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}

