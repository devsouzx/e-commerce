package com.devsouzx.ecommerce.domain.order;

import com.devsouzx.ecommerce.domain.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Table(name = "order_product")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private Integer quantity;
    private BigDecimal price;

    public OrderProduct(Order order, Product product, Integer quantity) {
        this.order = order;
        this.price = product.getPrice();
        this.quantity = quantity;
        this.product = product;
    }

    public BigDecimal getSubTotal() {
        BigDecimal quantityBigDecimal = new BigDecimal(quantity);
        return quantityBigDecimal.multiply(price);
    }
}
