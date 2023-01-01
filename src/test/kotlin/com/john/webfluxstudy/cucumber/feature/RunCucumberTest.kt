package com.john.webfluxstudy.cucumber.feature

import io.cucumber.junit.platform.engine.Constants
import org.junit.platform.suite.api.*

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("cucumber/feature")
@ConfigurationParameters(value = [
    ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "cucumber.feature"),
    ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty"),
])
class RunCucumberTest {
}