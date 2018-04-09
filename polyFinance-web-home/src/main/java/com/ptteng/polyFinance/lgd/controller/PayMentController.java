package com.ptteng.polyFinance.lgd.controller;


import cn.jpush.api.report.UsersResult;
import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.polyFinance.lgd.model.*;
import com.ptteng.polyFinance.lgd.payutil.ConfigReader;
import com.ptteng.polyFinance.lgd.payutil.DateTimeUtil;
import com.ptteng.polyFinance.lgd.payutil.HttpFormUtil;
import com.ptteng.polyFinance.lgd.payutil.fuiou.HttpPay;
import com.ptteng.polyFinance.lgd.payutil.fuiou.HttpPayCallBack;
import com.ptteng.polyFinance.lgd.service.*;
import com.ptteng.polyFinance.lgd.utils.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author lujing
 * Create_at 2018/4/4 10:02
 */
@Controller
public class PayMentController {
    @Autowired
    private TradingRecordService tradingRecordService;
    @Autowired
    private ProductService productService;
    @Autowired
    private InvestRecordService investRecordService;
    @Autowired
    private UserBankService userBankService;
    @Autowired
    private UserMessageService userMessageService;
    @Autowired
    private UserService userService;
    @Autowired
    private RepaymentService repaymentService;
    
    private static Logger logger = LoggerFactory.getLogger(PayMentController.class);
    
    private static final String PAY_URL = ConfigReader.getString("h5.pay_url");
    
    
    @RequestMapping(value = "/a/u/pay", method = RequestMethod.POST)
    public void payPost(Long userId, String amt, String bankCard, String name, String idType, String idNo, String type, Long productId, Long userBankId, @DateTimeFormat(pattern = "yyyy-mm-dd") Long valueDay, @DateTimeFormat(pattern = "yyyy-mm-dd") Long valueEndDay, HttpServletRequest request, HttpServletResponse resp) throws IOException {
        String respMsg;
        resp.setContentType("text/html");
        if (CommonUtil.isEmpty(userId, amt, bankCard, name, idType, idNo, type, productId, userBankId, valueDay, valueEndDay)) {
            respMsg = "necessary  parameter is missing !";
            resp.getOutputStream().write(respMsg.getBytes("utf8"));
            return;
        }
        
        try {
            //插入投资记录
            InvestRecord investRecord = new InvestRecord();
            Product productInvest = productService.getObjectById(productId);
            
            TradingRecord tradingRecord = new TradingRecord();
            Product product = productService.getObjectById(productId);
            UserBank userBank = userBankService.getObjectById(userBankId);
            
            investRecord.setUserId(-1l);
            investRecord.setProductId(productId);
            investRecord.setProductName(productInvest.getName());
            investRecord.setProductInterestRate(productInvest.getInterestRate());
            investRecord.setProductPaymentMethod(productInvest.getPaymentMethod());
            investRecord.setProductInterestAmountLine(productInvest.getInterestAmountLine());
            //银行卡，银行卡号
            investRecord.setRepaymentBankName(userBank.getBankName());
            investRecord.setRepaymentCard(userBank.getCardNo());
            //交易金额，单位为分
            investRecord.setInvestAmount(new BigDecimal(amt));
            investRecord.setInvestStatus(-1);
            //未分配收益
            BigDecimal undisIncome = CommonUtil.getIncomeByDays(new BigDecimal(amt), product.getInterestRate(), valueDay, valueEndDay);
            
            investRecord.setUndistributedIncome(undisIncome);
            investRecord.setDistributionIncome(new BigDecimal(0));
            investRecord.setValueDay(valueDay);
            investRecord.setValueEndDay(valueEndDay);
            Long investRecordId = investRecordService.insert(investRecord);
            
            if (investRecordId == null) {
                respMsg = "系统异常!";
                resp.getOutputStream().write(respMsg.getBytes("utf8"));
                return;
            }
            
            //商户订单号与交易流水号用同一个
            String orderId = "JXYK" + investRecordId + "|" +
                    DateTimeUtil.getCurrentDate("yyyyMMddHHmmssSSS");
            
            //生成一条位未支付的交易记录
            tradingRecord.setId(null);
            tradingRecord.setUserId(userId);
            tradingRecord.setTradingAmount(new BigDecimal(Integer.valueOf(amt)));
            tradingRecord.setTradingNum(orderId);
            tradingRecord.setTradingTime(System.currentTimeMillis());
            tradingRecord.setProductName(product.getName());
            tradingRecord.setTradingMode(CommonUtil.getUserBankInfo(userBank));
            tradingRecord.setUserBankId(userBankId);
            tradingRecord.setTradingStatus(-1);
            tradingRecord.setTradingType(0);
            
            //插入一条交易记录
            Long idInsert = tradingRecordService.insert(tradingRecord);
            if (idInsert == null) {
                respMsg = "系统异常!";
                resp.getOutputStream().write(respMsg.getBytes("utf8"));
                return;
            }
            
            Map<String, String> param = HttpPay.getParam(userId, amt, bankCard, name, idType, idNo, type, orderId);
            respMsg = HttpFormUtil.formForward(PAY_URL, param);
            resp.getOutputStream().write(respMsg.getBytes("utf8"));
            
        } catch (Throwable e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            respMsg = "系统异常!";
            resp.getOutputStream().write(respMsg.getBytes("utf8"));
        }
        
        
    }
    
    
    @RequestMapping(value = "/a/u/pay/callback", method = RequestMethod.POST)
    public void payCallback(HttpServletResponse response, HttpServletRequest request) {
        String responseCode = request.getParameter("RESPONSECODE");
        String tradingNumGet = request.getParameter("MCHNTORDERID");
        String orderidGet = request.getParameter("ORDERID");
        String amountGet = request.getParameter("AMT");
        logger.info("=-----pay call back -----,reaponseCode is " + responseCode + " ; orderid is " + orderidGet + " ; tradingNum is " + tradingNumGet);
        
        try {
            TradingRecord tradingRecordGet = tradingRecordService.getObjectByTradingNum(tradingNumGet);
            InvestRecord investRecordGet = investRecordService.getObjectById(HttpPay.getInvestRecordId(tradingNumGet));
            
            logger.info(">>>tradingRecordGet= = = = is " + tradingRecordGet);
            String responseCodeGet = HttpPayCallBack.queryOrderStatus(tradingNumGet);
            logger.info("=====responseCodeGet==== is ==" + responseCodeGet);
            if (tradingRecordGet != null && responseCode != null && responseCode.equals("0000")) {
                
                
                if (tradingRecordGet.getTradingNum().equals(tradingNumGet) && tradingRecordGet.getTradingAmount().equals(new BigDecimal(amountGet)) &&
                        responseCodeGet.equals("0000")) {
                    //更新交易记录：状态，富友支付流水号
                    tradingRecordGet.setOrderNum(orderidGet);
                    tradingRecordGet.setTradingStatus(0);
                    tradingRecordService.update(tradingRecordGet);
                    logger.info(">>> = = = update tradingRecordGet success , tradingRecordGet is " + tradingRecordGet);
                    
                    //更新投资记录：用户id，投资状态（0）
                    investRecordGet.setUserId(tradingRecordGet.getUserId());
                    investRecordGet.setInvestStatus(0);
                    investRecordService.update(investRecordGet);
                    logger.info(">>> = = = update investRecordGet success , investRecordGet is " + tradingRecordGet);
                    
                    // 生成一条用户消息
                    UserMessage userMessage = new UserMessage();
                    userMessage.setUserId(tradingRecordGet.getUserId());
                    userMessage.setMessageType(0);
                    userMessage.setInvestRecordId(investRecordGet.getId());
                    userMessage.setContent(investRecordGet.getProductName() + "已投资成功");
                    userMessageService.insert(userMessage);
                    logger.info(">>> = = = update userMessage success , userMessage is " + tradingRecordGet);
                    //更新用户总资产
                    List<Long> ids = investRecordService.getInvestRecordIdsByUserIdAndInvestStatusOrderByCreateAt(tradingRecordGet.getUserId(), 0, 0, Integer.MAX_VALUE);
                    List<InvestRecord> investRecordList = investRecordService.getObjectsByIds(ids);
                    
                    User user = userService.getObjectById(tradingRecordGet.getUserId());
                    BigDecimal total = CommonUtil.getUserTotalIncome(investRecordList);
                    user.setTotalProperty(total);
                    userService.update(user);
                    logger.info(">>> = = = update UserTotalIncome success , UserTotalIncome is " + total);
                    //生成还款计划
                    generateRepayMent(investRecordGet);
                    logger.info(">>> = = = update RepayMent success .... ");
                    response.getWriter().write("success");
                }
            }
            
        } catch (Throwable e) {
            e.printStackTrace();
        }
        
        
    }
    
    
   
    
    
       private List<Long> generateRepayMent(InvestRecord investRecord) throws ServiceException, ServiceDaoException {
        List<Long> ids = new ArrayList<>();
        List<Repayment> repaymentList = new ArrayList<>();
        
        Integer repaymentMethod = investRecord.getProductPaymentMethod();
        
        Repayment repaymentAmount = new Repayment();
        repaymentAmount.setMoneyType(1);
        repaymentAmount.setUserId(investRecord.getUserId());
        repaymentAmount.setInvestRecordId(investRecord.getId());
        repaymentAmount.setRepaymentAmount(investRecord.getInvestAmount());
        repaymentAmount.setRepaymentDate(investRecord.getValueEndDay());
        repaymentAmount.setRepaymentStatus(0);
        repaymentList.add(repaymentAmount);
        //
        if (repaymentMethod == 0) {
        
        
        }
        
        if (repaymentMethod == 1) {
            Repayment repaymentRate = new Repayment();
            repaymentRate.setMoneyType(0);
            repaymentRate.setInvestRecordId(investRecord.getId());
            repaymentRate.setRepaymentAmount(investRecord.getDistributionIncome());
            repaymentAmount.setRepaymentDate(investRecord.getValueEndDay());
            repaymentList.add(repaymentRate);
            
        }
        
        
        List<Repayment> list = repaymentService.insertList(repaymentList);
        
        
        return ids;
    }
}
