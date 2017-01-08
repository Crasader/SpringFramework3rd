package com.springframework3rd.service;

import com.springframework3rd.domain.CustomerRegistrationDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("customerRegistrationService")
@Qualifier("service")
public class CustomerRegistrationService implements ICustomerRegistrationService{
    private CustomerRegistrationDetails customerRegistrationDetails;

    @Autowired
    public void obtainCustomerRegistrationDetails(CustomerRegistrationDetails customerRegistrationDetails) {
        this.customerRegistrationDetails = customerRegistrationDetails;
    }

    @Override
    public void setAccountNumber(String accountNumber) {
        customerRegistrationDetails.setAccountNumber(accountNumber);
    }
}
