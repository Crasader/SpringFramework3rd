package com.springframework3rd.dao;

import com.springframework3rd.domain.BankAccountDetails;

public interface BankAccountDao {
    int createBankAccount(BankAccountDetails bankAccountDetails);
    void subtractFromAccount(int bankAccountId, int amount);
}
