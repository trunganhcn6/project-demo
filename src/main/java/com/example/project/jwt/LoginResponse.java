package com.example.project.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/* Response after login successfully */
@AllArgsConstructor
public class LoginResponse {
    @Getter
    @Setter
    private String token;
    @Getter @Setter
    private Integer id;
    @Getter @Setter
    private String username;
    @Getter @Setter
    private String email;
    @Getter
    private List<String> role;

}

