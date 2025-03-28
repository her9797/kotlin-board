package com.her.kotlinboard.dto.board

import java.time.LocalDateTime

data class BoardResponse (

    val id: Long,
    val title: String,
    val content: String,
    var writer: String,
    var createdAt: LocalDateTime,

    )