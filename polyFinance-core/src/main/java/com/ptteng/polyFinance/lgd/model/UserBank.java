package com.ptteng.polyFinance.lgd.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "user_bank")
public class UserBank implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3721719621745458176L;	
	
		
   	 
    private  Long id;
	
  	 
    private  String city;
	
  	 
    private  Long bankListId;
	
  	 
    private  String bankName;
	
  	 
    private  String cardNo;
	
  	 
    private  String bankPhone;
	
  	 
    private  Long userId;
	
  	 
    private  Integer first;
	
  	 
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
		 	@Column(name = "city")
	public String getCity() {
		return city;
	}
	
	
	public void setCity(String city) {
		this.city = city;
	}
		 	@Column(name = "bank_list_id")
	public Long getBankListId() {
		return bankListId;
	}
	
	
	public void setBankListId(Long bankListId) {
		this.bankListId = bankListId;
	}
		 	@Column(name = "bank_name")
	public String getBankName() {
		return bankName;
	}
	
	
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
		 	@Column(name = "card_no")
	public String getCardNo() {
		return cardNo;
	}
	
	
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
		 	@Column(name = "bank_phone")
	public String getBankPhone() {
		return bankPhone;
	}
	
	
	public void setBankPhone(String bankPhone) {
		this.bankPhone = bankPhone;
	}
		 	@Column(name = "user_id")
	public Long getUserId() {
		return userId;
	}
	
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
		 	@Column(name = "first")
	public Integer getFirst() {
		return first;
	}
	
	
	public void setFirst(Integer first) {
		this.first = first;
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

