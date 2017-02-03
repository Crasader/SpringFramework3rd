package com.bankappmvc.service;

import com.bankappmvc.dao.FixedDepositDao;
import com.bankappmvc.domain.FixedDepositDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FixedDepositServiceImpl implements FixedDepositService {
    @Autowired
    private FixedDepositDao fixedDepositDao;

    @Override
    public List<FixedDepositDetails> getFixedDeposits() {
        return fixedDepositDao.getFixedDeposits();
    }

    @Override
    public void saveFixedDeposit(FixedDepositDetails fixedDepositDetails) {
        fixedDepositDao.saveFixedDeposit(fixedDepositDetails);
    }

    @Override
    public void closeFixedDeposit(int fixedDepositId) {
        fixedDepositDao.closeFixedDeposit(fixedDepositId);
    }

    @Override
    public FixedDepositDetails getFixedDeposit(int fixedDepositID) {
        return fixedDepositDao.getFixedDeposit(fixedDepositID);
    }

    @Override
    public void editFixedDeposit(FixedDepositDetails fixedDepositDetails) {
        fixedDepositDao.editFixedDeposit(fixedDepositDetails);
    }


}
