package org.com.orders.services;

import org.com.orders.model.OrdersRequestDTO;
import org.com.orders.model.OrdersResponseDTO;

public interface OrderServiceClient {
    OrdersResponseDTO createOrder(OrdersRequestDTO ordersRequestDTO);
    void deleteOrder(Integer orderId);
    OrdersResponseDTO getOrderById(Integer orderId);
    OrdersResponseDTO getAllOrders();
    OrdersResponseDTO getOrdersByCustomerId(Integer customerId);
}
