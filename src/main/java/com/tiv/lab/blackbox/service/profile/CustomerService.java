package com.tiv.lab.blackbox.service.profile;

import com.tiv.lab.blackbox.model.profile.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    Customer saveCustomer(Customer customer);
}
