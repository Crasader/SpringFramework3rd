package com.springframework3rd.domain;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "FixedDepositDetails")
@Table(name = "fixed_deposit_details")
public class FixedDepositDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fixed_deposit_id")
    private int fixedDepositId;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID", nullable = false)
    private BankAccountDetails bankAccountId;

    @Column(name = "fd_creation_date")
    private Date fdCreationDate;

    @Column(name = "amount")
    private int fdAmount;

    @Column(name = "tenure")
    private int tenure;

    @Column(name = "active")
    private String active;

    public int getFixedDepositId() {
        return fixedDepositId;
    }

    public void setFixedDepositId(int fixedDepositId) {
        this.fixedDepositId = fixedDepositId;
    }

    public BankAccountDetails getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(BankAccountDetails bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public Date getFdCreationDate() {
        return fdCreationDate;
    }

    public void setFdCreationDate(Date fdCreationDate) {
        this.fdCreationDate = fdCreationDate;
    }

    public int getFdAmount() {
        return fdAmount;
    }

    public void setFdAmount(int fdAmount) {
        this.fdAmount = fdAmount;
    }

    public int getTenure() {
        return tenure;
    }

    public void setTenure(int tenure) {
        this.tenure = tenure;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "FixedDepositDetails{" +
                "fixedDepositId=" + fixedDepositId +
                ", bankAccountId=" + bankAccountId +
                ", fdCreationDate=" + fdCreationDate +
                ", fdAmount=" + fdAmount +
                ", tenure=" + tenure +
                ", active='" + active + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        FixedDepositDetails other = (FixedDepositDetails) obj;
        return (other.getFixedDepositId() == this.fixedDepositId);
    }
}
