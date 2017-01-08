package com.springframework3rd.service;

import com.springframework3rd.annotation.BankType;
import com.springframework3rd.annotation.FundTransfer;
import com.springframework3rd.annotation.TransferSpeed;
import com.springframework3rd.domain.Account;
import org.springframework.stereotype.Service;

@Service("immediateDiffBank")
@FundTransfer(transferSpeed = TransferSpeed.IMMEDIATE,
        bankType = BankType.DIFFERENT)
public class ImmediateDiffBank implements IFundTransferService {
    public void transferFunds(Account sender, Account receiver) {
        System.out.println("ImmediateDiffBank");
        System.out.println("From sender: " + sender.getName() + " to receiver: " + receiver.getName());
    }
}
