package com.backpacker.memberorder.entity;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(indexes = {
        @Index(name = "orders_order_number_uindex", columnList = "order_number", unique = true),
        @Index(name = "orders_members_id_fk", columnList = "member_id")
})
public class Orders extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "order_number")
    private String orderNumber;

    @Column(nullable = false, name = "product_name")
    private String productName;

    @Column(nullable = false, name = "payment_date_time")
    private LocalDateTime paymentDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Members members;

}
