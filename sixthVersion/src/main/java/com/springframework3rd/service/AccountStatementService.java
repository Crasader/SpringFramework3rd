package com.springframework3rd.service;

import com.springframework3rd.dao.AccountStatementDao;
import com.springframework3rd.dao.IAccountStatementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service(value = "iAccountStatementService")
@Qualifier("service")
public class AccountStatementService implements IAccountStatementService {
    @Autowired
    private IAccountStatementDao accountStatementDao;

    public void getAccountStatement(Date from, Date to) {
        System.out.println("AccountStatementService getAccountStatement");

        accountStatementDao.getAccountStatement(from, to);
    }
}
