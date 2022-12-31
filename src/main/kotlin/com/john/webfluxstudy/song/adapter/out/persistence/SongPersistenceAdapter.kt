package com.john.webfluxstudy.song.adapter.out.persistence

import com.john.webfluxstudy.common.exception.NotFoundDataException
import com.john.webfluxstudy.song.adapter.`in`.web.dto.SongInput
import com.john.webfluxstudy.song.application.port.out.FindSongPort
import com.john.webfluxstudy.song.application.port.out.SaveSongPort
import com.john.webfluxstudy.song.domain.Song
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty

/**
 * @author yoonho
 * @since 2022.12.28
 */
@Repository
class SongPersistenceAdapter(
    private val songRepository: SongRepository
): SaveSongPort, FindSongPort {
    private val log = LoggerFactory.getLogger(this::class.java)

    override fun saveSong(input: SongInput): Mono<Song> {
        log.info(" >>> [saveSong] input: {}", input)
        require(input != null) { "곡 정보를 입력해주세요." }

        return songRepository.save(
                    Song(
                        songId = input.songId,
                        songName = input.songName
                    )
                )
    }

    override fun findSong(songId: String): Mono<Song> {
        log.info(" >>> [findSong] songId: {}", songId)
        require(!songId.isNullOrEmpty()) { "곡ID를 입력해주세요." }

        return songRepository.findById(songId)
            .switchIfEmpty { Mono.error(NotFoundDataException("곡 정보가 존재하지 않습니다.")) }
    }

    override fun findSongAll(): Flux<Song> =
        songRepository.findAll()

}