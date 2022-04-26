package com.example.testkotlinserver.model

import javax.persistence.*

@Entity
class Comment(
    var commentContent: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID",)
    var post: Post,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    var user: User
)
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?=null
}