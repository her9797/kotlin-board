package com.her.kotlinboard.repository

import com.her.kotlinboard.entity.Comment
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import org.springframework.stereotype.Repository

@Repository
interface CmtRepository : ElasticsearchRepository<Comment, String>{

}