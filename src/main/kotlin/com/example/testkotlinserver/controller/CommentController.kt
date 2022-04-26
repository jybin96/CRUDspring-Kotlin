package com.example.testkotlinserver.controller

import com.example.testkotlinserver.dto.CommentDto
import com.example.testkotlinserver.service.CommentService
import org.springframework.web.bind.annotation.*

@RestController
class CommentController (val commentService: CommentService){
    @PostMapping("/comment/{postId}")
    fun createCommentController(@PathVariable postId: Long, @RequestBody createRequestDto: CommentDto.CreateRequestDto){
        commentService.createCommentService(postId,createRequestDto)
    }

    @GetMapping("/comment/{commentId}")
    fun showCommentController(@PathVariable commentId: Long): CommentDto.ShowResponseDto {
        return commentService.showCommentService(commentId)
    }
}