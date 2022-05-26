package com.mind.kotlin.service.aluno

import com.mind.kotlin.dto.RecieveAlunoDTO
import com.mind.kotlin.percistance.entity.AlunoEntity
import com.mind.kotlin.percistance.repository.AlunoRepository
import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct


@Service
@RequiredArgsConstructor
class AlunoServiceImplementation(val repository: AlunoRepository): AlunoService {

    override fun getUserbyId(id: Long): AlunoEntity {
      return repository.findById(id).get();
    }

    override fun createUser(user: RecieveAlunoDTO): AlunoEntity {
        var aluno: AlunoEntity = AlunoEntity(user.name,user.nif,user.email,user.telemovel)
        repository.save(aluno)
        var value: Int = repository.findAll().size

        return repository.findById(value.toLong()).get()
    }

    override fun getAllUsers(): List<AlunoEntity> {
        return repository.findAll();
    }

}