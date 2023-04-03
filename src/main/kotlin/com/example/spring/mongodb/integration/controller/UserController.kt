package com.example.spring.mongodb.integration.controller

import com.example.spring.mongodb.integration.controller.request.PostUserRequest
import com.example.spring.mongodb.integration.controller.request.PutUserRequest
import com.example.spring.mongodb.integration.extensions.toUserModel
import com.example.spring.mongodb.integration.model.UserModel
import com.example.spring.mongodb.integration.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.Optional

@RestController
@RequestMapping("MongoIntegration")
class UserController (val userService: UserService) {

    @GetMapping("/users")
    fun getAll(): ResponseEntity<List<UserModel>> = ResponseEntity.ok(userService.getAllUsers())

    @GetMapping("/users/{name}")
    fun getByName(@PathVariable name: String): ResponseEntity<Optional<UserModel?>> = ResponseEntity.ok(userService.getUserByName(name))

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    fun saveUser(@RequestBody user: PostUserRequest) = userService.saveUser(user.toUserModel())

    @PutMapping("/users/{userID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateUser(@PathVariable userID: Int, @RequestBody user: PutUserRequest) = userService.updateUser(user.toUserModel(userID))

    @DeleteMapping("/users/{userID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUser(@PathVariable userID: Int) = userService.deleteUser(userID)
}