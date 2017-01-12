package com.springframework3rd.service;


import com.springframework3rd.domain.FixedDepositDetails;

@SuppressWarnings("unused")
public interface IFixedDepositService {
    int createFixedDeposit(FixedDepositDetails fixedDepositDetailse) throws Exception;
    FixedDepositDetails getFixedDeposit(int fixedDepositId);
}
