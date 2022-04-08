package com.example.testkotlinserver.dto

import lombok.Getter
import lombok.Setter

@Setter
@Getter
class UserDto {
    data class SignUpRequest(
        var userId: String,
        var password: String,
        var userNickname: String
        )

    data class ModifiedRequest(
        val id: Long,
        val changedNickname: String,
        val changedPassword: String
    )
}