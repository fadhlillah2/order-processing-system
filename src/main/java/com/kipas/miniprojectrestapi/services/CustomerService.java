package com.kipas.miniprojectrestapi.services;

import com.kipas.miniprojectrestapi.entities.Customer;
import com.kipas.miniprojectrestapi.exceptions.ResourceNotFoundException;
import com.kipas.miniprojectrestapi.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomer(UUID id) {
        return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
    }

    //... other methods
}
