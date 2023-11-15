package com.medApi.watchApp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories("com.medApi.watchApp.repository")
class WatchApp

fun main(args: Array<String>) {
	runApplication<WatchApp>(*args)
}
