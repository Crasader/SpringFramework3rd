package com.springframework3rd;

import com.springframework3rd.dao.FixedDepositDao;
import com.springframework3rd.domain.DataSource;
import com.springframework3rd.domain.WebServiceConfiguration;
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

//        context.getBean("eventSenderFactory");
//        context.getBean("eventSenderFactory");
        logger.info(context.getBean(DataSource.class));
        logger.info(context.getBean(WebServiceConfiguration.class));
        context.close();
    }
}
