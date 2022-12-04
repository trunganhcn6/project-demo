package com.example.project.model.entity;

import com.example.project.repository.BrandAccRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

public class BAccDetailsServiceImpl implements UserDetailsService {
    @Autowired
    BrandAccRepository brandAccRepository;

    @Override @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BrandAcc brandAcc = brandAccRepository.findByUsername(username);
        if (brandAcc == null){
            throw new UsernameNotFoundException("Cannot find BrandAcc " + username);
        }
            return new BAccDetailsImpl(brandAcc);
    }
}
