package com.john.webfluxstudy.song.adapter.`in`.web

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

    fun songInfo(request: ServerRequest): Mono<ServerResponse> =
        request.bodyToMono<ServerResponse>()
            .flatMap {
                ServerResponse.ok().body(BodyInserters.fromValue(it))
            }
}