/*
package com.example.project.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter @Setter
@Table(name = "brand_account")
public class BrandAccount {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    @NotBlank
    private String username;

    @Size(min = 5, max = 30)
    @Column(nullable = false)
    @NotBlank @NotNull
    private String password;

    @Email
    @Column(nullable = false, unique = true)
    @NotBlank @NotNull
    private String email;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;


}
*/
