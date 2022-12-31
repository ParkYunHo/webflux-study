package com.john.webfluxstudy.song.adapter.`in`.web

import com.john.webfluxstudy.common.dto.BaseResponse
import com.john.webfluxstudy.song.adapter.`in`.web.dto.SongInput
import com.john.webfluxstudy.song.application.port.`in`.FindSongUseCase
import com.john.webfluxstudy.song.application.port.`in`.SaveSongUseCase
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * @author yoonho
 * @since 2022.12.28
 */
@Component
class SongHandler(
    private val findSongUseCase: FindSongUseCase,
    private val saveSongUseCase: SaveSongUseCase
) {
    private val log = LoggerFactory.getLogger(this::class.java)

    fun findSong(request: ServerRequest): Mono<ServerResponse> =
        findSongUseCase.findSong(request.pathVariable("songId").toString())
            .flatMap { BaseResponse().success(it) }

    fun findSongAll(request: ServerRequest): Mono<ServerResponse> =
        findSongUseCase.findSongAll()
            .collectList()
            .flatMap { BaseResponse().success(it) }

    fun saveSong(request: ServerRequest): Mono<ServerResponse> =
        request.bodyToMono(SongInput::class.java)
            .flatMap { saveSongUseCase.saveSong(it) }
            .flatMap { BaseResponse().success(it) }
}