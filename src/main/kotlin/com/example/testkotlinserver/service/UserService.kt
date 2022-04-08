package com.example.testkotlinserver.service

import com.example.testkotlinserver.dto.UserDto
import com.example.testkotlinserver.model.User
import com.example.testkotlinserver.repository.UserRespository
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService (val userDb: UserRespository){
    fun signUp(signUpData: UserDto.SignUpRequest): String{
        val user = User(userId = signUpData.userId, password = signUpData.password, userNickname = signUpData.userNickname)
        userDb.save(user)
        return "회원가입이 완료되었습니다"
    }

    @Transactional
    fun modifiedUser(modifiedRequest: UserDto.ModifiedRequest): String {
        val user: User = userDb.findById(modifiedRequest.id).orElseThrow {
            ChangeSetPersister.NotFoundException()
        }
       return user.modifiedUserData(modifiedRequest)
    }
}