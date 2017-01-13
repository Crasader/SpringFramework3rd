package com.springframework3rd.dao;

import com.springframework3rd.domain.BankAccountDetails;

public interface IBankAccountDao {
    int createBankAccount(final BankAccountDetails bankAccountDetails);
    void subtractFromAccount(int bankAccountId, int amount);
}
