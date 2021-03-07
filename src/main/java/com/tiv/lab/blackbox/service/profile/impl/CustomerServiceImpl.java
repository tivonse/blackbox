package com.tiv.lab.blackbox.service.profile.impl;

import com.tiv.lab.blackbox.model.Customer;
import com.tiv.lab.blackbox.repository.jpa.CustomerRepository;
import com.tiv.lab.blackbox.service.profile.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
