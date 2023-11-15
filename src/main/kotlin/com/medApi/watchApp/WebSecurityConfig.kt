package com.medApi.watchApp

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain


@Configuration
class WebSecurityConfig {
    @Bean
    fun userDetailsService(): UserDetailsService {
        // ensure the passwords are encoded properly
        val users = User.withDefaultPasswordEncoder()
        val manager = InMemoryUserDetailsManager()
        manager.createUser(users
            .username("user")
            .password("password")
            .roles("USER")
            .build())
        manager.createUser(users
            .username("admin")
            .password("password")
            .roles("USER", "ADMIN")
            .build())
        return manager
    }

    @Bean
    fun apiFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .securityMatcher("/service/**")
            .authorizeHttpRequests { authorize ->
                authorize
                    .anyRequest().hasRole("ADMIN")
            }
            .httpBasic(withDefaults())
        return http.build()
    }
}