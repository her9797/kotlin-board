package com.her.kotlinboard.ctl

import com.her.kotlinboard.dto.board.BoardRequest
import com.her.kotlinboard.dto.board.BoardResponse
import com.her.kotlinboard.entity.Board
import com.her.kotlinboard.entity.toEntity
import com.her.kotlinboard.entity.toResponse
import com.her.kotlinboard.service.BoardService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/boards")
class BoardCtl(private val boardService: BoardService) {

    @PostMapping
    fun create(@RequestBody request: BoardRequest): BoardResponse {
        val saved = boardService.createBoard(request.toEntity())
        return saved.toResponse()
    }

    @GetMapping
    fun getAllBoard(pageable: Pageable): Page<BoardResponse> =
        boardService.getAllBoards(pageable).map { it.toResponse() }

    @GetMapping("/{id}")
    fun getBoardById(@PathVariable id: Long) : BoardResponse =
        boardService.getBoardById(id).orElseThrow().toResponse()

    @PutMapping("/{id}")
    fun updateBoard(@PathVariable id: Long, @RequestBody request: BoardRequest): BoardResponse {
        val updatedBoard = boardService.updateBoard(id, request.toEntity())
        return updatedBoard.toResponse()
    }

    @DeleteMapping("/{id}")
    fun deleteBoard(@PathVariable id: Long)  = boardService.deleteBoard(id);

}