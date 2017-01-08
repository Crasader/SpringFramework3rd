package com.springframework3rd.service;

import com.springframework3rd.domain.Account;

public interface IFundTransferService {
    void transferFunds(Account sender, Account receiver);
}
