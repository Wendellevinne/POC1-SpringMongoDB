package com.example.spring.mongodb.integration.service

import com.example.spring.mongodb.integration.model.UserModel
import com.example.spring.mongodb.integration.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(val userRepository: UserRepository) {

    fun getAllUsers(): List<UserModel> {
        return userRepository.findAll().toList().sortedBy { userModel -> userModel.userID }
    }

    fun getUserByName(name: String): Optional<UserModel?> {
        return userRepository.findByName(name)
    }

    fun saveUser(user: UserModel) {
        user.userID?.let {
            if (!userRepository.existsByUserID(userID = user.userID!!)){
                userRepository.save(user)
                return
            } else throw Exception("Usuário já cadastrado!!")
        }
        user.userID = userRepository.findAll().sortedBy { it.userID }.last().userID?.plus(1)
        userRepository.save(user)
    }

    fun updateUser(user: UserModel): UserModel {
        user.userID?.let {
            userRepository.deleteByUserID(user.userID!!)
            return userRepository.findByUserID(userID = user.userID!!).let { userRepository.save(user.copy(userID = user.userID)) }
        }
        throw Exception("UserID não especificado!!!")
    }

    fun deleteUser(userID: Int) {
        if (!userRepository.existsByUserID(userID)){
            throw Exception("Usuário Inexistente")
        }
        userRepository.deleteByUserID(userID)
    }


}