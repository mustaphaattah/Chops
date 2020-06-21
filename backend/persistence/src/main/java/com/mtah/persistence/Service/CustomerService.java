package com.mtah.persistence.Service;

import com.mtah.model.Customer;
import com.mtah.persistence.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService extends EntityService<Customer, Long>{

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

    @Override
    public void deleteById(Long anId) {
        customerRepository.deleteById(anId);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}
