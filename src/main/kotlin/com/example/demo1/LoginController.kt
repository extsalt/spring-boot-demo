package com.example.demo1

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping


@Controller
class LoginController {
    @Autowired //don't forget the setter
    private val postInterface: PostInterface? = null

    @GetMapping("test")
    fun login() {
        val post = Post()
        post.agreeCount = 1
        post.disagreeCount = 1
        post.body = "this is body"

        postInterface?.save(post)
    }
}