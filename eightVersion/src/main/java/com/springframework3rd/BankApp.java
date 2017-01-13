package com.springframework3rd;

import com.springframework3rd.domain.BankAccountDetails;
import com.springframework3rd.domain.FixedDepositDetails;
import com.springframework3rd.service.*;
import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Date;

public class BankApp {
    private static Logger logger = Logger.getLogger(BankApp.class);

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/applicationContext.xml");

//        IBankAccountService bankAccountService = context.getBean(IBankAccountService.class);
        IBankAccountService bankAccountService = (BankAccountServiceH)context.getBean("bankAccountServiceH");
        BankAccountDetails bankAccountDetails = new BankAccountDetails();
        bankAccountDetails.setBalanceAmount(1000);
        bankAccountDetails.setLastTransactionTimestamp(new Date());

        int bankAccountId = bankAccountService.createBankAccount(bankAccountDetails);
        logger.info("Created bank account with id " + bankAccountId);

//        IFixedDepositService fixedDepositService = context.getBean(IFixedDepositService.class);
//
//        FixedDepositDetails fdd = new FixedDepositDetails();
//        fdd.setActive("Y");
//        fdd.setBankAccountId(bankAccountId);
//        fdd.setFdCreationDate(new Date());
//        fdd.setFdAmount(500);
//        fdd.setTenure(12);
//        int fixedDepositId = fixedDepositService.createFixedDeposit(fdd);
//        logger.info("Created fixed deposit with id - " + fixedDepositId);
//
//        logger.info(fixedDepositService.getFixedDeposit(fixedDepositId));

        context.close();
    }
}
