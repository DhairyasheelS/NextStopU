package org.example.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors().and().csrf().disable()  // Disable CSRF protection for testing purposes (re-enable in production)
                .authorizeRequests(auth -> auth
                        // Allow public access to all API endpoints including signup
                        .requestMatchers("/api/auth/**").permitAll()  // Allow signup without authentication
                        // Optionally, open access to bus and location tracking APIs
                        .requestMatchers("/api/buses/**").permitAll()  // Open access for bus-related APIs
                        .requestMatchers("/api/location/**").permitAll()  // Open access for location tracking (if needed)

                        // For now, allow access to all other endpoints
                        .anyRequest().authenticated()  // Allow unrestricted access to all endpoints for now
                );

        return httpSecurity.build();
    }
}
