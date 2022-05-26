package com.mind.kotlin.percistance.repository

import com.mind.kotlin.percistance.entity.AlunoEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service


interface AlunoRepository : JpaRepository<AlunoEntity, Long> {



}