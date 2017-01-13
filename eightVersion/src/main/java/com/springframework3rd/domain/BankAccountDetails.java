package com.springframework3rd.domain;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "BankAccountDetails")
@Table(name = "bank_account_details")
public class BankAccountDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int accountId;

    @Column(name = "balance_amount")
    private int balanceAmount;

    @Column(name = "last_transaction_ts")
    private Date lastTransactionTimestamp;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(int balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public Date getLastTransactionTimestamp() {
        return lastTransactionTimestamp;
    }

    public void setLastTransactionTimestamp(Date lastTransactionTimestamp) {
        this.lastTransactionTimestamp = lastTransactionTimestamp;
    }
}
