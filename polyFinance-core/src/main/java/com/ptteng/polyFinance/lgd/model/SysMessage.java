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
@Table(name = "sys_message")
public class SysMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7336375986260127744L;	
	
		
   	 
    private  Long id;
	
  	 
    private  String title;
	
  	 
    private  Integer status;
	
  	 
    private  String resume;
	
  	 
    private  String messagePic;
	
  	 
    private  String messageType;
	
  	 
    private  Integer sendType;
	
  	 
    private  Long sendTime;
	
  	 
    private  Integer sendTo;
	
  	 
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
		 	@Column(name = "title")
	public String getTitle() {
		return title;
	}
	
	
	public void setTitle(String title) {
		this.title = title;
	}
		 	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}
	
	
	public void setStatus(Integer status) {
		this.status = status;
	}
		 	@Column(name = "resume")
	public String getResume() {
		return resume;
	}
	
	
	public void setResume(String resume) {
		this.resume = resume;
	}
		 	@Column(name = "message_pic")
	public String getMessagePic() {
		return messagePic;
	}
	
	
	public void setMessagePic(String messagePic) {
		this.messagePic = messagePic;
	}
		 	@Column(name = "message_type")
	public String getMessageType() {
		return messageType;
	}
	
	
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
		 	@Column(name = "send_type")
	public Integer getSendType() {
		return sendType;
	}
	
	
	public void setSendType(Integer sendType) {
		this.sendType = sendType;
	}
		 	@Column(name = "send_time")
	public Long getSendTime() {
		return sendTime;
	}
	
	
	public void setSendTime(Long sendTime) {
		this.sendTime = sendTime;
	}
		 	@Column(name = "send_to")
	public Integer getSendTo() {
		return sendTo;
	}
	
	
	public void setSendTo(Integer sendTo) {
		this.sendTo = sendTo;
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

