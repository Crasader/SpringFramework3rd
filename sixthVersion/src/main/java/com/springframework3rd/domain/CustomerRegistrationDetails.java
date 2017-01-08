package com.springframework3rd.domain;

import org.springframework.stereotype.Component;

@Component(value = "customerRegistrationDetails")
public class CustomerRegistrationDetails {
    private String accountNumber;

    public void setAccountNumber(final String accountNumber) {
        System.out.println("CustomerRegistrationDetails setAccountNumber");
        System.out.println("Account number: " + accountNumber);
        this.accountNumber = accountNumber;
    }
}
