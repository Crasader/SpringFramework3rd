package com.springframework3rd.service;

import com.springframework3rd.dao.CustomerRequestDao;
import com.springframework3rd.domain.CustomerRegistrationDetails;
import com.springframework3rd.domain.CustomerRequestDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("customerRequestService")
@Qualifier("service")
public class CustomerRequestService {
    private CustomerRequestDetails customerRequestDetails;
    private CustomerRequestDao customerRequestDao;

    @Autowired
    public CustomerRequestService(CustomerRequestDetails customerRequestDetails,
                                  CustomerRequestDao customerRequestDao) {
        this.customerRequestDetails = customerRequestDetails;
        this.customerRequestDao = customerRequestDao;
    }

    public void run() {
        System.out.println(customerRequestDetails);
        System.out.println(customerRequestDao);
    }
}
