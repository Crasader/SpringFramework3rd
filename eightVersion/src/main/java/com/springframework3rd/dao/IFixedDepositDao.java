package com.springframework3rd.dao;

import com.springframework3rd.domain.FixedDepositDetails;

public interface IFixedDepositDao {
    int createFixedDeposit(FixedDepositDetails fixedDepositDetails);
    FixedDepositDetails getFixedDeposit(int fixedDepositId);
}
