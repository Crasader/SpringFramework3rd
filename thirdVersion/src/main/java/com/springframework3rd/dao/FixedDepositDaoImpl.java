package com.springframework3rd.dao;

import com.springframework3rd.domain.FixedDepositDetails;
import com.springframework3rd.utils.DatabaseOperations;
import org.apache.log4j.Logger;

public class FixedDepositDaoImpl implements IFixedDepositDao {
    private static Logger logger = Logger.getLogger(FixedDepositDaoImpl.class);
    private DatabaseOperations databaseOperations;

    public void setDatabaseOperations(DatabaseOperations databaseOperations) {
        this.databaseOperations = databaseOperations;
    }

    public FixedDepositDaoImpl() {
        logger.info("initializing");
    }

    public FixedDepositDetails getFixedDepositDetails(long id) {
        return databaseOperations.loadFd(id);
    }

    public boolean createFixedDeposit(FixedDepositDetails fdd) {
        return databaseOperations.saveFd(fdd);
    }
}
