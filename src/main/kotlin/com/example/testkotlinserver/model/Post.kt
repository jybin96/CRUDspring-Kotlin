package com.example.testkotlinserver.model

import lombok.Setter
import javax.persistence.*

@Entity
class Post(
    var postTitle: String,
    var postContent: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    var user: User
    )
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @OneToMany(mappedBy = "post")
    var commentList : List<Comment>? = emptyList<Comment>()

    fun updateCommentList(commentList: List<Comment>){
        this.commentList = commentList
    }
}