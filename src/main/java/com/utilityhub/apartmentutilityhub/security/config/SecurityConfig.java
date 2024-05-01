package com.utilityhub.apartmentutilityhub.security.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

/*
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {

        // Define UserDetails for "admin" with username, password and roles
        UserDetails admin = User.withUsername("admin")
                .password(encoder.encode("12345678"))
                .roles("ADMIN", "USER")
                .build();

        // Define UserDetails for "user" with username, password and roles
        UserDetails user = User.withUsername("boby")
                .password(encoder.encode("1234"))
                .roles("USER")
                .build();

        // Pass in all users for return
        return new InMemoryUserDetailsManager(admin,user);
    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {

        return http.csrf().disable()
                .authorizeHttpRequests() // Start configuring authorization
                .requestMatchers("/auth/welcome").permitAll() // Allow access to all
                .and()
                .authorizeHttpRequests().requestMatchers("/auth/user/**").authenticated() // Require authentication for any user path
                .and()
                .authorizeHttpRequests().requestMatchers("/auth/admin/**").authenticated() // Require authentication for any admin path
                .and().formLogin()
                .and().build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
*/



    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {

        // Define UserDetails for "user" with username, password and roles
        UserDetails propertyOwner = User.withUsername("nipi")
                .password(encoder.encode("nipi"))
                .roles("PROPERTY OWNER")
                .build();

        // Define UserDetails for "accountant" with username, password and roles
        UserDetails accountant = User.withUsername("acc")
                .password(encoder.encode("acc"))
                .roles("ACCOUNTANT")
                .build();

        // Define UserDetails for "admin" with username, password and roles
        UserDetails admin = User.withUsername("admin")
                .password(encoder.encode("admin"))
                .roles("ADMIN", "ACCOUNTANT", "PROPERTY OWNER")
                .build();

        // Pass in all users for return
        return new InMemoryUserDetailsManager(propertyOwner,accountant,admin);
    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {

        return http.csrf().disable()
                .authorizeHttpRequests() // Start configuring authorization
                .requestMatchers("/auth/welcome").permitAll() // Allow access to all
                .and()
                .authorizeHttpRequests().requestMatchers("/auth/user/**").authenticated() // Require authentication for any user path
                .and()
                .authorizeHttpRequests().requestMatchers("/auth/admin/**").authenticated() // Require authentication for any admin path
                .and().formLogin()
                .and().build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
