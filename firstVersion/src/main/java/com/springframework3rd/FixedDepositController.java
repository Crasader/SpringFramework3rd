package com.springframework3rd;


import org.apache.log4j.Logger;

public class FixedDepositController {
    private static Logger logger = Logger.getLogger(FixedDepositController.class);

    private FixedDepositService fixedDepositService;

    public FixedDepositController() {
        logger.info("initializing");
    }

    public void setFixedDepositService(FixedDepositService fixedDepositService) {
        logger.info("Seeting fixedDepositService property");
        this.fixedDepositService = fixedDepositService;
    }

    public boolean submit() {
        return fixedDepositService.createFixedDeposit(new FixedDepositDetails(
                1, 10000, 365, "someemail@sometest.com"));
    }

    public FixedDepositDetails get() {
        return fixedDepositService.getFixedDepositDetails(1L);
    }
}
