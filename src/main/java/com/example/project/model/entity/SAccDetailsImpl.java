package com.example.project.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/* By default, Spring Security uses UserDetails to store all user info (incl. storeAcc status), so SAccDetailsImpl -> StoreAcc info */
@AllArgsConstructor @Data
public class SAccDetailsImpl implements UserDetails {
    private StoreAcc storeAcc;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
            return Collections.singleton(new SimpleGrantedAuthority("STORE"));
    }

    @Override
    public String getPassword() {
        return storeAcc.getPassword();
    }

    @Override
    public String getUsername() {
        return storeAcc.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
