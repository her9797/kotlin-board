package com.her.kotlinboard.dto.comment

data class CmtRequest (
    val postId: String,
    val parentId: String? = null,
    val writer: String,
    val content: String
)