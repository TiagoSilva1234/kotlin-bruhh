package com.mind.kotlin.acceptance

import io.restassured.RestAssured
import io.restassured.builder.RequestSpecBuilder
import io.restassured.config.LogConfig
import io.restassured.config.RestAssuredConfig
import io.restassured.filter.log.LogDetail
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification
import org.aspectj.lang.annotation.Before
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.springframework.boot.test.web.server.LocalServerPort


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class BaseTest {


    companion object {
        lateinit var requestSpecification: RequestSpecification
    }
    @LocalServerPort
    private val port = 8080

    @BeforeAll
    fun setUp() {
        RestAssured.port = port
    }
    @BeforeAll
    fun setup(){
        val logConfig = LogConfig.logConfig()
            .enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL)
        val config = RestAssuredConfig.config().logConfig(logConfig)
        requestSpecification = RequestSpecBuilder()
            .setBaseUri("http://localhost/")
            .addHeader("Accept","*/*")
            .addHeader("Content-type","application/json")
            .setContentType(ContentType.JSON)
            .setRelaxedHTTPSValidation()
            .setConfig(config)
            .log(LogDetail.ALL)
            .build()
    }

    @AfterAll
    fun tearDown(){
        RestAssured.reset()
    }
}