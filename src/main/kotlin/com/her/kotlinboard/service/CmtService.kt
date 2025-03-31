package com.her.kotlinboard.service

import com.her.kotlinboard.entity.Comment
import com.her.kotlinboard.repository.CmtRepository
import org.springframework.stereotype.Service

@Service
class CmtService(private val cmtRepository: CmtRepository) {

    fun save(comment: Comment): Comment {
        return cmtRepository.save(comment)
    }
}