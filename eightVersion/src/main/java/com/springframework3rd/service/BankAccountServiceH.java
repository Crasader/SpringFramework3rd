package com.springframework3rd.service;

import com.springframework3rd.dao.IBankAccountDao;
import com.springframework3rd.domain.BankAccountDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("bankAccountServiceH")
public class BankAccountServiceH implements IBankAccountService {
    @Resource(name="bankAccountDaoH")
    private IBankAccountDao bankAccountDao;

    @Override
    @Transactional
    public int createBankAccount(BankAccountDetails bankAccountDetails) {
        return bankAccountDao.createBankAccount(bankAccountDetails);
    }
}
