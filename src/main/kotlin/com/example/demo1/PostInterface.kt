package com.example.demo1

import org.springframework.data.repository.CrudRepository

interface PostInterface : CrudRepository<Post, Long> {
}

