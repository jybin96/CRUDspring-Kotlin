package com.example.testkotlinserver.controller

import com.example.testkotlinserver.dto.UserDto
import com.example.testkotlinserver.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController (val userService: UserService){
    @GetMapping("/")
    fun index(): String = "HelloWorld"

    @PostMapping("/signup")
    fun signUpController(@RequestBody signUpData: UserDto.SignUpRequest): String{
        return userService.signUp(signUpData)
    }
}