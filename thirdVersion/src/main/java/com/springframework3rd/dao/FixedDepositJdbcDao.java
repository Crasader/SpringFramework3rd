package com.springframework3rd.dao;

import com.springframework3rd.domain.FixedDepositDetails;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class FixedDepositJdbcDao implements IFixedDepositDao{
    private static Logger logger = Logger.getLogger(FixedDepositJdbcDao.class);
    private Map<Long, FixedDepositDetails> fixedDeposits = new HashMap<>();

    public FixedDepositJdbcDao() {
        logger.info("initializing");
    }

    public FixedDepositDetails getFixedDepositDetails(long id) {
        return fixedDeposits.get(id);
    }

    public boolean createFixedDeposit(FixedDepositDetails fdd) {
        fixedDeposits.put(fdd.getId(), fdd);
        return true;
    }
}