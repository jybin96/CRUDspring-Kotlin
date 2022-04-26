package com.example.testkotlinserver.dto

import com.example.testkotlinserver.model.Comment

class PostDto {
    data class CreateRequestDto(
        val userId: Long,
        val postTitle: String,
        val postContent: String
    )

    data class ShowResponseDto(
        val postId: Long,
        val postTitle: String,
        val postContent: String,
        val postComment: List<CommentDto.ShowResponseDto>,
        val writerId: Long,
        val writerNickname: String
        )
}