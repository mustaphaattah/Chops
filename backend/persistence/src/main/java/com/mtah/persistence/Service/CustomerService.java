package com.mtah.persistence.Service;

import com.mtah.model.Chef;
import com.mtah.model.Customer;
import com.mtah.persistence.Repository.CustomerRepository;
import com.mtah.persistence.exceptions.CustomerNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository cr) {
        this.customerRepository = cr;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer update(Long id, Map<String, Object> updates){
        Customer customer = findById(id);

        if (customer != null){
            updates.forEach((key, value)->{
                Field field = ReflectionUtils.findField(Customer.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, customer, value);
            });

            return customerRepository.save(customer);
        }

        throw new CustomerNotFoundException("Customer with id: " + id + " does not exist.");
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
