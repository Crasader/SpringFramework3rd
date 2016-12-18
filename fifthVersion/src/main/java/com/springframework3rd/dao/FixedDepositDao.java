package com.springframework3rd.dao;

import com.springframework3rd.common.IInstanceValidator;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;

public class FixedDepositDao implements IFixedDepositDao, IInstanceValidator {
    private static Logger logger = Logger.getLogger(FixedDepositDao.class);
    private DatabaseConnection connection;
    public FixedDepositDao() {
        logger.info("FixedDepositDao constructor invoked.");
    }

    @PostConstruct
    public void initializeDbConnection() {
        logger.info("FixedDepositDao initializeDbConnection invoked.");
        connection = DatabaseConnection.getInstance();
    }

    @Override
    public void validateInstance() {
        logger.info("Validating FixedDepositDaoImpl instance");
        if(connection == null) {
            logger.error("Failed to obtain DatabaseConnection instance");
        }
    }

    public String getDeposit() {
        logger.info("FixedDepositDao getDeposit invoked.");
        return "deposit";
    }
}
