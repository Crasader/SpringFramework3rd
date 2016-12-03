package com.springframework3rd.service;

import com.springframework3rd.BankApp;
import com.springframework3rd.dao.IPersonalBankingDao;
import com.springframework3rd.domain.BankStatement;

/**
 * Created by Dimon on 04.12.2016.
 */
public class PersonalBankingServiceImpl implements IPersonalBankingService {
    private IPersonalBankingDao personalBankingDao;

    public void setPersonalBankingDao(IPersonalBankingDao personalBankingDao) {
        this.personalBankingDao = personalBankingDao;
    }

    @Override
    public BankStatement getMiniStatement() {
        return personalBankingDao.getMiniStatement();
    }
}
