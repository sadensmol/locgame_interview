package me.sadensmol.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class ServiceConfiguration {

    @Bean
    fun webClient(): WebClient =  WebClient.create()
}