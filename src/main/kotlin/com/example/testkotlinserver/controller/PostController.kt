package com.example.testkotlinserver.controller

import com.example.testkotlinserver.dto.PostDto
import com.example.testkotlinserver.service.PostService
import org.springframework.web.bind.annotation.*

@RestController
class PostController (val postService: PostService){
    @PostMapping("/post")
    fun createPostController(@RequestBody createRequestDto: PostDto.CreateRequestDto){
        postService.createPostService(createRequestDto);
    }

    @GetMapping("/post/{postId}")
    fun showPostController(@PathVariable postId: Long): PostDto.ShowResponseDto {
        return postService.showPostService(postId)
    }
}