package com.example.testkotlinserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TestKotlinServerApplication

fun main(args: Array<String>) {
    runApplication<TestKotlinServerApplication>(*args)
}
