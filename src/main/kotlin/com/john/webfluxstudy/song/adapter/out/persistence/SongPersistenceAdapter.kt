package com.john.webfluxstudy.song.adapter.out.persistence

import com.john.webfluxstudy.song.adapter.`in`.web.dto.SongInput
import com.john.webfluxstudy.song.adapter.out.persistence.dto.SongDto
import com.john.webfluxstudy.song.application.port.out.SaveSongPort
import com.john.webfluxstudy.song.domain.Song
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import java.time.LocalDateTime

/**
 * @author yoonho
 * @since 2022.12.28
 */
@Repository
class SongPersistenceAdapter(
    private val songRepository: SongRepository
): SaveSongPort {
    private val log = LoggerFactory.getLogger(this::class.java)

    override fun saveSong(input: SongInput): Mono<Song> {
        log.info(" >>> [saveSong] input: {}", input)
        return songRepository.save(
                    Song(
                        songId = input.songId,
                        songName = input.songName
                    )
                )
    }

}