package com.springframework3rd.repository;

public interface BankAccountRepositoryCustom {
    void subtractFromAccount(int bankAccountId, int amount);
}
