package org.com.orders.services;

import org.com.orders.model.OrdersRequestDTO;
import org.com.orders.model.OrdersResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceClientImpl implements OrderServiceClient{

    @Autowired
    RestTemplate restTemplate;

    @Value("${order-service.base-url}")
    private String baseUrl;

    @Override
    public OrdersResponseDTO createOrder(OrdersRequestDTO ordersRequestDTO) {
        String url = baseUrl + "/order";
        return restTemplate.postForObject(url,ordersRequestDTO,OrdersResponseDTO.class);
    }

    @Override
    public void deleteOrder(Integer orderId) {
        String url = baseUrl + "/orders/delete/" + orderId;
        restTemplate.delete(url);
    }

    @Override
    public OrdersResponseDTO getOrderById(Integer orderId) {
        String url = baseUrl + "/orders/" + orderId;
        return restTemplate.getForObject(url,OrdersResponseDTO.class);
    }

    @Override
    public OrdersResponseDTO getAllOrders() {
        String url = baseUrl + "/orders/all";
        return restTemplate.getForObject(url,OrdersResponseDTO.class);
    }

    @Override
    public OrdersResponseDTO getOrdersByCustomerId(Integer customerId) {
        String url = baseUrl + "/orders/" + customerId;
        return restTemplate.getForObject(url,OrdersResponseDTO.class);
    }
}
