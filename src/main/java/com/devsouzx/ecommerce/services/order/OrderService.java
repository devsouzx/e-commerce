package com.devsouzx.ecommerce.services.order;

import com.devsouzx.ecommerce.model.Order;
import com.devsouzx.ecommerce.model.OrderProduct;
import com.devsouzx.ecommerce.repositories.OrderProductRepository;
import com.devsouzx.ecommerce.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Override
    public OrderProduct saveOrderProduct(OrderProduct orderProduct) {
        return orderProductRepository.save(orderProduct);
    }

    @Override
    public List<OrderProduct> findOrderProductByOrder(Order order) {
        return orderProductRepository.findByOrder(order);
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order findOrderById(UUID id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found!"));
    }
}
