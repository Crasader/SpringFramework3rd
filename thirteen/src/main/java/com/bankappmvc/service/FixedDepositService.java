package com.bankappmvc.service;

import com.bankappmvc.domain.FixedDepositDetails;

import java.util.List;

public interface FixedDepositService {
    List<FixedDepositDetails> getFixedDeposits();
    void saveFixedDeposit(FixedDepositDetails fixedDepositDetails);
    void closeFixedDeposit(int fixedDepositId);
    FixedDepositDetails getFixedDeposit(int fixedDepositID);
    void editFixedDeposit(FixedDepositDetails fixedDepositDetails);
}
