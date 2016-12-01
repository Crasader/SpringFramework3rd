package com.springframework3rd;

import com.springframework3rd.controller.FixedDepositControllerImpl;
import com.springframework3rd.controller.IFixedDepositController;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BankApp {
    private static Logger logger = Logger.getLogger(BankApp.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/applicationContext.xml");
        IFixedDepositController fixedDepositController
                = (IFixedDepositController) context.getBean("controller");
        logger.info("Submission status of fixed deposit : "
            + fixedDepositController.submit());
        logger.info("Returned fixed deposit info : "
                + fixedDepositController.get());
    }
}
