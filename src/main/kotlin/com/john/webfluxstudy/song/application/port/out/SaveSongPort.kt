package com.john.webfluxstudy.song.application.port.out

import com.john.webfluxstudy.song.adapter.`in`.web.dto.SongInput
import com.john.webfluxstudy.song.adapter.out.persistence.dto.SongDto
import com.john.webfluxstudy.song.domain.Song
import reactor.core.publisher.Mono

/**
 * @author yoonho
 * @since 2022.12.28
 */
interface SaveSongPort {
    fun saveSong(input: SongInput): Mono<Song>
}