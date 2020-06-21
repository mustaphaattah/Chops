package com.mtah.persistence.Service;

import com.mtah.model.Customer;
import com.mtah.persistence.Repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    Customer customer;
    Long id = 3L;

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerService customerService;

    @BeforeEach
    void setUp(){
        customer = new Customer().builder().build();
        customer.setId(id);
    }

    @Test
    void findAll() {
        List<Customer> customers = new ArrayList<>();
        customers.add(customer);

        when(customerRepository.findAll()).thenReturn(customers);
        customerService.findAll();
        verify(customerRepository).findAll();

        assertEquals(customers.size(), 1);
    }

    @Test
    void findById() {
        when(customerRepository.findById(anyLong()))
                .thenReturn(Optional.of(customer));

        Customer foundCustomer =  customerService.findById(4L);
        verify(customerRepository).findById(anyLong());

        assertEquals(customer.getId(), foundCustomer.getId());
    }

    @Test
    void deleteById() {
        customerService.deleteById(8L);
        verify(customerRepository, times(1))
                .deleteById(anyLong());
    }

    @Test
    void save() {
        when(customerRepository.save(any(Customer.class)))
                .thenReturn(customer);

        Customer savedCustomer = customerService.save(customer);
        verify(customerRepository).save(any(Customer.class));

        assertEquals(customer.getId(), savedCustomer.getId());
    }
}