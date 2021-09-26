package com.example.demo1

import java.time.Instant
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class PublicFigure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 1

    lateinit var bio: String

    lateinit var photo: String

    val createdAt: Instant? = Date().toInstant()

    lateinit var updateAt: Date

    lateinit var deletedAt: Date
}