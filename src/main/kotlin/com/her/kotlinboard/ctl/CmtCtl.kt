package com.her.kotlinboard.ctl

import com.her.kotlinboard.dto.comment.CmtRequest
import com.her.kotlinboard.entity.Comment
import com.her.kotlinboard.service.CmtService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/comments")
class CmtCtl(private val cmtService: CmtService) {

    @PostMapping("")
    fun addComment(@RequestBody dto: CmtRequest): Comment {
        val comment = Comment(
            id = UUID.randomUUID().toString(),
            postId = dto.postId,
            parentId = dto.parentId,
            writer = dto.writer,
            content = dto.content
        )
        return cmtService.save(comment)
    }

}