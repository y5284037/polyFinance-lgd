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
@Table(name = "module")
public class Module implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4997857132341599232L;	
	
		
   	 
    private  Long id;
	
  	 
    private  String moduleName;
	
  	 
    private  String url;
	
  	 
    private  Integer parentModuleId;
	
  	 
    private  String moduleType;
	
  	 
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
		 	@Column(name = "module_name")
	public String getModuleName() {
		return moduleName;
	}
	
	
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
		 	@Column(name = "url")
	public String getUrl() {
		return url;
	}
	
	
	public void setUrl(String url) {
		this.url = url;
	}
		 	@Column(name = "parent_module_id")
	public Integer getParentModuleId() {
		return parentModuleId;
	}
	
	
	public void setParentModuleId(Integer parentModuleId) {
		this.parentModuleId = parentModuleId;
	}
		 	@Column(name = "module_type")
	public String getModuleType() {
		return moduleType;
	}
	
	
	public void setModuleType(String moduleType) {
		this.moduleType = moduleType;
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

