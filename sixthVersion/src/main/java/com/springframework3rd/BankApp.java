package com.springframework3rd;

import com.springframework3rd.service.AccountStatementService;
import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class BankApp {
    private static Logger logger = Logger.getLogger(BankApp.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/applicationContext.xml");

        AccountStatementService service= context.getBean(AccountStatementService.class);
        service.getAccountStatement(new Date(), new Date());
        context.close();
    }
}
