package com.springframework3rd.service;

import com.springframework3rd.domain.FixedDepositDetails;

import java.util.List;

public interface FixedDepositService {
    void createFixedDeposit(FixedDepositDetails fdd) throws Exception;

    FixedDepositDetails getFixedDeposit(int fixedDepositId);

    List<FixedDepositDetails> getFixedDeposits();

}