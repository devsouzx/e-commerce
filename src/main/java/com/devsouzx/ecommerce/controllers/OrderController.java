package com.devsouzx.ecommerce.controllers;

import com.devsouzx.ecommerce.domain.order.Order;
import com.devsouzx.ecommerce.domain.order.OrderProduct;
import com.devsouzx.ecommerce.dtos.order.OrderProductRequestDTO;
import com.devsouzx.ecommerce.dtos.order.OrderRequestDTO;
import com.devsouzx.ecommerce.dtos.order.OrderResponseDTO;
import com.devsouzx.ecommerce.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BrandService brandService;

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> findAllOrders() {
        List<OrderResponseDTO> orders = orderService.findAllOrders().stream().map(order -> new OrderResponseDTO(order, categoryService, brandService)).toList();
        return ResponseEntity.ok(orders);
    }

    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO body) {
        Order order = new Order(userService.findById(body.userId()), addressService.findById(body.addressId()));
        orderService.save(order);
        for (OrderProductRequestDTO item : body.items()) {
            OrderProduct orderProduct = new OrderProduct(order, productService.findById(item.productId()), item.quantity());
            orderService.saveOrderProduct(orderProduct);
            order.getItems().add(orderProduct);
        }
        orderService.save(order);
        return ResponseEntity.ok(new OrderResponseDTO(order, categoryService, brandService));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> getOrderById(@PathVariable UUID id) {
        Order order = orderService.findOrderById(id);
        return ResponseEntity.ok(new OrderResponseDTO(order, categoryService, brandService));
    }
}
