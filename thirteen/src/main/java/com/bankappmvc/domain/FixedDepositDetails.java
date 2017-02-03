package com.bankappmvc.domain;


import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

public class FixedDepositDetails implements Serializable {
    private static final long serialVersionUID = -8363144927181713477L;
    private int fixedDepositId;
    private int bankAccountId;

    @NotNull
    private Date fdCreationDate;

    @Min(1000)
    @Max(500000)
    private int fdAmount;

    @Min(12)
    @Max(60)
    private int tenure;
    private String active;

    @Email
    @Size(min = 10, max = 25)
    private String email;

    public FixedDepositDetails() {
        bankAccountId = 1;
        fdCreationDate = new Date();
        active = "N";
    }

    public int getFixedDepositId() {
        return fixedDepositId;
    }

    public void setFixedDepositId(int fixedDepositId) {
        this.fixedDepositId = fixedDepositId;
    }

    public int getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(int bankAccountId) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "FixedDepositDetails [fixedDepositId=" + fixedDepositId
                + ", bankAccountId=" + bankAccountId + ", fdCreationDate="
                + fdCreationDate + ", fdAmount=" + fdAmount + ", tenure="
                + tenure + ", active=" + active + "]";
    }
}
