package com.example.project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter @Setter
public class Brand {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 5, max = 100)
    @Column(unique = true)
    @NotBlank
    private String name;

    @OneToMany(mappedBy = "brand", orphanRemoval = true)
    private Set<Account> accounts = new LinkedHashSet<>();

    @Size(min = 5, max = 100)
    @NotBlank
    @Column(name = "address", nullable = false, unique = true)
    private String address;

}
