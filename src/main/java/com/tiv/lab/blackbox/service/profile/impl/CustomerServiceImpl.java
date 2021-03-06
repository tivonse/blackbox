package com.tiv.lab.blackbox.service.profile.impl;

import com.tiv.lab.blackbox.model.profile.Customer;
import com.tiv.lab.blackbox.repository.jpa.CustomerRepository;
import com.tiv.lab.blackbox.service.profile.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceImpl implements CustomerService {

    @Autowired(required = false)
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
