package com.kipas.miniprojectrestapi.services;

import com.kipas.miniprojectrestapi.entities.Customer;
import com.kipas.miniprojectrestapi.exceptions.ResourceNotFoundException;
import com.kipas.miniprojectrestapi.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    public Customer saveCustomer(Customer customer) {
        log.info("Customer successfully processed: {}", customer);
        return customerRepository.save(customer);
    }

    public Customer getCustomer(UUID id) {
        return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
    }

    //... other methods
}
