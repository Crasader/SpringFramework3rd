package com.springframework3rd.domain;

import org.springframework.stereotype.Component;

@Component(value = "customerRequestDetails")
public class CustomerRequestDetails {
    private String accountNumber;

    public void setAccountNumber(final String accountNumber) {
        System.out.println("CustomerRegistrationDetails setAccountNumber");
        System.out.println("Account number: " + accountNumber);
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "CustomerRequestDetails{" +
                "accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
