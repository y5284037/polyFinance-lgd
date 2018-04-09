package com.ptteng.polyFinance.lgd.JobDetail;

import com.ptteng.polyFinance.lgd.service.CountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lujing
 * Create_at 2018/4/9 9:23
 */
public class CountJob {
    
    private CountService countService;
    
    public void countProductService() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-server.xml");
        countService = (CountService) context.getBean("countService");
        
        
    }
    
    
    
    public void sendMessage(){
        System.out.println("send messge");
    }
}
