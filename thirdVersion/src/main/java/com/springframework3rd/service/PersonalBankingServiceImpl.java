package com.springframework3rd.service;

import com.springframework3rd.BankApp;
import com.springframework3rd.base.ServiceTemplate;
import com.springframework3rd.dao.IPersonalBankingDao;
import com.springframework3rd.domain.BankStatement;

public class PersonalBankingServiceImpl extends ServiceTemplate implements IPersonalBankingService {
    private IPersonalBankingDao personalBankingDao;

    public void setPersonalBankingDao(IPersonalBankingDao personalBankingDao) {
        this.personalBankingDao = personalBankingDao;
    }

    @Override
    public BankStatement getMiniStatement() {
        return personalBankingDao.getMiniStatement();
    }
}
