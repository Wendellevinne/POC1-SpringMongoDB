package com.example.spring.mongodb.integration.repository

import com.example.spring.mongodb.integration.model.UserModel
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface UserRepository: MongoRepository<UserModel, Int> {

    fun findByName (name: String) : Optional<UserModel?>

    fun findByUserID (userID: Int) : Optional<UserModel>

    fun existsByUserID(userID: Int) : Boolean

    fun deleteByUserID (userID: Int)

}