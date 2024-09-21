package com.devsouzx.ecommerce.services.order;

import com.devsouzx.ecommerce.domain.order.Order;
import com.devsouzx.ecommerce.domain.order.OrderProduct;

import java.util.List;
import java.util.UUID;

public interface IOrderService {
    OrderProduct saveOrderProduct(OrderProduct orderProduct);
    List<OrderProduct> findOrderProductByOrder(Order order);
    void save(Order order);
    List<Order> findAllOrders();
    Order findOrderById(UUID id);
}
