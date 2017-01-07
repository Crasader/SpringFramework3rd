package com.springframework3rd.dao;

import com.springframework3rd.domain.AccountStatement;

import java.util.Date;

public interface IAccountStatementDao {
    AccountStatement getAccountStatement(Date from, Date to);
}
