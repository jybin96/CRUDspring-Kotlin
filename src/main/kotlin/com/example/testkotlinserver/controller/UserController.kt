package com.example.testkotlinserver.controller

import com.example.testkotlinserver.dto.UserDto
import com.example.testkotlinserver.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
class UserController (val userService: UserService){
    @GetMapping("/")
    fun index(): String = "HelloWorld"

    @PostMapping("/signup")
    fun signUpController(@RequestBody signUpData: UserDto.SignUpRequest): String{
        return userService.signUp(signUpData)
    }

    @PutMapping("/modify")
    fun modifiedController(@RequestBody modifiedRequest: UserDto.ModifiedRequest): String{
        return userService.modifiedUser(modifiedRequest)
    }
}