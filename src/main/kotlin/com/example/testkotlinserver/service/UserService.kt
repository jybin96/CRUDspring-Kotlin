package com.example.testkotlinserver.service

import com.example.testkotlinserver.dto.UserDto
import com.example.testkotlinserver.model.User
import com.example.testkotlinserver.repository.UserRespository
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

@Service
class UserService (val userDb: UserRespository){

    companion object {
        const val NOT_CORRECT_ID = "아이디오류"
        const val NOT_CORRECT_PASSWORD = "비밀번호오류"
        const val SUCCESSFUL_LOGIN = "로그인성공"
    }


    fun signUpService(signUpData: UserDto.SignUpRequest): String{
        val user = User(userId = signUpData.userId, password = signUpData.password, userNickname = signUpData.userNickname)
        userDb.save(user)
        return "회원가입이 완료되었습니다"
    }

    @Transactional
    fun modifiedService(modifiedRequest: UserDto.ModifiedRequest): String {
        val user: User = userDb.findById(modifiedRequest.id).orElseThrow {
            ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"회원정보 변경할 유저아이디가 없습니다.")
        }
       return user.modifiedUserData(modifiedRequest)
    }

    fun loginService(loginRequest: UserDto.LoginRequest): String {
        val isLogin: String?
        val loginUser: User? = userDb.findByUserId(loginRequest.userId)

        isLogin = when{
            loginUser == null -> NOT_CORRECT_ID
            loginUser.password != loginRequest.password -> NOT_CORRECT_PASSWORD
            else -> SUCCESSFUL_LOGIN
        }

        return isLogin
    }

    fun withdrawalService(withdrawalRequest: UserDto.WithdrawalRequest): String {
        userDb.delete(userDb.findById(withdrawalRequest.id).orElseThrow {
            ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"회원탈퇴할 유저아이디가 없습니다.")
        })
        return "회원탈퇴 성공"
    }
}