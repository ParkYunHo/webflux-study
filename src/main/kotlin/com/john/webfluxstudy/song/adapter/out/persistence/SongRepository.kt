package com.john.webfluxstudy.song.adapter.out.persistence

import com.john.webfluxstudy.song.domain.Song
import org.springframework.data.repository.reactive.ReactiveCrudRepository

/**
 * @author yoonho
 * @since 2022.12.28
 */
//interface SongRepository: JpaRepository<Song, String>
interface SongRepository: ReactiveCrudRepository<Song, String>