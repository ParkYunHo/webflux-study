package com.john.webfluxstudy.song.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.NoArgsConstructor
import lombok.RequiredArgsConstructor
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime

//@NoArgsConstructor
//@Entity
@Table(name = "SONG_INFO")
data class Song (
    @Id
    @Column(name = "SONG_ID", nullable = false)
    val songId: String,
    @Column(name = "SONG_NAME")
    val songName: String,
    @CreatedDate
    @Column(name = "CREATED_AT")
    val createAt: LocalDateTime = LocalDateTime.MIN
)