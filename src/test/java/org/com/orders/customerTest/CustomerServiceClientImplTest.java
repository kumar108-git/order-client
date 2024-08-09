package org.com.orders.customerTest;

import org.com.orders.model.CustomerRequestDTO;
import org.com.orders.model.CustomerResponseDTO;
import org.com.orders.services.CustomerServiceClientImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerServiceClientImplTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private CustomerServiceClientImpl customerServiceClient;

    private final String baseUrl = "http://localhost:8080";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ReflectionTestUtils.setField(customerServiceClient, "baseUrl", baseUrl);
    }

    @Test
    void createCustomer_shouldReturnCustomerResponseDTO() {
        // Arrange
        CustomerRequestDTO requestDTO = new CustomerRequestDTO();
        requestDTO.setFirstName("John");
        requestDTO.setLastName("Doe");
        requestDTO.setEmail("john.doe@example.com");
        requestDTO.setPhoneNumber("1234567890");
        requestDTO.setRegistrationDate(new Date());

        CustomerResponseDTO expectedResponseDTO = new CustomerResponseDTO();
        expectedResponseDTO.setCustomerId(1);
        expectedResponseDTO.setFirstName("John");
        expectedResponseDTO.setLastName("Doe");
        expectedResponseDTO.setEmail("john.doe@example.com");
        expectedResponseDTO.setPhoneNumber("1234567890");
        expectedResponseDTO.setRegistrationDate(requestDTO.getRegistrationDate());

        when(restTemplate.postForObject(eq(baseUrl + "/customers"), eq(requestDTO), eq(CustomerResponseDTO.class)))
                .thenReturn(expectedResponseDTO);

        // Act
        CustomerResponseDTO result = customerServiceClient.createCustomer(requestDTO);

        // Assert
        assertNotNull(result);
        assertEquals(expectedResponseDTO.getCustomerId(), result.getCustomerId());
        assertEquals(expectedResponseDTO.getFirstName(), result.getFirstName());
        assertEquals(expectedResponseDTO.getLastName(), result.getLastName());
        assertEquals(expectedResponseDTO.getEmail(), result.getEmail());
        assertEquals(expectedResponseDTO.getPhoneNumber(), result.getPhoneNumber());
        assertEquals(expectedResponseDTO.getRegistrationDate(), result.getRegistrationDate());

        verify(restTemplate, times(1)).postForObject(eq(baseUrl + "/customers"), eq(requestDTO), eq(CustomerResponseDTO.class));
    }

    @Test
    void getCustomerById_shouldReturnCustomerResponseDTO() {
        // Arrange
        Integer customerId = 1;
        CustomerResponseDTO expectedResponseDTO = new CustomerResponseDTO();
        expectedResponseDTO.setCustomerId(customerId);
        expectedResponseDTO.setFirstName("John");
        expectedResponseDTO.setLastName("Doe");
        expectedResponseDTO.setEmail("john.doe@example.com");
        expectedResponseDTO.setPhoneNumber("1234567890");
        expectedResponseDTO.setRegistrationDate(new Date());

        when(restTemplate.getForObject(eq(baseUrl + "/customers/" + customerId), eq(CustomerResponseDTO.class)))
                .thenReturn(expectedResponseDTO);

        // Act
        CustomerResponseDTO result = customerServiceClient.getCustomerById(customerId);

        // Assert
        assertNotNull(result);
        assertEquals(expectedResponseDTO.getCustomerId(), result.getCustomerId());
        assertEquals(expectedResponseDTO.getFirstName(), result.getFirstName());
        assertEquals(expectedResponseDTO.getLastName(), result.getLastName());
        assertEquals(expectedResponseDTO.getEmail(), result.getEmail());
        assertEquals(expectedResponseDTO.getPhoneNumber(), result.getPhoneNumber());
        assertEquals(expectedResponseDTO.getRegistrationDate(), result.getRegistrationDate());

        verify(restTemplate, times(1)).getForObject(eq(baseUrl + "/customers/" + customerId), eq(CustomerResponseDTO.class));
    }

    @Test
    void deleteCustomer_shouldCallRestTemplateDelete() {
        // Arrange
        Integer customerId = 1;

        // Act
        customerServiceClient.deleteCustomer(customerId);

        // Assert
        verify(restTemplate, times(1)).delete(eq(baseUrl + "/customers/delete/" + customerId));
    }
}