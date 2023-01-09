package com.john.webfluxstudy.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.CorsRegistry
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.ResourceHandlerRegistry
import org.springframework.web.reactive.config.WebFluxConfigurer

/**
 * @author yoonho
 * @since 2023.01.09
 */
@EnableWebFlux
@Configuration
class WebFluxConfig: WebFluxConfigurer {
    override fun addCorsMappings(corsRegistry: CorsRegistry) {
        corsRegistry.addMapping("/webjars/**")
            .allowedOrigins("http://localhost:8080")
            .allowedMethods("GET")
    }
}