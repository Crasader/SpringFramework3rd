package com.springframework3rd;

import com.springframework3rd.service.*;
import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class BankApp {
    private static Logger logger = Logger.getLogger(BankApp.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/applicationContext.xml");
/*
        AccountStatementService service= context.getBean(AccountStatementService.class);
        service.getAccountStatement(new Date(), new Date());

        FixedDepositService depositService = context.getBean(FixedDepositService.class);
        depositService.run();

        CustomerRequestService requestService = context.getBean(CustomerRequestService.class);
        requestService.run();

        CustomerRegistrationService customerRegistrationService = context.getBean(CustomerRegistrationService.class);
        customerRegistrationService.setAccountNumber("7651234");
*/
//        Services services = context.getBean(Services.class);
//        System.out.println(services.getServices());

        FundTransferProcessor transferProcessor = context.getBean(FundTransferProcessor.class);
        transferProcessor.sameBankImmediateFundTransferService();
        transferProcessor.diffBankImmediateFundTransferService();

        context.close();
    }
}
