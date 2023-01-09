package com.john.webfluxstudy.config

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springdoc.core.customizers.ServerBaseUrlCustomizer
import org.springframework.context.annotation.Configuration

/**
 * @author yoonho
 * @since 2023.01.09
 */
@OpenAPIDefinition(
    info = Info(
        title = "WebFlux API 문서",
        description =   """
                        API 문서 테스트용도
                        WebFlux
                        """,
        version = "0.0.1"
    )
)
@Configuration
//class OpenApiConfiguration
class OpenApiConfiguration: ServerBaseUrlCustomizer {
    override fun customize(serverBaseUrl: String?): String = "http://localhost:8080"
}