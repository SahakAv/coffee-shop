package com.sahakav.coffee_shop


import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories



@SpringBootApplication
@EnableJpaRepositories
class ProducerApplication {

}

object Application extends App {

    SpringApplication.run(classOf[ProducerApplication])
}