package com.oktfolio.kite

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KiteApplication

fun main(args: Array<String>) {
    runApplication<KiteApplication>(*args)
}
