package com.mind.kotlin.dto

import lombok.Data
import javax.persistence.Column

@Data
class RecieveAlunoDTO (
        var name: String?,
        var nif: Int?,
        var email: String?,
        var telemovel: Int?,
        )