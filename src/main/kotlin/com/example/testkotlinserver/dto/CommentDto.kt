package com.example.testkotlinserver.dto

class CommentDto {
    data class CreateRequestDto(
        val userId: Long,
        val commentContent: String,
    )

    data class ShowResponseDto(
        val commentId: Long,
        val commentContent: String,
        val writerId: Long,
        val writerNickname: String
    )
}