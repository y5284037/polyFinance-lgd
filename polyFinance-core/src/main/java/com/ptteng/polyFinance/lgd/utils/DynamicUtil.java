package com.ptteng.polyFinance.lgd.utils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lujing
 * Create_at 2018/3/17 11:07
 */
public class DynamicUtil {
    /**
     * 用户列表动态查询
     *
     * @param name           姓名
     * @param phoneNum       手机号
     * @param accountsStatus 账户状态
     * @param createAtStart  注册日期起
     * @param createAtEnd    注册日期止
     * @param managerNum     理财经理
     * @return 拼接的查询条件
     */
    public static Map<String, Object> getUserListSql(String name, String phoneNum, Integer accountsStatus, Long createAtStart, Long createAtEnd, String managerNum) {
        Map<String, Object> param = new HashMap<>();
        
        if (name != null && !name.equals("")) {
            param.put("name & like", "'%" + name + "%'");
        }
        if (phoneNum != null && !phoneNum.equals("")) {
            param.put("phone_num & like", "'%" + phoneNum + "%'");
        }
        
        if (accountsStatus != null && !accountsStatus.equals("")) {
            param.put("accounts_status & like", "'%" + accountsStatus + "%'");
        }
        if (createAtStart != null && !createAtStart.equals("")) {
            param.put("create_at & >=", createAtStart);
        }
        if (createAtEnd != null && !createAtEnd.equals("")) {
            param.put("create_at & <=", createAtEnd);
        }
        if (managerNum != null && !managerNum.equals("")) {
            param.put("manager_num & like", "'%" + managerNum + "%'");
        }
        
        param.put("@table", "user");
        param.put("@order", "create_at desc");
        return param;
    }
    
    
    /**
     * @param name                      产品名称
     * @param interestAmountLine        起投金额
     * @param productMark               产品代号
     * @param interestDelayed           起息日期
     * @param productStatus             产品状态
     * @param interestRateStart         年化收益下限
     * @param interestRatrateEnd        年化收益上限
     * @param financialPeriodDayStart   期限下限(日)
     * @param financialPeriodDayEnd     期限上限(日)
     * @param financialPeriodMonthStart 期限下限(月)
     * @param financialPeriodMonthEnd   期限上限(月)
     * @return 返回用于拼接SQL的Map集合.
     */
    public static Map<String, Object> getProductListSqlMap(String name, BigDecimal interestAmountLine, String productMark, Integer interestDelayed, Integer productStatus, BigDecimal interestRateStart, BigDecimal interestRatrateEnd, Integer financialPeriodDayStart, Integer financialPeriodDayEnd, Integer financialPeriodMonthStart, Integer financialPeriodMonthEnd) {
        Map<String, Object> param = new HashMap<>();
        if (!CommonUtil.isEmpty(name)) {
            param.put("name & like", " '%" + name + "%'");
        }
        if (!CommonUtil.isEmpty(interestAmountLine)) {
            param.put("interest_amount_line & >=", interestAmountLine);
        }
        if (!CommonUtil.isEmpty(productMark)) {
            param.put("product_mark & =", " '" + productMark + "'");
        }
        if (!CommonUtil.isEmpty(interestDelayed)) {
            param.put("interest_delayed & =", interestDelayed);
        }
        if (!CommonUtil.isEmpty(productStatus)) {
            param.put("product_status & =", productStatus);
        }
        if (!CommonUtil.isEmpty(interestRateStart)) {
            param.put("interest_rate & >=", interestRateStart);
        }
        if (!CommonUtil.isEmpty(interestRatrateEnd)) {
            param.put("interest_rate & <=", interestRatrateEnd);
        }
        if (!CommonUtil.isEmpty(financialPeriodDayStart)) {
            param.put("financial_period_day & >=", financialPeriodDayStart);
        }
        if (!CommonUtil.isEmpty(financialPeriodDayEnd)) {
            param.put("financial_period_day & <=", financialPeriodDayEnd);
        }
        if (!CommonUtil.isEmpty(financialPeriodMonthStart)) {
            param.put("financial_period_month & >=", financialPeriodMonthStart);
        }
        if (!CommonUtil.isEmpty(financialPeriodMonthEnd)) {
            param.put("financial_period_month & <=", financialPeriodMonthEnd);
        }
        
        
        param.put("@table", "product");
        param.put("@order", "create_at desc");
        return param;
    }
    
    /**
     * 动态查询用户实名列表
     *
     * @param name              用户姓名
     * @param phoneNum          用户编号
     * @param identityStatus    用户实名状态
     * @param identityTimeStart 实名时间起
     * @param identityTimeEnd   实名时间止
     * @param serialNum         用户编号
     * @return
     */
    public static Map<String, Object> getUserIdentifyList(String name, String phoneNum, Integer identityStatus, Long identityTimeStart, Long identityTimeEnd, String serialNum) {
        
        Map<String, Object> param = new HashMap<>();
        if (!CommonUtil.isEmpty(phoneNum)) {
            param.put("phone_num & like", "'%" + phoneNum + "%'");
        }
        if (!CommonUtil.isEmpty(name)) {
            param.put("name & like", "'%" + name + "%'");
        }
        if (!CommonUtil.isEmpty(identityStatus)) {
            param.put("identity_status & like", "'%" + identityStatus + "%'");
        }
        if (!CommonUtil.isEmpty(serialNum)) {
            param.put("serial_num & like", "'%" + serialNum + "%'");
        }
        if (!CommonUtil.isEmpty(identityTimeStart)) {
            param.put("identity_time & >=", identityTimeStart);
        }
        if (!CommonUtil.isEmpty(identityTimeEnd)) {
            param.put("identity_time & <=", identityTimeEnd);
        }
        
        param.put("@table", "user");
        param.put("@order", "identity_time desc");
        return param;
    }
    
    /**
     * 动态SQL:动态查询用户的交易记录
     *
     * @param userId         用户id
     * @param productName    产品名称
     * @param tradingType    交易类型
     * @param tradeDateStart 交易时间起
     * @param tradeDateEnd   交易时间止
     * @param tradingStatus  交易状态
     * @return
     */
    public static Map<String, Object> getUserTradingRecord(Long userId, String productName, String tradingType, String tradeDateStart, String tradeDateEnd, String tradingStatus) {
        Map<String, Object> param = new HashMap<>();
        if (!CommonUtil.isEmpty(productName)) {
            param.put("product_name & like", "'%" + productName + "%'");
        }
        if (!CommonUtil.isEmpty(tradingType)) {
            param.put("trading_type & like", "'%" + tradingType + "%'");
        }
        if (!CommonUtil.isEmpty(tradingStatus)) {
            param.put("trading_status & like", "'%" + tradingStatus + "%'");
        }
        if (!CommonUtil.isEmpty(tradeDateStart)) {
            param.put("trading_time & >=", tradeDateStart);
        }
        if (!CommonUtil.isEmpty(tradeDateEnd)) {
            param.put("trading_time & <=", tradeDateEnd);
        }
        
        param.put("@table", "trading_record");
        param.put("@order", "trading_time desc");
        param.put("user_id & =", userId);
        return param;
    }
    
    public static Map<String, Object> getUserInvestRecord(Long userId, String productName, Long valueDayStart, Long valueDayEnd, Long valueEndDayStart, Long valueEndDayEnd, Integer investStatus, String comodatoNum, String intercreditorAgreement) {
        
        Map<String, Object> param = new HashMap<>();
        if (!CommonUtil.isEmpty(productName)) {
            param.put("product_name & like", "'%" + productName + "%'");
        }
        if (!CommonUtil.isEmpty(investStatus)) {
            param.put("invest_status & like", "'%" + investStatus + "%'");
        }
        if (!CommonUtil.isEmpty(comodatoNum)) {
            param.put("comodato_num & like", "'%" + comodatoNum + "%'");
        }
        if (!CommonUtil.isEmpty(intercreditorAgreement)) {
            param.put("intercreditor_agreement & like", "'%" + intercreditorAgreement + "%'");
        }
        if (!CommonUtil.isEmpty(valueDayStart)) {
            param.put("value_start_day & >=", "'%" + valueDayStart + "%'");
        }
        if (!CommonUtil.isEmpty(valueDayEnd)) {
            param.put("value_start_day & <=", "'%" + valueDayEnd + "%'");
        }
        if (!CommonUtil.isEmpty(valueEndDayStart)) {
            param.put("value_end_day & >=", valueEndDayStart);
        }
        if (!CommonUtil.isEmpty(valueEndDayEnd)) {
            param.put("value_end_day & <=", valueEndDayEnd);
        }
        
        param.put("@table", "invest_record");
        param.put("@order", "value_start_day desc");
        param.put("user_id & =", userId);
        return param;
        
    }
    
    public static Map<String, Object> getBanklistList(String name, String updateBy, Long updateAtStart, Long updateAtEnd, String singleTransactionLimitStart, String singleTransactionLimitEnd, String dailyLimitStart, String dailyLimitEnd) {
        
        Map<String, Object> param = new HashMap<>();
        if (!CommonUtil.isEmpty(name)) {
            param.put("name & like", "'%" + name + "%'");
        }
        if (!CommonUtil.isEmpty(updateBy)) {
            param.put("update_by & like", "'%" + updateBy + "%'");
        }
        if (!CommonUtil.isEmpty(updateAtStart)) {
            param.put("update_at & >=", "'%" + updateAtStart + "%'");
        }
        if (!CommonUtil.isEmpty(updateAtEnd)) {
            param.put("update_at & <=", "'%" + updateAtEnd + "%'");
        }
        if (!CommonUtil.isEmpty(singleTransactionLimitStart)) {
            param.put("single_transaction_limit& >=", "'%" + singleTransactionLimitStart + "%'");
        }
        if (!CommonUtil.isEmpty(singleTransactionLimitEnd)) {
            param.put("single_transaction_limit& <=", "'%" + singleTransactionLimitEnd + "%'");
        }
        
        if (!CommonUtil.isEmpty(dailyLimitStart)) {
            param.put("daily_limit& >=", "'%" + dailyLimitStart + "%'");
        }
        if (!CommonUtil.isEmpty(dailyLimitEnd)) {
            param.put("daily_limit& <=", "'%" + dailyLimitEnd + "%'");
        }
        param.put("@table", "bank_list");
        param.put("@order", "create_at desc");
        
        return param;
        
    }
    
}
    

