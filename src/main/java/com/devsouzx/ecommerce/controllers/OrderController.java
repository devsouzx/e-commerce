package com.devsouzx.ecommerce.controllers;

import com.devsouzx.ecommerce.domain.order.Order;
import com.devsouzx.ecommerce.domain.order.OrderProduct;
import com.devsouzx.ecommerce.dtos.order.OrderProductRequestDTO;
import com.devsouzx.ecommerce.dtos.order.OrderRequestDTO;
import com.devsouzx.ecommerce.dtos.order.OrderResponseDTO;
import com.devsouzx.ecommerce.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO body) {
        Order order = new Order(userService.findById(body.userId()), addressService.findById(body.addressId()));
        orderService.save(order);
        for (OrderProductRequestDTO item : body.items()) {
            OrderProduct orderProduct = new OrderProduct(order, productService.findById(item.productId()), item.quantity());
            orderService.saveOrderProduct(orderProduct);
        }
        return ResponseEntity.ok(new OrderResponseDTO(order, categoryService, brandService));
    }
}
