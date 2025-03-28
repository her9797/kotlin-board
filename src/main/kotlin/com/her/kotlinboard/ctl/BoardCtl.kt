package com.her.kotlinboard.ctl

import com.her.kotlinboard.entity.Board
import com.her.kotlinboard.service.BoardService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/boards")
class BoardCtl(private val boardService: BoardService) {

    @PostMapping
    fun create(@RequestBody board: Board): Board = boardService.createBoard(board)

    @GetMapping
    fun getAllBoard(): List<Board> = boardService.getAllBoards()

    @GetMapping("/{id}")
    fun getBoardById(@PathVariable id: Long) : Optional<Board> = boardService.getBoardById(id)

    @PutMapping("/{id}")
    fun updateBoard(@PathVariable id: Long, @RequestBody updateBoard: Board) : Board = boardService.updateBoard(id, updateBoard)

    @DeleteMapping("/{id}")
    fun deleteBoard(@PathVariable id: Long)  = boardService.deleteBoard(id);

}