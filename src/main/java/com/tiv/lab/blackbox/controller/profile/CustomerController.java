package com.tiv.lab.blackbox.controller.profile;

import com.tiv.lab.blackbox.model.profile.Customer;
import com.tiv.lab.blackbox.service.profile.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    @Autowired(required = false)
    private CustomerService customerService;

    @ResponseBody
    @RequestMapping(name = "customer", method = RequestMethod.POST)
    ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer result = customerService.saveCustomer(customer);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
