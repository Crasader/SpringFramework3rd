package com.springframework3rd.controller;

import com.springframework3rd.domain.FixedDepositDetails;
import com.springframework3rd.service.FixedDepositServiceImpl;

public interface IFixedDepositController {
    FixedDepositServiceImpl getFixedDepositServiceImpl();

    boolean submit();

    FixedDepositDetails get();
}
