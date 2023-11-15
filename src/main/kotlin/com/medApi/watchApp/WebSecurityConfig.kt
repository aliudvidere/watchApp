package com.medApi.watchApp

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.http.HttpMethod.*
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class WebSecurityConfig {
    @Bean
    fun userDetailsService(): InMemoryUserDetailsManager? {
        val encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()
        val user1 = User.withUsername("user1")
            .password(encoder.encode("oiev89o@ier"))
            .roles("USER")
            .build()
        val user2 = User.withUsername("SergeiPetrovich")
            .password(encoder.encode("ihbfvubuhyfvb"))
            .roles("USER")
            .build()
        val admin = User.withUsername("admin")
            .password(encoder.encode("chlen"))
            .roles("ADMIN")
            .build()
        return InMemoryUserDetailsManager(user1, user2, admin)
    }

    @Bean
    @Order(1)
    fun apiFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .securityMatcher("/service/**")
            .authorizeHttpRequests { authorize ->
                authorize
                    .anyRequest().hasRole("ADMIN")
            }
            .httpBasic(withDefaults())
            .csrf{
                csrf -> csrf.disable()
            }
        return http.build()
    }

    @Bean
    fun formLoginFilterChain(http: HttpSecurity): SecurityFilterChain? {
        http
            .authorizeHttpRequests { authorize ->
                authorize
                    .anyRequest().authenticated()
            }
            .formLogin(withDefaults())
        return http.build()
    }
}