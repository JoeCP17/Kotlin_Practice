package com.web.hompage_practice.repository

import com.web.hompage_practice.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository :CrudRepository<User, Long>{

    fun findByUserId(userId:String, password:String) : User
}