package com.example.project.controller;

import com.example.project.dto.AccountDto;
import com.example.project.entity.AccountDetailsImpl;
import com.example.project.jwt.JwtProvider;
import com.example.project.repository.AccountRepository;
import com.example.project.repository.BrandRepository;
import com.example.project.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping()
public class AccountController {
    /* authenticate { username, password }
    update SecurityContext using Authentication object
    generate JWT
    get UserDetails from Authentication object
    response contains JWT and UserDetails data */
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    StoreRepository storeRepository;

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    /************************************************************************************************************************/

    @PostMapping("/login")
    public String authenticate(@RequestBody AccountDto accountDto){
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(accountDto.getUsername(), accountDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        AccountDetailsImpl accountDetails = (AccountDetailsImpl) authentication.getPrincipal();

        String role = accountDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toString();

        //String jwt = jwtProvider.
    }
}
