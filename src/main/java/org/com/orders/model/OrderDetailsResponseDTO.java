package org.com.orders.model;

import lombok.Data;

@Data
public class OrderDetailsResponseDTO {
    private Integer orderDetailsId;
    private Integer orderId;
    private Integer productId;
    private Integer quantity;
    private double unitPrice;
}
