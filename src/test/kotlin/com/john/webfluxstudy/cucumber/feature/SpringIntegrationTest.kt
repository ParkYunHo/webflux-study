package com.john.webfluxstudy.cucumber.feature

import com.john.webfluxstudy.WebfluxStudyApplicationTests
import io.cucumber.spring.CucumberContextConfiguration
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(classes = [WebfluxStudyApplicationTests::class])
@CucumberContextConfiguration
@AutoConfigureMockMvc
@ActiveProfiles("test")
class SpringIntegrationTest