package com.mind.kotlin.percistance.entity
import lombok.*
import javax.persistence.*

@Entity
@Table(name = "Alunos")

class AlunoEntity (
    @Column(name = "name")
     var name: String?,

    @Column(name = "NIF")
     var nif: Int?,

    @Column(name = "email")
     var email: String?,

    @Column(name = "telemovel")
     var telemovel: Int?,
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = -1,
)

{
   private constructor() : this("",0,"",0) {}

}