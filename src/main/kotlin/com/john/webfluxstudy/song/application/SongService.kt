package com.john.webfluxstudy.song.application

import com.john.webfluxstudy.song.adapter.`in`.web.dto.SongInput
import com.john.webfluxstudy.song.application.port.`in`.FindSongUseCase
import com.john.webfluxstudy.song.application.port.`in`.SaveSongUseCase
import com.john.webfluxstudy.song.application.port.out.SaveSongPort
import com.john.webfluxstudy.song.domain.Song
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

/**
 * @author yoonho
 * @since 2022.12.28
 */
@Service
class SongService(
    private val saveSongPort: SaveSongPort
): FindSongUseCase, SaveSongUseCase {
    private val log = LoggerFactory.getLogger(this::class.java)

    override fun saveSong(input: SongInput): Mono<Song> {
        log.info(" >>> [saveSong] input: {}", input)
        return saveSongPort.saveSong(input)
    }
}