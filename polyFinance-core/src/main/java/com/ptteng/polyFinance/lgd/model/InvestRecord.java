package com.ptteng.polyFinance.lgd.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "invest_record")
public class InvestRecord implements Serializable, Comparable<InvestRecord> {
    
    /**
     *
     */
    private static final long serialVersionUID = 2536605407075682304L;
    
    
    private Long id;
    
    
    private Long userId;
    
    
    private Long productId;
    
    
    private String productName;
    
    
    private BigDecimal productInterestRate;
    
    
    private Integer productPaymentMethod;
    
    
    private BigDecimal productInterestAmountLine;
    
    
    private String repaymentBank;
    
    
    private String repaymentCard;
    
    
    private String repaymentBankName;
    
    
    private BigDecimal investAmount;
    
    
    private String comodatoNum;
    
    
    private String intercreditorAgreement;
    
    
    private Integer investStatus;
    
    
    private BigDecimal undistributedIncome;
    
    
    private BigDecimal distributionIncome;
    
    
    private Long valueDay;
    
    
    private Long valueEndDay;
    
    
    private Long createAt;
    
    
    private Long createBy;
    
    
    private Long updateAt;
    
    
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
    
    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }
    
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    @Column(name = "product_id")
    public Long getProductId() {
        return productId;
    }
    
    
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    
    @Column(name = "product_name")
    public String getProductName() {
        return productName;
    }
    
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    @Column(name = "product_interest_rate")
    public BigDecimal getProductInterestRate() {
        return productInterestRate;
    }
    
    
    public void setProductInterestRate(BigDecimal productInterestRate) {
        this.productInterestRate = productInterestRate;
    }
    
    @Column(name = "product_payment_method")
    public Integer getProductPaymentMethod() {
        return productPaymentMethod;
    }
    
    
    public void setProductPaymentMethod(Integer productPaymentMethod) {
        this.productPaymentMethod = productPaymentMethod;
    }
    
    @Column(name = "product_interest_amount_line")
    public BigDecimal getProductInterestAmountLine() {
        return productInterestAmountLine;
    }
    
    
    public void setProductInterestAmountLine(BigDecimal productInterestAmountLine) {
        this.productInterestAmountLine = productInterestAmountLine;
    }
    
    @Column(name = "repayment_bank")
    public String getRepaymentBank() {
        return repaymentBank;
    }
    
    
    public void setRepaymentBank(String repaymentBank) {
        this.repaymentBank = repaymentBank;
    }
    
    @Column(name = "repayment_card")
    public String getRepaymentCard() {
        return repaymentCard;
    }
    
    
    public void setRepaymentCard(String repaymentCard) {
        this.repaymentCard = repaymentCard;
    }
    
    @Column(name = "repayment_bank_name")
    public String getRepaymentBankName() {
        return repaymentBankName;
    }
    
    
    public void setRepaymentBankName(String repaymentBankName) {
        this.repaymentBankName = repaymentBankName;
    }
    
    @Column(name = "invest_amount")
    public BigDecimal getInvestAmount() {
        return investAmount;
    }
    
    
    public void setInvestAmount(BigDecimal investAmount) {
        this.investAmount = investAmount;
    }
    
    @Column(name = "comodato_num")
    public String getComodatoNum() {
        return comodatoNum;
    }
    
    
    public void setComodatoNum(String comodatoNum) {
        this.comodatoNum = comodatoNum;
    }
    
    @Column(name = "intercreditor_agreement")
    public String getIntercreditorAgreement() {
        return intercreditorAgreement;
    }
    
    
    public void setIntercreditorAgreement(String intercreditorAgreement) {
        this.intercreditorAgreement = intercreditorAgreement;
    }
    
    @Column(name = "invest_status")
    public Integer getInvestStatus() {
        return investStatus;
    }
    
    
    public void setInvestStatus(Integer investStatus) {
        this.investStatus = investStatus;
    }
    
    @Column(name = "undistributed_income")
    public BigDecimal getUndistributedIncome() {
        return undistributedIncome;
    }
    
    
    public void setUndistributedIncome(BigDecimal undistributedIncome) {
        this.undistributedIncome = undistributedIncome;
    }
    
    @Column(name = "distribution_income")
    public BigDecimal getDistributionIncome() {
        return distributionIncome;
    }
    
    
    public void setDistributionIncome(BigDecimal distributionIncome) {
        this.distributionIncome = distributionIncome;
    }
    
    @Column(name = "value_start_day")
    public Long getValueDay() {
        return valueDay;
    }
    
    
    public void setValueDay(Long valueDay) {
        this.valueDay = valueDay;
    }
    
    @Column(name = "value_end_day")
    public Long getValueEndDay() {
        return valueEndDay;
    }
    
    
    public void setValueEndDay(Long valueEndDay) {
        this.valueEndDay = valueEndDay;
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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvestRecord)) return false;
        
        InvestRecord that = (InvestRecord) o;
        
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (productId != null ? !productId.equals(that.productId) : that.productId != null) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (productInterestRate != null ? !productInterestRate.equals(that.productInterestRate) : that.productInterestRate != null)
            return false;
        if (productPaymentMethod != null ? !productPaymentMethod.equals(that.productPaymentMethod) : that.productPaymentMethod != null)
            return false;
        if (productInterestAmountLine != null ? !productInterestAmountLine.equals(that.productInterestAmountLine) : that.productInterestAmountLine != null)
            return false;
        if (repaymentBank != null ? !repaymentBank.equals(that.repaymentBank) : that.repaymentBank != null)
            return false;
        if (repaymentCard != null ? !repaymentCard.equals(that.repaymentCard) : that.repaymentCard != null)
            return false;
        if (repaymentBankName != null ? !repaymentBankName.equals(that.repaymentBankName) : that.repaymentBankName != null)
            return false;
        if (investAmount != null ? !investAmount.equals(that.investAmount) : that.investAmount != null) return false;
        if (comodatoNum != null ? !comodatoNum.equals(that.comodatoNum) : that.comodatoNum != null) return false;
        if (intercreditorAgreement != null ? !intercreditorAgreement.equals(that.intercreditorAgreement) : that.intercreditorAgreement != null)
            return false;
        if (investStatus != null ? !investStatus.equals(that.investStatus) : that.investStatus != null) return false;
        if (undistributedIncome != null ? !undistributedIncome.equals(that.undistributedIncome) : that.undistributedIncome != null)
            return false;
        if (distributionIncome != null ? !distributionIncome.equals(that.distributionIncome) : that.distributionIncome != null)
            return false;
        if (valueDay != null ? !valueDay.equals(that.valueDay) : that.valueDay != null) return false;
        if (valueEndDay != null ? !valueEndDay.equals(that.valueEndDay) : that.valueEndDay != null) return false;
        if (createAt != null ? !createAt.equals(that.createAt) : that.createAt != null) return false;
        if (createBy != null ? !createBy.equals(that.createBy) : that.createBy != null) return false;
        if (updateAt != null ? !updateAt.equals(that.updateAt) : that.updateAt != null) return false;
        return updateBy != null ? updateBy.equals(that.updateBy) : that.updateBy == null;
    }
    
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productInterestRate != null ? productInterestRate.hashCode() : 0);
        result = 31 * result + (productPaymentMethod != null ? productPaymentMethod.hashCode() : 0);
        result = 31 * result + (productInterestAmountLine != null ? productInterestAmountLine.hashCode() : 0);
        result = 31 * result + (repaymentBank != null ? repaymentBank.hashCode() : 0);
        result = 31 * result + (repaymentCard != null ? repaymentCard.hashCode() : 0);
        result = 31 * result + (repaymentBankName != null ? repaymentBankName.hashCode() : 0);
        result = 31 * result + (investAmount != null ? investAmount.hashCode() : 0);
        result = 31 * result + (comodatoNum != null ? comodatoNum.hashCode() : 0);
        result = 31 * result + (intercreditorAgreement != null ? intercreditorAgreement.hashCode() : 0);
        result = 31 * result + (investStatus != null ? investStatus.hashCode() : 0);
        result = 31 * result + (undistributedIncome != null ? undistributedIncome.hashCode() : 0);
        result = 31 * result + (distributionIncome != null ? distributionIncome.hashCode() : 0);
        result = 31 * result + (valueDay != null ? valueDay.hashCode() : 0);
        result = 31 * result + (valueEndDay != null ? valueEndDay.hashCode() : 0);
        result = 31 * result + (createAt != null ? createAt.hashCode() : 0);
        result = 31 * result + (createBy != null ? createBy.hashCode() : 0);
        result = 31 * result + (updateAt != null ? updateAt.hashCode() : 0);
        result = 31 * result + (updateBy != null ? updateBy.hashCode() : 0);
        return result;
    }
    
    @Override
    public int compareTo(InvestRecord o) {
        if (this.getId() - o.getId() > 0) {
            return 1;
        } else if (this.getId() - o.getId() < 0) {
            return 1;
        }
        return 0;
    }
}

