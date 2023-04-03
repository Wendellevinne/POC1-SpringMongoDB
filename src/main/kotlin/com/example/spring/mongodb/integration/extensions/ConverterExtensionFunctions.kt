package com.example.spring.mongodb.integration.extensions

import com.example.spring.mongodb.integration.controller.request.PostUserRequest
import com.example.spring.mongodb.integration.controller.request.PutUserRequest
import com.example.spring.mongodb.integration.model.UserModel

fun PostUserRequest.toUserModel(): UserModel {
    return UserModel(id = id, nome = nome, email = email, userID = userID)
}

fun PutUserRequest.toUserModel(userID: Int): UserModel {
    return UserModel(nome = nome, email = email, userID = userID)
}