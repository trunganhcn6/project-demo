package com.example.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/* By default, Spring Security uses UserDetails to store all user info (incl. account status), so AccountDetailsImpl -> Account info */
@AllArgsConstructor @Data
public class AccountDetailsImpl implements UserDetails {
    private Account account;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (account.getStore() != null && account.getBrand() == null)
            return Collections.singleton(new SimpleGrantedAuthority("STORE"));
        else if (account.getStore() == null && account.getBrand() != null)
            return Collections.singleton(new SimpleGrantedAuthority("BRAND"));
        else return null;
    }

    @Override
    public String getPassword() {
        return account.getPassword();
    }

    @Override
    public String getUsername() {
        return account.getUsername();
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
