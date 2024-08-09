package org.com.orders.services;

import org.com.orders.model.CustomerRequestDTO;
import org.com.orders.model.CustomerResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerServiceClientImpl implements CustomerServiceClient{

    @Autowired
    private RestTemplate restTemplate;

    @Value("${order-service.base-url}")
    private String baseUrl;

    @Override
    public CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO) {
        String url = baseUrl+ "/customers";
        return restTemplate.postForObject(url,customerRequestDTO,CustomerResponseDTO.class);
    }

    @Override
    public CustomerResponseDTO getCustomerById(Integer customerId) {
        String url = baseUrl +"/customers/"+customerId;
        return restTemplate.getForObject(url,CustomerResponseDTO.class);
    }

    @Override
    public void deleteCustomer(Integer customerId){
        String url = baseUrl + "/customers/delete/"+customerId;
        restTemplate.delete(url);
    }

}
