package com.john.webfluxstudy.song.adapter.out.persistence

import com.john.webfluxstudy.song.domain.Song
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

/**
 * @author yoonho
 * @since 2022.12.28
 */
interface SongRepository: ReactiveCrudRepository<Song, String> {
    fun findBySongId(songId: String): Mono<Song>
}