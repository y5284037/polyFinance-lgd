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
    
}
    

