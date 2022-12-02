/*
package com.example.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.Account;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Configuration
    @Order(1)
    public static class App1ConfigAdapter{
        @Bean
        public SecurityFilterChain app1FilterChain(HttpSecurity httpSecurity)throws Exception{
            httpSecurity.antMatcher("/store*").authorizeRequests().anyRequest().hasRole("ADMIN")
                    .and().csrf().disable();
            return httpSecurity.build();
        }

//        @Bean
//        public UserDetailsService app1UserDetailsService(){
//            UserDetails user = Account.withUsername().
//        }
    }

    @Configuration
    @Order(2)
    public static class App2ConfigAdapter{
        @Bean
        public SecurityFilterChain app2FilterChain(HttpSecurity httpSecurity) throws Exception{
            httpSecurity.antMatcher("/brand*").authorizeRequests().anyRequest().hasRole("BRAND")
                    .and().csrf().disable();
            return httpSecurity.build();
        }
    }
}
*/
