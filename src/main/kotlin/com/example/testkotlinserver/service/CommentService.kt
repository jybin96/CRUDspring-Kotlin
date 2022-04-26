package com.example.testkotlinserver.service

import com.example.testkotlinserver.dto.CommentDto
import com.example.testkotlinserver.model.Comment
import com.example.testkotlinserver.repository.CommentRepository
import com.example.testkotlinserver.repository.PostRepository
import com.example.testkotlinserver.repository.UserRespository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

@Service
class CommentService (val commentRepository: CommentRepository, val postRepository: PostRepository, val userRepository: UserRespository){

    @Transactional
    fun createCommentService(postId: Long, createRequestDto: CommentDto.CreateRequestDto){
        val post = postRepository.findByIdOrNull(postId)?: throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"createCommentService에서 해당되는 포스트아이디가 없습니다.")
        val user = userRepository.findByIdOrNull(createRequestDto.userId)?: throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"createCommentService에서 해당되는 유저 아이디가 없습니다.")
        val comment = Comment(createRequestDto.commentContent,post,user)

        var mutableCommentList = post.commentList?.toMutableList()
        mutableCommentList!!.add(comment)
        post.updateCommentList(mutableCommentList.toList())
        commentRepository.save(comment)
    }

    @Transactional
    fun showCommentService(commentId: Long): CommentDto.ShowResponseDto {
        val comment = commentRepository.findByIdOrNull(commentId)?: throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"showCommentService에서 해당되는 commentId가 없습니다.")
        return CommentDto.ShowResponseDto(comment.id!!, comment.commentContent,comment.user.id!!, comment.user.userNickname)
    }
}