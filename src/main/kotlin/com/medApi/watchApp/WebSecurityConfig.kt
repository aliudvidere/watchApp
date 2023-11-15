package com.medApi.watchApp

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain


@Configuration
class WebSecurityConfig {
    @Bean
    fun userDetailsService(): InMemoryUserDetailsManager? {
        val user1 = User.withDefaultPasswordEncoder()
            .username("user1")
            .password("oiev89o@ier")
            .roles("USER")
            .build()
        val user2 = User.withDefaultPasswordEncoder()
            .username("SergeiPetrovich")
            .password("ihbfvubuhyfvb")
            .roles("USER")
            .build()
        val admin = User.withDefaultPasswordEncoder()
            .username("admin")
            .password("chlen")
            .roles("ADMIN")
            .build()
        return InMemoryUserDetailsManager(user1, user2, admin)
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