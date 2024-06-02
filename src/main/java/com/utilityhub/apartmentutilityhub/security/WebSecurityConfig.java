package com.utilityhub.apartmentutilityhub.security;


import com.utilityhub.apartmentutilityhub.service.impl.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class    WebSecurityConfig {

    @Bean
    UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/","/error", "/event/**", "/css/**", "/home", "/templates/**", "/information/**", "/api/apartmentdata/**").hasAnyAuthority("USER", "ACCOUNTANT", "ADMIN")
                        .requestMatchers( "/event/**", "/apartment/**").hasAnyAuthority("ACCOUNTANT", "ADMIN")
                        .requestMatchers("/**").hasAnyAuthority("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login.permitAll())
                .logout(logout -> logout.permitAll())
                .exceptionHandling(eh -> eh.accessDeniedPage("/error")); //403

        return http.build();

    }
}
