package com.example.testkotlinserver.repository

import com.example.testkotlinserver.model.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post,Long>{
}