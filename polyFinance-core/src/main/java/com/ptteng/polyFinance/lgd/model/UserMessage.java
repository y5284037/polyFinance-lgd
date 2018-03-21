package com.ptteng.polyFinance.lgd.model;

import java.io.Serializable;
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
@Table(name = "user_message")
public class UserMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5353189301360012288L;	
	
		
   	 
    private  Long id;
	
  	 
    private  Long userId;
	
  	 
    private  Integer messageType;
	
  	 
    private  Integer messageReadStatus;
	
  	 
    private  Long investRecordId;
	
  	 
    private  String content;
	
  	 
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
		 	@Column(name = "message_type")
	public Integer getMessageType() {
		return messageType;
	}
	
	
	public void setMessageType(Integer messageType) {
		this.messageType = messageType;
	}
		 	@Column(name = "message_read_status")
	public Integer getMessageReadStatus() {
		return messageReadStatus;
	}
	
	
	public void setMessageReadStatus(Integer messageReadStatus) {
		this.messageReadStatus = messageReadStatus;
	}
		 	@Column(name = "invest_record_id")
	public Long getInvestRecordId() {
		return investRecordId;
	}
	
	
	public void setInvestRecordId(Long investRecordId) {
		this.investRecordId = investRecordId;
	}
		 	@Column(name = "content")
	public String getContent() {
		return content;
	}
	
	
	public void setContent(String content) {
		this.content = content;
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

