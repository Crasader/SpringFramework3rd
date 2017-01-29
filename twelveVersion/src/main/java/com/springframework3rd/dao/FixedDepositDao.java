package com.springframework3rd.dao;

import com.springframework3rd.domain.FixedDepositDetails;

import java.util.List;

public interface FixedDepositDao {
    int createFixedDeposit(FixedDepositDetails fdd);
    FixedDepositDetails getFixedDeposit(int fixedDepositId);
    List<FixedDepositDetails> getFixedDeposits();
 }
