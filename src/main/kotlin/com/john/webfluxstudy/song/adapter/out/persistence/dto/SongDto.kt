package com.john.webfluxstudy.song.adapter.out.persistence.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

/**
 * @author yoonho
 * @since 2022.12.28
 */
data class SongDto(
    val songId: String,
    val songName: String,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    val createdAt: LocalDateTime
)
