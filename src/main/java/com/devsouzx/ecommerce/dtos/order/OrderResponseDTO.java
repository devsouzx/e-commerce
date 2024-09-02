package com.devsouzx.ecommerce.dtos.order;

import com.devsouzx.ecommerce.domain.order.Order;
import com.devsouzx.ecommerce.domain.order.OrderStatus;
import com.devsouzx.ecommerce.dtos.address.AddressResponseDTO;
import com.devsouzx.ecommerce.dtos.product.ProductResponseDTO;
import com.devsouzx.ecommerce.dtos.user.UserResponseDTO;
import com.devsouzx.ecommerce.services.BrandService;
import com.devsouzx.ecommerce.services.CategoryService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record OrderResponseDTO(UUID id, LocalDateTime moment, OrderStatus status, UserResponseDTO user, AddressResponseDTO address, List<OrderProductResponseDTO> items, BigDecimal total) {
    public OrderResponseDTO(Order order, CategoryService categoryService, BrandService brandService) {
        this(order.getId(), order.getMoment(), order.getStatus(), new UserResponseDTO(order.getUser()), new AddressResponseDTO(order.getAddress()), order.getItems().stream().map(item -> new OrderProductResponseDTO(new ProductResponseDTO(item.getProduct(), categoryService, brandService), item.getQuantity(), item.getSubTotal())).toList(), order.getTotal());
    }
}
