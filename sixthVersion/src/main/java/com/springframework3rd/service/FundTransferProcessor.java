package com.springframework3rd.service;

import com.springframework3rd.annotation.BankType;
import com.springframework3rd.annotation.FundTransfer;
import com.springframework3rd.annotation.TransferSpeed;
import com.springframework3rd.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FundTransferProcessor {
    @Autowired
    //@Qualifier("immediateSameBank")
    @FundTransfer(transferSpeed = TransferSpeed.IMMEDIATE, bankType = BankType.SAME)
    private IFundTransferService sameBankImmediateFundTransferService;

    @Autowired
    //@Qualifier("immediateDiffBank")
    @FundTransfer(transferSpeed = TransferSpeed.IMMEDIATE, bankType = BankType.DIFFERENT)
    private IFundTransferService diffBankImmediateFundTransferService;

    public void sameBankImmediateFundTransferService() {
        sameBankImmediateFundTransferService.transferFunds(new Account("Tony"), new Account("Mony"));
    }

    public void diffBankImmediateFundTransferService() {
        diffBankImmediateFundTransferService.transferFunds(new Account("Fanny"), new Account("Cranny"));
    }
}
