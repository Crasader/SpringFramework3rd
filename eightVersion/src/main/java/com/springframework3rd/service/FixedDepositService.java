package com.springframework3rd.service;

import com.springframework3rd.dao.BankAccountDao;
import com.springframework3rd.dao.FixedDepositDao;
import com.springframework3rd.domain.FixedDepositDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//@Service("fixedDepositService")
public class FixedDepositService implements IFixedDepositService {
    @Autowired
    @Qualifier("fixedDepositDao")
    private FixedDepositDao myFixedDepositDao;

    @Autowired
    private BankAccountDao bankAccountDao;

    @Override
    @Transactional
    public int createFixedDeposit(FixedDepositDetails fixedDepositDetails) throws Exception {
        bankAccountDao.subtractFromAccount(fixedDepositDetails.getBankAccountId(), fixedDepositDetails.getFdAmount());
        return myFixedDepositDao.createFixedDeposit(fixedDepositDetails);
    }

    @Override
    public FixedDepositDetails getFixedDeposit(int fixedDepositId) {
        return myFixedDepositDao.getFixedDeposit(fixedDepositId);
    }
}
