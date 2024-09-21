package com.devsouzx.ecommerce.responses;

import com.devsouzx.ecommerce.model.Order;
import com.devsouzx.ecommerce.model.OrderStatus;
import com.devsouzx.ecommerce.services.brand.IBrandService;
import com.devsouzx.ecommerce.services.category.ICategoryService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record OrderResponseDTO(UUID id, LocalDateTime moment, OrderStatus status, UserResponseDTO user, AddressResponseDTO address, List<OrderProductResponseDTO> items, BigDecimal total) {
    public OrderResponseDTO(Order order, ICategoryService categoryService, IBrandService brandService) {
        this(order.getId(), order.getMoment(), order.getStatus(), new UserResponseDTO(order.getUser()), new AddressResponseDTO(order.getAddress()), order.getItems().stream().map(item -> new OrderProductResponseDTO(new ProductResponseDTO(item.getProduct(), categoryService, brandService), item.getQuantity(), item.getSubTotal())).toList(), order.getTotal());
    }
}
