package org.com.orders.controller;


import org.com.orders.model.OrdersRequestDTO;
import org.com.orders.model.OrdersResponseDTO;
import org.com.orders.services.OrderServiceClient;
import org.com.orders.services.OrderServiceClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderServiceClientImpl orderServiceClient;

    @PostMapping
    public OrdersResponseDTO createOrder(@RequestBody OrdersRequestDTO ordersRequestDTO){
        return orderServiceClient.createOrder(ordersRequestDTO);
    }

    @GetMapping("/{orderId}")
    public OrdersResponseDTO getOrderByOrderId(@PathVariable Integer orderId){
        return orderServiceClient.getOrderById(orderId);
    }

    @GetMapping("/all")
    public OrdersResponseDTO getAllOrders(){
        return orderServiceClient.getAllOrders();
    }

    @GetMapping("/customer/{customerId}")
    public OrdersResponseDTO getOrderByCustomerId(@PathVariable Integer customerId){
        return orderServiceClient.getOrdersByCustomerId(customerId);
    }

    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer orderId){
        orderServiceClient.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }

}
