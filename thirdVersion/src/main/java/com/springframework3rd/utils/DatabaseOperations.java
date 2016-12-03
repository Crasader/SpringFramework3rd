package com.springframework3rd.utils;

import com.springframework3rd.domain.BankStatement;
import com.springframework3rd.domain.FixedDepositDetails;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DatabaseOperations {
    private static Map<Long, FixedDepositDetails> fixedDeposits
            = new HashMap<>();

    public boolean saveFd(FixedDepositDetails fdd) {
        fixedDeposits.put(fdd.getId(), fdd);
        return true;
    }

    public FixedDepositDetails loadFd(long id) {
        return fixedDeposits.get(id);
    }

    public BankStatement getMiniStatement() {
        BankStatement bankStatement = new BankStatement();
        bankStatement.setAmount(100).setReferenceNumber("Ref. no. 1")
                .setTransactionDate(new Date()).setTransactionType("credit");
        return bankStatement;
    }
}
