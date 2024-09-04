package com.test.springsecuritytest.service;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

import static org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder;

@Component
public class UserDetailService {
    @Bean
    public UserDetailsService users() {
        // The builder will ensure the passwords are encoded before saving in memory
        UserBuilder users = withDefaultPasswordEncoder();
        UserDetails test = users
                .username("test")
                .password("123456")
                .roles("USER")
                .build();
        UserDetails user = users
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        UserDetails admin = users
                .username("admin")
                .password("password")
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin, test);
    }
}
