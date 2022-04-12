package com.example.testkotlinserver.controller

import com.example.testkotlinserver.dto.UserDto
import com.example.testkotlinserver.service.UserService
import org.springframework.web.bind.annotation.*
import kotlin.math.log

@RestController
class UserController (val userService: UserService){
    @GetMapping("/")
    fun index(): String = "HelloWorld"

    @PostMapping("/signup")
    fun signUpController(@RequestBody signUpData: UserDto.SignUpRequest): String{
        return userService.signUpService(signUpData)
    }

    @PutMapping("/modify")
    fun modifiedController(@RequestBody modifiedRequest: UserDto.ModifiedRequest): String{
        return userService.modifiedService(modifiedRequest)
    }

    @PostMapping("/login")
    fun loginController(@RequestBody loginRequest: UserDto.LoginRequest): String {
        return userService.loginService(loginRequest)
    }

    @DeleteMapping("/withdrawal")
    fun withdrawalController(@RequestBody withdrawalRequest: UserDto.WithdrawalRequest): String{
        return userService.withdrawalService(withdrawalRequest)
    }
}