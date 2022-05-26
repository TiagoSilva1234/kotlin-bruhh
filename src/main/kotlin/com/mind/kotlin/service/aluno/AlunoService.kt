package com.mind.kotlin.service.aluno

import com.mind.kotlin.dto.RecieveAlunoDTO
import com.mind.kotlin.percistance.entity.AlunoEntity
import com.mind.kotlin.percistance.repository.AlunoRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Service
interface AlunoService {


    fun getUserbyId(id: Long): AlunoEntity;


    fun createUser(user: RecieveAlunoDTO): AlunoEntity;


    fun getAllUsers(): List<AlunoEntity>;

}