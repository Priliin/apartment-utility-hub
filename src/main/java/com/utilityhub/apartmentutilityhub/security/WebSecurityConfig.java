package com.utilityhub.apartmentutilityhub.security;


import com.utilityhub.apartmentutilityhub.dto.UserDTO;
import com.utilityhub.apartmentutilityhub.service.impl.UserDetailsServiceImpl;
import com.utilityhub.apartmentutilityhub.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

                        .requestMatchers("/","/error", "/event/**", "/css/**", "/home",
                                "/templates/**", "/information/**",
                                "/api/apartmentData/**", "/apartment/myApartments/**", "/images/**").hasAnyAuthority("USER", "ACCOUNTANT", "ADMIN")
                        .requestMatchers( "/event/**", "/apartment/**").hasAnyAuthority("ACCOUNTANT", "ADMIN")

                        .requestMatchers("/", "/error", "/css/**", "/home", "/templates/**", "/information/**")
                        .hasAnyAuthority("USER", "ACCOUNTANT", "ADMIN")
                        .requestMatchers("/api/apartmentData/**", "/apartment/myApartments/**")
                        .hasAnyAuthority("USER", "ACCOUNTANT", "ADMIN")
                        .requestMatchers("/event/**").hasAnyAuthority("USER", "ACCOUNTANT", "ADMIN")
                        .requestMatchers("/apartment/**").hasAnyAuthority("ACCOUNTANT", "ADMIN")
                        .requestMatchers("/report/addMaintenance", "/report/addManager").hasAuthority("USER")
                        .requestMatchers("/report/maintenance").hasAnyAuthority("ACCOUNTANT", "ADMIN")
                        .requestMatchers("/report/manager").hasAuthority("ADMIN")

                        .requestMatchers("/**").hasAnyAuthority("ADMIN")
                        .anyRequest().authenticated()

                )
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .logout(LogoutConfigurer::permitAll)
                .exceptionHandling(eh -> eh.accessDeniedPage("/error"));

        return http.build();

    }

    public static UserDTO getUserByUsername(UserServiceImpl userService){
        Authentication auth  = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        return userService.findByUsername(username);
    }
}
