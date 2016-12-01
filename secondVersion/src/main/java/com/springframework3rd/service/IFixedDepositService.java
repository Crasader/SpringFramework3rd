package com.springframework3rd.service;

import com.springframework3rd.dao.IFixedDepositDao;
import com.springframework3rd.domain.FixedDepositDetails;

public interface IFixedDepositService {
    IFixedDepositDao getFixedDepositDao();
    FixedDepositDetails getFixedDepositDetails(long id);
    boolean createFixedDeposit(FixedDepositDetails fdd);
}
