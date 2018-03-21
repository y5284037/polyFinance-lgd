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
@Table(name = "sys_message_readed")
public class SysMessageReaded implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7023169942387414016L;	
	
		
   	 
    private  Long id;
	
  	 
    private  Long userId;
	
  	 
    private  Long sysMessageId;
	
  	 
    private  Long createAt;
	
  	 
    private  Long createBy;
	
  	 
    private  Integer readStatus;
	
  	 
    private  Integer deleteStatus;
	
  	 
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
		 	@Column(name = "sys_message_id")
	public Long getSysMessageId() {
		return sysMessageId;
	}
	
	
	public void setSysMessageId(Long sysMessageId) {
		this.sysMessageId = sysMessageId;
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
		 	@Column(name = "read_status")
	public Integer getReadStatus() {
		return readStatus;
	}
	
	
	public void setReadStatus(Integer readStatus) {
		this.readStatus = readStatus;
	}
		 	@Column(name = "delete_status")
	public Integer getDeleteStatus() {
		return deleteStatus;
	}
	
	
	public void setDeleteStatus(Integer deleteStatus) {
		this.deleteStatus = deleteStatus;
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

