package com.example.project.controller;

import com.example.project.model.dto.StoreAccDto;
import com.example.project.model.entity.SAccDetailsImpl;
import com.example.project.jwt.JwtProvider;
import com.example.project.repository.StoreAccRepository;
import com.example.project.repository.BrandRepository;
import com.example.project.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/store")
public class StoreAccController {
    /* authenticate { username, password }
    update SecurityContext using Authentication object
    generate JWT
    get UserDetails from Authentication object
    response contains JWT and UserDetails data */
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    StoreAccRepository storeAccRepository;

    @Autowired
    StoreRepository storeRepository;

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    /************************************************************************************************************************/

    @PostMapping("/store-login")
    public ResponseEntity<?> authenticate(@RequestBody StoreAccDto storeAccDto){
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(storeAccDto.getUsername(), storeAccDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        SAccDetailsImpl sAccDetails = (SAccDetailsImpl) authentication.getPrincipal();

        String role = sAccDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toString();
        //List<String> role = sAccDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();

        String jwt = jwtProvider.generateStoreJwt(authentication);

        return ResponseEntity.ok(jwt);
    }
}
