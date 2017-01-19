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
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.springframework3rd");
        context.refresh();

        BankAccountService bankAccountService = context.getBean(BankAccountService.class);
        BankAccountDetails bankAccountDetails = new BankAccountDetails();
        bankAccountDetails.setBalanceAmount(1000);
        bankAccountDetails.setLastTransactionTimestamp(new Date());

        int  bankAccountId = bankAccountService.createBankAccount(bankAccountDetails);

        logger.info("Created bank account with id - " + bankAccountId);

        FixedDepositService fixedDepositService = context.getBean(FixedDepositService.class);

        FixedDepositDetails fixedDepositDetails = new FixedDepositDetails();
        fixedDepositDetails.setActive("Y");
        fixedDepositDetails.setBankAccountId(bankAccountDetails);
        fixedDepositDetails.setFdCreationDate(new Date());
        fixedDepositDetails.setFdAmount(500);
        fixedDepositDetails.setTenure(12);
        int fixedDepositId = fixedDepositService.createFixedDeposit(fixedDepositDetails);
        logger.info("Created fixed deposit with id - " + fixedDepositId);

        FixedDepositDetails _fdd = new FixedDepositDetails();
        _fdd.setActive("Y");
        _fdd.setBankAccountId(bankAccountDetails);
        _fdd.setFdCreationDate(new Date());
        _fdd.setFdAmount(500);
        _fdd.setTenure(6);
        fixedDepositService.createFixedDeposit(_fdd);

        logger.info("Total number of fixed deposits : " + fixedDepositService.count());
        logger.info("Number of fixed deposits with 12 months tenure : " + fixedDepositService.countByTenure(12));

//        List<FixedDepositDetails> removeFds = fixedDepositService.removeByTenure(12);
//        logger.info("Removed " + removeFds.size() + " fixed deposits with tenure as 12 months");

        logger.info("Number of fixed deposits with 12 months tenure " + fixedDepositService.countByTenure(12));
        logger.info("findByTenure : " + fixedDepositService.findByTenure(6));
        logger.info("findTop2ByTenure : " + fixedDepositService.findTop2ByTenure(6));

        logger.info("getAllFds : " + fixedDepositService.getHighValueFds());
        logger.info("All fds : " + fixedDepositService.getAllFds());

    }
}
