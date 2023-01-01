package com.john.webfluxstudy.cucumber.feature

import com.john.webfluxstudy.WebfluxStudyApplicationTests
import com.john.webfluxstudy.common.handler.ExceptionHandler
import io.cucumber.spring.CucumberContextConfiguration
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration

@SpringBootTest(classes = [WebfluxStudyApplicationTests::class])
@CucumberContextConfiguration
@AutoConfigureMockMvc
@AutoConfigureWebTestClient
@ActiveProfiles("test")
//@Import(value = [ExceptionHandler::class])
//@ContextConfiguration(classes = [ExceptionHandler::class])
class SpringIntegrationTest