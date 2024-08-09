package org.com.orders.services;

import org.com.orders.model.OrdersRequestDTO;
import org.com.orders.model.OrdersResponseDTO;

public interface OrderServiceClient {
    public OrdersResponseDTO createOrder(OrdersRequestDTO ordersRequestDTO);
    public void deleteOrder(Integer orderId);
    public OrdersResponseDTO getOrderById(Integer orderId);
    public OrdersResponseDTO getAllOrders();
    public OrdersResponseDTO getOrdersByCustomerId(Integer customerId);
}
