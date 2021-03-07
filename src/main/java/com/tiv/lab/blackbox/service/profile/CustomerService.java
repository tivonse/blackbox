package com.tiv.lab.blackbox.service.profile;

import com.tiv.lab.blackbox.model.Customer;
import org.springframework.stereotype.Service;

public interface CustomerService {

    Customer saveCustomer(Customer customer);
}
