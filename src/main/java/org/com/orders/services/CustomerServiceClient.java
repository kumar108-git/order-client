package org.com.orders.services;

import org.com.orders.model.CustomerRequestDTO;
import org.com.orders.model.CustomerResponseDTO;

public interface CustomerServiceClient {
    CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO getCustomerById(Integer customerId);
    void deleteCustomer(Integer customerId);
}
