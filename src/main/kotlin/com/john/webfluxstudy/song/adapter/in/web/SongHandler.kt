package com.john.webfluxstudy.song.adapter.`in`.web

import com.john.webfluxstudy.common.dto.BaseResponse
import com.john.webfluxstudy.song.adapter.`in`.web.dto.SongInput
import lombok.extern.slf4j.Slf4j
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.Mono

/**
 * @author yoonho
 * @since 2022.12.28
 */
@Component
class SongHandler {

    fun findSong(request: ServerRequest): Mono<ServerResponse> =
        BaseResponse().success(null)

    fun saveSong(request: ServerRequest): Mono<ServerResponse> =
        BaseResponse().success(null)
}