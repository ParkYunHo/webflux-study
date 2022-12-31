package com.john.webfluxstudy.song.application.port.out

import com.john.webfluxstudy.song.domain.Song
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * @author yoonho
 * @since 2022.12.31
 */
interface FindSongPort {
    fun findSong(songId: String): Mono<Song>
    fun findSongAll(): Flux<Song>
}