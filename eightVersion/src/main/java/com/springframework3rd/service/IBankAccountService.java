package com.springframework3rd.service;

import com.springframework3rd.domain.BankAccountDetails;

public interface IBankAccountService {
    int createBankAccount(BankAccountDetails bankAccountDetails);
}
