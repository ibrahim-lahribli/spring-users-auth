package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/* @Configuration
Marks this class as a Spring configuration class
Tells Spring that this class contains bean definitions and should be processed during component scanning
Enables the use of `@Bean` annotations within the class
*/
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /*
    @bean
    Indicates that the `passwordEncoder()` method returns an object that should be registered as a Spring bean
    The bean will be managed by Spring's IoC (Inversion of Control) container
    This bean can be injected into other components using `@Autowired` or constructor injection
    */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12); // 12 = good balance in 2025 (≈200-400ms)
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // Disable CSRF for stateless REST APIs
            .authorizeHttpRequests(authz -> authz
                .requestMatchers(HttpMethod.POST, "/api/users").permitAll()  // Allow user registration without authentication
                .anyRequest().authenticated()  // Require authentication for all other requests
            )
            .httpBasic(Customizer.withDefaults());  // Use HTTP Basic authentication for secured endpoints

        return http.build();
    }
}
