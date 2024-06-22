package com.example.AAW_ProvaAV2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request
                        .requestMatchers(HttpMethod.POST, "/login/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/username/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/cliente/**").permitAll()
                        .requestMatchers("/vendedor/**").hasRole("VENDEDOR")
                        .requestMatchers("/gerente/**").hasRole("GERENTE")
                        .anyRequest()
                        .authenticated()
                ).httpBasic(Customizer.withDefaults());
        return http.build();
    }


    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("cliente1")
                .password(passwordEncoder().encode("1234"))
                .roles("CLENTE")
                .build();
        UserDetails vendedor = User.builder()
                .username("vendedor1")
                .password(passwordEncoder().encode("4321"))
                .roles("VENDEDOR")
                .build();
        UserDetails gerente = User.builder()
                .username("gerente1")
                .password(passwordEncoder().encode("5678"))
                .roles("GERENTE")
                .build();
        return new InMemoryUserDetailsManager(user,vendedor, gerente);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
