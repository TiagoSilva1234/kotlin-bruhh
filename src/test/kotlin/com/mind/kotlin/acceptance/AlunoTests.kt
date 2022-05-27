package com.mind.kotlin.acceptance

import com.mind.kotlin.dto.RecieveAlunoDTO
import com.mind.kotlin.percistance.entity.AlunoEntity
import io.restassured.RestAssured
import io.restassured.RestAssured.given
import io.restassured.builder.RequestSpecBuilder
import jdk.jfr.ContentType
import org.aspectj.lang.annotation.Before

import org.postgresql.core.Oid.JSON
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort


import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import io.restassured.response.Response
import io.restassured.response.ResponseBody
import io.restassured.response.ValidatableResponse
import io.swagger.v3.core.util.Json
import org.apache.http.HttpStatus
import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test
import org.springframework.util.Base64Utils.encodeToString


class `AlunoTests` : BaseTest(){




    @Test
    fun `create_aluno`(){
        var aluno: RecieveAlunoDTO = RecieveAlunoDTO("claudio",123,"idk",123)

      val user: Response =  Given {
       spec(requestSpecification)
            body(aluno)
        } When {
          log()
          post("user/create")
      } Then {
          log()
            statusCode(HttpStatus.SC_OK)
  assertThat().body("name", equalTo("claudio"))
          assertThat().body("nif", equalTo(123))
          assertThat().body("email", equalTo("idk"))
          assertThat().body("telemovel", equalTo(123))
        } Extract {
            response()
      }
         println(user.body.asString())


    }



}