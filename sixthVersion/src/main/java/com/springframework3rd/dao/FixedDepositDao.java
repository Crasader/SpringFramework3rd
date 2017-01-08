package com.springframework3rd.dao;

import com.springframework3rd.common.IInstanceValidator;
import com.springframework3rd.domain.IFixedDepositDetails;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository(value="myFixedDepositDao")
public class FixedDepositDao implements IFixedDepositDao, IInstanceValidator {
    private static Logger logger = Logger.getLogger(FixedDepositDao.class);
    private DatabaseConnection connection;
    private IFixedDepositDetails fixedDepositDetails;
    public FixedDepositDao() {
        logger.info("FixedDepositDao constructor invoked.");
    }

    public void setFixedDepositDetails(IFixedDepositDetails fixedDepositDetails) {
        this.fixedDepositDetails = fixedDepositDetails;
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
