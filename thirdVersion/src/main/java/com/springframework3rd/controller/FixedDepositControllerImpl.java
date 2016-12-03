package com.springframework3rd.controller;


import com.springframework3rd.domain.FixedDepositDetails;
import com.springframework3rd.service.FixedDepositServiceImpl;
import org.apache.log4j.Logger;

public class FixedDepositControllerImpl implements IFixedDepositController {
    private static Logger logger = Logger.getLogger(FixedDepositControllerImpl.class);

    private FixedDepositServiceImpl fixedDepositServiceImpl;

    public FixedDepositControllerImpl() {
        logger.info("initializing");
    }

    public void setFixedDepositServiceImpl(FixedDepositServiceImpl fixedDepositServiceImpl) {
        logger.info("Seeting fixedDepositServiceImpl property");
        this.fixedDepositServiceImpl = fixedDepositServiceImpl;
    }

    public FixedDepositServiceImpl getFixedDepositServiceImpl() {
        return fixedDepositServiceImpl;
    }

    public boolean submit(FixedDepositDetails fixedDepositDetails) {
        return fixedDepositServiceImpl.createFixedDeposit(new FixedDepositDetails(
                1, 10000, 365, "someemail@sometest.com"));
    }

    public FixedDepositDetails get() {
        return fixedDepositServiceImpl.getFixedDepositDetails(1L);
    }
}
