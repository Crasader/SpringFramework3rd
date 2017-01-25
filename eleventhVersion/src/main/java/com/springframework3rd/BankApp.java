package com.springframework3rd;

import com.springframework3rd.domain.BankAccountDetails;
import com.springframework3rd.domain.FixedDepositDetails;
import com.springframework3rd.service.*;
import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class BankApp {
    private static Logger logger = Logger.getLogger(BankApp.class);

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/applicationContext.xml");
        BankAccountService bankAccountService = context.getBean(BankAccountService.class);
        BankAccountDetails bankAccountDetails = new BankAccountDetails();
        bankAccountDetails.setBalanceAmount(1000);
        bankAccountDetails.setLastTransactionTimestamp(new Date());

        int bankAccountId = bankAccountService.createBankAccount(bankAccountDetails);

        logger.info("Created bank account with id - " + bankAccountId);

        FixedDepositService fixedDepositService = context.getBean(FixedDepositService.class);
        FixedDepositDetails fdd = new FixedDepositDetails();
        fdd.setActive("N");
        fdd.setBankAccountId(bankAccountId);
        fdd.setFdCreationDate(new Date());
        fdd.setFdAmount(50);
        fdd.setTenure(12);
        fdd.setEmail("d.potehin.chita.ru@gmail.com");
        fixedDepositService.createFixedDeposit(fdd);

        context.close();
    }
}
