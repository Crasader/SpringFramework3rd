package com.springframework3rd.service;

import com.springframework3rd.annotation.BankType;
import com.springframework3rd.annotation.FundTransfer;
import com.springframework3rd.annotation.TransferSpeed;
import com.springframework3rd.domain.Account;
import org.springframework.stereotype.Service;

@Service("immediateSameBank")
@FundTransfer(transferSpeed = TransferSpeed.IMMEDIATE,
        bankType = BankType.SAME)
public class ImmediateSameBank implements IFundTransferService {
    public void transferFunds(Account sender, Account receiver) {
        System.out.println("ImmediateSameBank");
        System.out.println("From sender: " + sender.getName() + " to receiver: " + receiver.getName());
    }
}
