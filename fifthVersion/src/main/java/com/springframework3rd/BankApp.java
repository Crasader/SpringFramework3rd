package com.springframework3rd;

import com.springframework3rd.dao.FixedDepositDao;
import com.springframework3rd.service.FixedDepositService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BankApp {
    private static Logger logger = Logger.getLogger(BankApp.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/applicationContext.xml");

        FixedDepositService service = (FixedDepositService)context.getBean("fixedDepositService");
        service.run();
    }
}