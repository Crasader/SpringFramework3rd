package com.springframework3rd.service;

import com.springframework3rd.dao.FixedDepositHibernateDao;
import com.springframework3rd.dao.IFixedDepositDao;
import com.springframework3rd.domain.FixedDepositDetails;
import org.apache.log4j.Logger;

public class FixedDepositServiceImpl implements IFixedDepositService{
    private static Logger logger = Logger.getLogger(FixedDepositServiceImpl.class);
    private IFixedDepositDao fixedDepositDao;

    public FixedDepositServiceImpl() {
        logger.info("initializing");
    }

    public IFixedDepositDao getFixedDepositDao() {
        return fixedDepositDao;
    }

    public void setFixedDepositDao(IFixedDepositDao fixedDepositDao) {
        logger.info("Setting fixedDepositDao property");
        this.fixedDepositDao = fixedDepositDao;
    }

    public FixedDepositDetails getFixedDepositDetails(long id) {
        return fixedDepositDao.getFixedDepositDetails(id);
    }

    public boolean createFixedDeposit(FixedDepositDetails fdd) {
        return fixedDepositDao.createFixedDeposit(fdd);
    }
}