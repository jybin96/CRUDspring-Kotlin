package com.example.testkotlinserver.dto

import lombok.Getter
import lombok.Setter

@Setter
@Getter
class UserDto {
    data class SignUpRequest(
        val userId: String,
        val password: String,
        val userNickname: String
        )

    data class ModifiedRequest(
        val id: Long,
        val changedNickname: String,
        val changedPassword: String
    )

    data class LoginRequest(
        val userId: String,
        val password: String
    )

    data class WithdrawalRequest(
        val id: Long
    )
}