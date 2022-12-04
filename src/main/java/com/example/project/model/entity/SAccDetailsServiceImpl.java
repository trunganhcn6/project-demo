package com.example.project.model.entity;

import com.example.project.repository.StoreAccRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

/* Check StoreAcc Info in DB */
public class SAccDetailsServiceImpl implements UserDetailsService {
    @Autowired
    StoreAccRepository storeAccRepos;

    @Override @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        StoreAcc storeAcc = storeAccRepos.findByUsername(username);
        if (storeAcc == null){
            throw new UsernameNotFoundException("Cannot find StoreAcc " + username);
        }
        return new SAccDetailsImpl(storeAcc);
    }
}
