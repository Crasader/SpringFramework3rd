package com.springframework3rd.repository;

import com.springframework3rd.domain.BankAccountDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BankAccountRepositoryImpl /*implements BankAccountRepositoryCustom*/ {

    @PersistenceContext
    private EntityManager entityManager;

    public BankAccountRepositoryImpl() {}
/*
    @Override
    public void subtractFromAccount(int bankAccountId, int amount) {
        BankAccountDetails bankAccountDetails = entityManager.find(BankAccountDetails.class, bankAccountId);
        if(bankAccountDetails.getBalanceAmount() < amount) {
            throw new RuntimeException("Insufficient balance amount in bank account");
        }
        bankAccountDetails.setBalanceAmount(bankAccountDetails.getBalanceAmount()-amount);
        entityManager.merge(bankAccountDetails);
    }
    */
}
