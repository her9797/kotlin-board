package com.her.kotlinboard.service

import com.her.kotlinboard.entity.Board
import com.her.kotlinboard.repository.BoardRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class BoardService(private val boardRepository: BoardRepository) {

    // 등록
    fun createBoard(board: Board): Board = boardRepository.save(board)

    // 전체 조회
    fun getAllBoards(): List<Board> = boardRepository.findAll()

    // 단일 조회
    fun getBoardById(id: Long): Optional<Board> = boardRepository.findById(id);

    // 수정
    fun updateBoard(id:Long,  updated: Board): Board {
        val board = boardRepository.findById(id).orElseThrow{ NoSuchElementException("게시글이 없습니다: $id") }

        board.title = updated.title
        board.content = updated.content
        board.writer = updated.writer

        return boardRepository.save(board);
    }

    // 삭제
    fun deleteBoard(id:Long) = boardRepository.deleteById(id)

}