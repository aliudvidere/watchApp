package com.medApi.watchApp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
@SpringBootApplication
@EntityScan("com.medApi.watchApp.model")
@EnableJpaRepositories("com.medApi.watchApp.repository")
@ComponentScan("com.medApi.watchApp.repository")
class WatchApp

fun main(args: Array<String>) {
	runApplication<WatchApp>(*args)
}
