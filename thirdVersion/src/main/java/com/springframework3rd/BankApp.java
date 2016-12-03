package com.springframework3rd;

import com.springframework3rd.controller.FixedDepositControllerImpl;
import com.springframework3rd.controller.IFixedDepositController;
import com.springframework3rd.controller.IPersonalBankingController;
import com.springframework3rd.domain.FixedDepositDetails;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BankApp {
    private static Logger logger = Logger.getLogger(BankApp.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/applicationContext.xml");
        IFixedDepositController fixedDepositController
                = (IFixedDepositController) context.getBean(IFixedDepositController.class);
        fixedDepositController.submit(
                context.getBean(FixedDepositDetails.class)
                .setDepositAmount(100).setEmail("test@test.com")
                .setId(1).setTenure(10)
        );
        logger.info("Your fixed deposit details: " + fixedDepositController.get());
        IPersonalBankingController personalBankingController
                = context.getBean(IPersonalBankingController.class);
        logger.info(personalBankingController.getMiniStatement());
    }
}
