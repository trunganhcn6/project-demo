package com.example.project.config;

import com.example.project.model.entity.BAccDetailsServiceImpl;
import com.example.project.model.entity.SAccDetailsServiceImpl;
import com.example.project.jwt.AuthTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;

/*https://www.baeldung.com/spring-security-two-login-pages*/
//@EnableGlobalMethodSecurity(prePostEnabled = true) //securedEnabled = true)
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Configuration
    @Order(2)
    public class StoreConfigAdapter {
        @Autowired
        SAccDetailsServiceImpl sAccDetailsService;

        @Bean
        public BCryptPasswordEncoder storeEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Bean
        public AuthTokenFilter storeAuthTokenFilter() {
            return new AuthTokenFilter();
        }

        public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
            authenticationManagerBuilder.userDetailsService(sAccDetailsService).passwordEncoder(storeEncoder());
        }

//        @Bean
//        public AuthenticationManager authenticationManagerBean() throws Exception {
//            return super.authenticationManagerBean();
//        }

        //Retrieve Store information from DB
        @Bean
        public DaoAuthenticationProvider storeAuthenProvider() {
            DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
            authProvider.setUserDetailsService(sAccDetailsService);

            //If not set, the password will be compared using PasswordEncoderFactories.createDelegatingPasswordEncoder()
            authProvider.setPasswordEncoder(storeEncoder());
            return authProvider;
        }

        @Bean
        public SecurityFilterChain storeFilterChain(HttpSecurity http) throws Exception {
            http.cors().and().csrf().disable()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and().authorizeRequests()
                    .antMatchers("/store-login").permitAll()
                    .antMatchers("/store*")
                    .hasRole("STORE")
                    //Optional?
                    .anyRequest().authenticated();

            http.authenticationProvider(storeAuthenProvider());

            http.addFilterBefore(storeAuthTokenFilter(), UsernamePasswordAuthenticationFilter.class);
            return http.build();
        }
    }

    @Configuration
    @Order(1)
    public class BrandConfigAdapter {
        @Autowired
        BAccDetailsServiceImpl bAccDetailsService;

        @Bean
        public BCryptPasswordEncoder brandEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Bean
        public AuthTokenFilter brandAuthTokenFilter() {
            return new AuthTokenFilter();
        }

        public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
            authenticationManagerBuilder.userDetailsService(bAccDetailsService).passwordEncoder(brandEncoder());
        }

        //Retrieve Brand information from DB
        @Bean
        public DaoAuthenticationProvider brandAuthenProvider() {
            DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
            authProvider.setUserDetailsService(bAccDetailsService);

            authProvider.setPasswordEncoder(brandEncoder());
            return authProvider;
        }

       private final String[] doNotCheck = {"/login/*"/*, "/store/users", "/brand/users", "/store**", "/brand**"*/};

        @Bean
        public SecurityFilterChain brandFilterChain(HttpSecurity http) throws Exception {
            http.cors().and().csrf().disable()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and().authorizeRequests()
                    .antMatchers(doNotCheck).permitAll()
                    .antMatchers("/brand*")
                    .hasRole("BRAND")
                    //Optional?
                    .anyRequest().authenticated();

            http.authenticationProvider(brandAuthenProvider());

            http.addFilterBefore(brandAuthTokenFilter(), UsernamePasswordAuthenticationFilter.class);

            return http.build();
        }
    }

    /************************************************************************************************************************/

//    private final String[] doNotCheck = {"/login/*", "/store/users", "/brand/users", "/store**", "/brand**"};

/*    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers(doNotCheck).permitAll()
//                .antMatchers("/store/storage").hasAnyRole("STORE")
                .anyRequest().authenticated();

        http.authenticationProvider(authenticationProvider());

        http.addFilterBefore(authTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }*/
}
