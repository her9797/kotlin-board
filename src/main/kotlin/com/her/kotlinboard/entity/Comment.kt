package com.her.kotlinboard.entity

import jakarta.persistence.*
import org.springframework.data.elasticsearch.annotations.Document
import java.time.LocalDateTime

@Document(indexName = "comments")
data class Comment(
    @Id
    val id: String,

    val postId: String,
    val parentId: String? = null,

    val writer: String,
    val content: String,

    val likes: Int = 0,
    val createdAt: LocalDateTime = LocalDateTime.now()
)