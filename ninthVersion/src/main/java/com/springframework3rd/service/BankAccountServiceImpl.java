package com.springframework3rd.service;

import com.springframework3rd.domain.BankAccountDetails;
import com.springframework3rd.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    @Transactional
    public int createBankAccount(BankAccountDetails bankAccountDetails) {
        return bankAccountRepository.save(bankAccountDetails).getAccountId();
    }
}
