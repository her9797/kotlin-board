package com.her.kotlinboard.dto.comment

import com.her.kotlinboard.entity.Comment
import java.time.LocalDateTime

data class CmtResponse (
    val id: String,
    val postId: String,
    val parentId: String?,
    val writer: String,
    val content: String,
    val likes: Int,
    val createdAt: LocalDateTime
) {
    companion object {
        fun from(document: Comment): CmtResponse {
            return CmtResponse(
                id = document.id,
                postId = document.postId,
                parentId = document.parentId,
                writer = document.writer,
                content = document.content,
                likes = document.likes,
                createdAt = document.createdAt
            )
        }
    }
}