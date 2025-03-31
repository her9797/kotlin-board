package com.her.kotlinboard.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.data.elasticsearch.annotations.Document
import java.time.LocalDateTime

@Document(indexName = "comments")
data class CommentDocument(
    @Id
    val id: String,

    val postId: String,
    val parentId: String?,       // null이면 최상위 댓글
    val writer: String,
    val content: String,

    val likes: Int = 0,
    val createdAt: LocalDateTime = LocalDateTime.now()
)