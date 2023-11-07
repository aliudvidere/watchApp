package com.medApi.watchApp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WatchApp

fun main(args: Array<String>) {
	runApplication<WatchApp>(*args)
}
