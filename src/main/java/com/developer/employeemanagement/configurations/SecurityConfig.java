package com.developer.employeemanagement.configurations;

import com.developer.employeemanagement.auth.jwt.AuthEntryPointJwt;
import com.developer.employeemanagement.auth.jwt.AuthTokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {

    private final AuthEntryPointJwt unauthorizedHandler;
    private final AuthTokenFilter authenticationJwtTokenFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
                .and().authorizeHttpRequests().requestMatchers("/auth/**").permitAll()
                .anyRequest().authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authenticationProvider(authenticationProvider)
                .addFilterBefore(authenticationJwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }
}
