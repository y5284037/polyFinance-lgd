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
@Table(name = "admin")
public class Admin implements Serializable {
    
    /**
     *
     */
    private static final long serialVersionUID = 4486567715635443712L;
    
    
    private Long id;
    
    
    private String loginName;
    
    
    private Long adminRoleId;
    
    
    private String pswd;
    
    
    private String salt;
    
    
    private Long createAt;
    
    
    private Long updateAt;
    
    
    private Long createBy;
    
    
    private Long updateBy;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getId() {
        return id;
    }
    
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name = "login_name")
    public String getLoginName() {
        return loginName;
    }
    
    
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    
    @Column(name = "admin_role_id")
    public Long getAdminRoleId() {
        return adminRoleId;
    }
    
    
    public void setAdminRoleId(Long adminRoleId) {
        this.adminRoleId = adminRoleId;
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

