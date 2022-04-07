package com.example.testkotlinserver.repository

import com.example.testkotlinserver.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRespository : JpaRepository<User, Long>{
}