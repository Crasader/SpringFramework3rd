package com.springframework3rd.dao;

import com.springframework3rd.domain.FixedDepositDetails;

public interface IFixedDepositDao {
    FixedDepositDetails getFixedDepositDetails(long id);
    boolean createFixedDeposit(FixedDepositDetails fdd);
}
