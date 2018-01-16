package br.com.raulpe7eira.wishlister

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class WishlisterApplication

fun main(args: Array<String>) {
    SpringApplication.run(WishlisterApplication::class.java, *args)
}
