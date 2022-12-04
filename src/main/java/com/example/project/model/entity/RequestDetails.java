package com.example.project.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class RequestDetails {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "brand_product_id", nullable = false)
    private BrandProduct brandProduct;

    @ManyToOne(optional = false)
    @JoinColumn(name = "request_id", nullable = false)
    private Request request;

    @Column(name = "product_qty", nullable = false)
    private int productQty;

    @Transient
    private int total;

    @Column(name = "is_completed", nullable = false)
    private Boolean isDelivered = false;

}
