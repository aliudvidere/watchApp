package com.medApi.watchApp

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.core.userdetails.User
import org.springframework.security.provisioning.InMemoryUserDetailsManager

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
        return InMemoryUserDetailsManager(user1, user2)
    }
}