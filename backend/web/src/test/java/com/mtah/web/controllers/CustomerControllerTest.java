package com.mtah.web.controllers;

import com.google.gson.Gson;
import com.mtah.model.Customer;
import com.mtah.model.Order.Order;
import com.mtah.persistence.Service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.JsonPath;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

    @Mock
    CustomerService customerService;

    @InjectMocks
    CustomerController controller;

    MockMvc mockMvc;

    Customer customer;
    Gson gson = new Gson();
    final Long customerId = 3L;
    final Long orderId = 2L;
    final String customerName = "Nura";
    final String customerEmail = "nursh@gmail.ca";
    final String customerPassword = "shh";

    @BeforeEach
    void setUp(){
        customer = Customer
                .builder()
                .build();
        customer.setId(customerId);
        customer.setUsername(customerName);
        customer.setPassword(customerPassword);
        customer.setEmail(customerEmail);


        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

    @Test
    void createCustomer() throws Exception {
        when(customerService.save(any(Customer.class))).thenReturn(customer);

        mockMvc.perform(post("/customers")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(customer)))

                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(customer.getId()));

        verify(customerService).save(any(Customer.class));
    }

    @Test
    void deleteCustomer() throws Exception {
        mockMvc.perform(delete("/customers/{id}", customerId))
                .andExpect(status().isOk());

        verify(customerService, times(1)).deleteById(anyLong());
    }

    @Test
    void updateCustomer() throws Exception {
        when(customerService.update(anyLong(), anyMap())).thenReturn(customer);

        List<Order> orders = new ArrayList<>();
        Order order = Order.builder().build();
        orders.add(order);

        Map<String, Object> updates = new HashMap<>();
        updates.put("orders", orders);

        mockMvc.perform(patch("/customers/{id}", customerId)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(updates)))

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(customer.getId()));

        verify(customerService).update(anyLong(), anyMap());
    }

    @Test
    void findCustomer() throws Exception{
        when(customerService.findById(anyLong())).thenReturn(customer);

        mockMvc.perform(get("/customers/{id}", customerId)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(customer.getId()));

        verify(customerService).findById(anyLong());
    }
}

