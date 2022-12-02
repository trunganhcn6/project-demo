package com.example.project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter @Setter
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    @Column(name = "username", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "color", orphanRemoval = true)
    private Set<BrandProduct> brandProducts = new LinkedHashSet<>();

}
