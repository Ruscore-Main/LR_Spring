package com.example.Bikbaev4219.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long orderId;
    @Column(name = "product_type")
    private String productType;
    @Transient
    private String orderProgress;
}
