package com.springframework3rd.dao;

import com.springframework3rd.domain.AccountStatement;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository("iAccountStatementDao")
public class AccountStatementDao implements IAccountStatementDao {
    @Override
    public AccountStatement getAccountStatement(Date from, Date to) {
        System.out.println("AccountStatementDao getAccountStatement");
        return new AccountStatement();
    }
}
