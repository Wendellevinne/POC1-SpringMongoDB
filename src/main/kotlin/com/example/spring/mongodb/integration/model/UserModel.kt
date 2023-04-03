package com.example.spring.mongodb.integration.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document("users")
data class UserModel (
    @Id
    var id: String? = null,
    var name: String,
    var email: String,
    @Field("userID")
    var userID: Int?
)