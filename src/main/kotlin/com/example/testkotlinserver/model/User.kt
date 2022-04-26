package com.example.testkotlinserver.model

import com.example.testkotlinserver.dto.UserDto
import javax.persistence.*


@Entity
class User(
     userId: String,
     password: String,
     userNickname: String
    ) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
    var userId: String = userId
    var password: String = password
    var userNickname: String = userNickname

    fun modifiedUserData(modifiedRequest: UserDto.ModifiedRequest): String {
        this.userNickname = modifiedRequest.changedNickname
        this.password = modifiedRequest.changedPassword
        return "${this.userId}의 회원 수정이 완료되었습니다."
    }
}