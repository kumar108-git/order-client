package org.com.orders.controller;

import org.com.orders.model.CustomerRequestDTO;
import org.com.orders.model.CustomerResponseDTO;
import org.com.orders.services.CustomerServiceClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerContoller {

    @Autowired
    CustomerServiceClientImpl customerServiceClient;

    @PostMapping
    public CustomerResponseDTO createCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){
        return customerServiceClient.createCustomer(customerRequestDTO);
    }

    @GetMapping("/{customerId}")
    public CustomerResponseDTO getCustomer(@PathVariable Integer customerId){
        return customerServiceClient.getCustomerById(customerId);
    }

    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer customerId){
        customerServiceClient.deleteCustomer(customerId);
        return ResponseEntity.noContent().build();
    }

}
