package com.example.demo1

import java.time.Instant
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 1

    lateinit var body: String

    var agreeCount: Int = 0

    var disagreeCount: Int = 0

    var createdAt: Instant? = Date().toInstant()

    lateinit var updateAt: Date

    lateinit var deletedAt: Date

    fun agreePercentage(): Int {
        return this.agreeCount / (this.agreeCount + this.disagreeCount)
    }

    fun disagreePercentage(): Int {
        return this.disagreeCount / (this.agreeCount + this.disagreeCount)
    }
}