package com.springframework3rd.dao;

import com.springframework3rd.domain.BankStatement;
import com.springframework3rd.utils.DatabaseOperations;

public class PersonalBankingDaoImpl implements IPersonalBankingDao {
    private DatabaseOperations databaseOperations;

    public void setDatabaseOperations(DatabaseOperations databaseOperations) {
        this.databaseOperations = databaseOperations;
    }

    @Override
    public BankStatement getMiniStatement() {
        return databaseOperations.getMiniStatement();
    }
}
