package com.mtah.persistence.Service;

import com.mtah.model.Customer;
import com.mtah.persistence.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository cr) {
        this.customerRepository = cr;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(Long anId) {
        return customerRepository.findById(anId).orElse(null);
    }

    public void deleteById(Long anId) {
        customerRepository.deleteById(anId);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}
