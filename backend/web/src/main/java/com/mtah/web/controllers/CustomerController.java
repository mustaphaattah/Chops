package com.mtah.web.controllers;

import com.mtah.model.Chef;
import com.mtah.model.Customer;
import com.mtah.persistence.Service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping({"", "/"})
    public ResponseEntity<?> createCustomer(@Valid @RequestBody Customer customer){
        Customer createdCustomer = customerService.save(customer);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long id,
                                            @Valid @RequestBody Map<String, Object> updates){
        Customer updatedCustomer = customerService.update(id, updates);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id){
        customerService.deleteById(id);
        return new ResponseEntity<>("Delete Success", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findCustomerById(@PathVariable Long id){
        Customer customer = customerService.findById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

}
