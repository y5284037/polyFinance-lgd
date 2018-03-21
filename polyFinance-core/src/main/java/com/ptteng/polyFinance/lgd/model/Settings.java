package com.ptteng.polyFinance.lgd.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "settings")
public class Settings implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3309439862404482048L;	
	
		
   	 
    private  Long id;
	
  	 
    private  String companyChop;
	
  	 
    private  Integer invsetExpireWarn;
	
  	 
    private  Integer daysBeforeMaturity;
	
  	 
    private  Integer investFullLine;
	
  	 
    private  Integer status;
	
  	 
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
		 	@Column(name = "company_chop")
	public String getCompanyChop() {
		return companyChop;
	}
	
	
	public void setCompanyChop(String companyChop) {
		this.companyChop = companyChop;
	}
		 	@Column(name = "invset_expire_warn")
	public Integer getInvsetExpireWarn() {
		return invsetExpireWarn;
	}
	
	
	public void setInvsetExpireWarn(Integer invsetExpireWarn) {
		this.invsetExpireWarn = invsetExpireWarn;
	}
		 	@Column(name = "days_before_maturity")
	public Integer getDaysBeforeMaturity() {
		return daysBeforeMaturity;
	}
	
	
	public void setDaysBeforeMaturity(Integer daysBeforeMaturity) {
		this.daysBeforeMaturity = daysBeforeMaturity;
	}
		 	@Column(name = "invest_full_line")
	public Integer getInvestFullLine() {
		return investFullLine;
	}
	
	
	public void setInvestFullLine(Integer investFullLine) {
		this.investFullLine = investFullLine;
	}
		 	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}
	
	
	public void setStatus(Integer status) {
		this.status = status;
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

