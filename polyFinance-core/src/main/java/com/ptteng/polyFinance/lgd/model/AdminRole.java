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
@Table(name = "admin_role")
public class AdminRole implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3247931685044680704L;	
	
		
   	 
    private  Long id;
	
  	 
    private  String roleName;
	
  	 
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
		 	@Column(name = "role_name")
	public String getRoleName() {
		return roleName;
	}
	
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
	
	
	public void setCreateBy(String  createBy) {
		this.createBy = createBy;
	}
		 	@Column(name = "update_by")
	public String  getUpdateBy() {
		return updateBy;
	}
	
	
	public void setUpdateBy(String  updateBy) {
		this.updateBy = updateBy;
	}
		
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

}

