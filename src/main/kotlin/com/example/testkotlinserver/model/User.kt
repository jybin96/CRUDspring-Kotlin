package com.example.testkotlinserver.model

import javax.persistence.*


@Entity
class User(
     userId: String,
     password: String,
     userNickname: String
    ) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var userId: String = userId
    val password: String = password
    val userNickname: String = userNickname
}