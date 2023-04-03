package com.example.spring.mongodb.integration.repository

import com.example.spring.mongodb.integration.model.UserModel
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*
import kotlin.collections.List

interface UserRepository: MongoRepository<UserModel, Int> {

    fun findByNome (nome: String) : Optional<UserModel?>

    fun findByUserID (userID: Int) : Optional<UserModel>

    fun findByUserIDIsGreaterThanEqual (value: Int) : Optional<List<UserModel>>

    fun existsByUserID(userID: Int) : Boolean

    fun deleteByUserID (userID: Int)

}