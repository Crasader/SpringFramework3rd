package com.springframework3rd.domain;

import com.springframework3rd.dao.FixedDepositDao;
import org.apache.log4j.Logger;

public class FixedDepositDetails implements IFixedDepositDetails {
    private static Logger logger = Logger.getLogger(FixedDepositDetails.class);

    public FixedDepositDetails() {
        logger.info("FixedDepositDetails instance created");
    }
}
