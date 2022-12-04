package com.example.project.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter @Setter
public class Storage {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "product_qty", nullable = false)
    private int productQty;

    @OneToMany(mappedBy = "storage", orphanRemoval = true)
    private Set<Request> requests = new LinkedHashSet<>();

    @OneToMany(mappedBy = "storage", orphanRemoval = true)
    private Set<BrandProduct> brandProducts = new LinkedHashSet<>();

    @Column(name = "brand_product_qty", nullable = false)
    private int brandProductQty;

}
