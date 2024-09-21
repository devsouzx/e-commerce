package com.devsouzx.ecommerce.controllers;

import com.devsouzx.ecommerce.model.Order;
import com.devsouzx.ecommerce.model.OrderProduct;
import com.devsouzx.ecommerce.requests.OrderProductRequestDTO;
import com.devsouzx.ecommerce.requests.OrderRequestDTO;
import com.devsouzx.ecommerce.responses.OrderResponseDTO;
import com.devsouzx.ecommerce.services.address.IAddressService;
import com.devsouzx.ecommerce.services.brand.IBrandService;
import com.devsouzx.ecommerce.services.category.ICategoryService;
import com.devsouzx.ecommerce.services.order.IOrderService;
import com.devsouzx.ecommerce.services.product.IProductService;
import com.devsouzx.ecommerce.services.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private IProductService productService;

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IAddressService addressService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBrandService brandService;

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
