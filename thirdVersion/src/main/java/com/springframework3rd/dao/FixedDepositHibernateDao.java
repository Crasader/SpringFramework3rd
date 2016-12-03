package com.springframework3rd.dao;

import java.util.HashMap;
import java.util.Map;

import com.springframework3rd.domain.FixedDepositDetails;
import org.apache.log4j.Logger;

public class FixedDepositHibernateDao implements IFixedDepositDao{
    private static Logger logger = Logger.getLogger(FixedDepositHibernateDao.class);
    private Map<Long, FixedDepositDetails> fixedDeposits = new HashMap<>();

    public FixedDepositHibernateDao() {
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