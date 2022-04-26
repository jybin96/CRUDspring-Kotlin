package com.example.testkotlinserver.repository

import com.example.testkotlinserver.model.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<Comment, Long> {
}