package com.john.webfluxstudy.song.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table(name = "SONG_INFO")
data class Song (
//    @Id
    @Column("SONG_ID")
    val songId: String,
    @Column("SONG_NAME")
    val songName: String,
    @CreatedDate
    @Column("CREATED_AT")
    val createAt: LocalDateTime = LocalDateTime.now()
)