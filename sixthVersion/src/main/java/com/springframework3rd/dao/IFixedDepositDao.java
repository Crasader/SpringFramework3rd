package com.springframework3rd.dao;

public interface IFixedDepositDao {
    void initializeDbConnection();
    String getDeposit();
}
