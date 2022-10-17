package com.web.hompage_practice.controller

import com.web.hompage_practice.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class SignController {

    // 나중에 initialize 하는 변수
    @Autowired
    lateinit var repository:UserRepository

    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("title" , "Home")
        return "index"
    }

//
//    @GetMapping("/sign")
//    fun htmlForm(model: Model): String {
//        return "sign"
//    }

    @GetMapping("/{formType}")
    fun htmlForm(model: Model, @PathVariable formType:String): String? {

        var response :String?=null
        if (formType.equals("sign")) response = "sign"

        else if (formType.equals("login")) response = "login"

        model.addAttribute("title", response)

        return response
    }

//    @GetMapping("/login")
//    fun loginForm(model: Model): String {
//        return "login"
//    }

    @PostMapping("/sign")
    fun postSign(model: Model,
                 @RequestParam(value = "id") userId: String,
                 @RequestParam(value = "password") password: String) {

        val user = repository.findByUserId(userId, password)
        println(user.toString())
    }
}