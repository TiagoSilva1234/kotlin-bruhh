package com.mind.kotlin.acceptance

import com.mind.kotlin.percistance.entity.AlunoEntity
import io.restassured.RestAssured
import io.restassured.RestAssured.given
import io.restassured.builder.RequestSpecBuilder
import jdk.jfr.ContentType
import org.aspectj.lang.annotation.Before
import org.junit.jupiter.api.Test
import org.postgresql.core.Oid.JSON
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AlunoTests {


    @LocalServerPort
    private val port = 8081

    @Before
    fun setUp() {
        RestAssured.port = port
    }

    @Test
    fun create_aluno(){
        var aluno : AlunoEntity = AlunoEntity()


         val response = RequestSpecBuilder()
            .setBaseUri("http://localhost:8081/user/create")
             .setContentType()
    }


}