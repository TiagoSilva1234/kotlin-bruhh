package com.mind.kotlin.controller

import com.mind.kotlin.dto.RecieveAlunoDTO
import com.mind.kotlin.percistance.entity.AlunoEntity
import com.mind.kotlin.percistance.repository.AlunoRepository
import com.mind.kotlin.service.aluno.AlunoService
import com.mind.kotlin.service.aluno.AlunoServiceImplementation
import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.websocket.server.PathParam

@RestController
@RequiredArgsConstructor
class AlunoController {
    @Autowired
  lateinit var service: AlunoServiceImplementation;

    @GetMapping("/user/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<AlunoEntity> {

        return ResponseEntity.ok(service.getUserbyId(id));
    }

    @PostMapping("/user/create")
    fun createUser(@RequestBody user: RecieveAlunoDTO): ResponseEntity<AlunoEntity> {

        return ResponseEntity.ok(service.createUser(user))
    }


    @GetMapping("/user")
    fun getAllUsers(): ResponseEntity<List<AlunoEntity>> {
        return ResponseEntity.ok(service.getAllUsers());

    }

}