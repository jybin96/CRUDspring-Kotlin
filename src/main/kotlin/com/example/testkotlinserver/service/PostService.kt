package com.example.testkotlinserver.service

import com.example.testkotlinserver.dto.CommentDto
import com.example.testkotlinserver.dto.PostDto
import com.example.testkotlinserver.model.Post
import com.example.testkotlinserver.repository.PostRepository
import com.example.testkotlinserver.repository.UserRespository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

@Service
class PostService (val postRepository: PostRepository, val userRepository: UserRespository){

    @Transactional
    fun createPostService(createRequestDto: PostDto.CreateRequestDto){
        val user = userRepository.findByIdOrNull(createRequestDto.userId)?: throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"createPostService에서 해당되는 유저아이디가 존재하지 않습니다.")
        val newPost = Post(createRequestDto.postTitle,createRequestDto.postContent,user)
        postRepository.save(newPost)
    }

    @Transactional
    fun showPostService(postId: Long): PostDto.ShowResponseDto {
        val post = postRepository.findByIdOrNull(postId) ?: throw ResponseStatusException(
            HttpStatus.INTERNAL_SERVER_ERROR,
            "showPostService에서 해당되는 포스트가 존재하지 않습니다."
        )

        val commentListDto = post.commentList?.map {
            CommentDto.ShowResponseDto(it.id!!,it.commentContent,it.user.id!!,it.user.userNickname)
        }?.toList()

        val showResponseDto = PostDto.ShowResponseDto(
            post.id!!,
            post.postTitle,
            post.postContent,
            commentListDto!!,
            post.user.id!!,
            post.user.userNickname
        )
        print(showResponseDto.postComment)
        return showResponseDto
    }

}