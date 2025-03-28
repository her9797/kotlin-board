package com.her.kotlinboard.entity

import com.her.kotlinboard.dto.board.BoardRequest
import com.her.kotlinboard.dto.board.BoardResponse
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
class Board(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    var title: String,
    var content: String,
    var writer: String,
    var createdAt: LocalDateTime = LocalDateTime.now()
)


fun BoardRequest.toEntity(): Board =
    Board(title = this.title, content = this.content, writer = this.writer)

fun Board.toResponse(): BoardResponse =
    BoardResponse(id = this.id, title = this.title, content = this.content, writer = this.writer, createdAt = this.createdAt)