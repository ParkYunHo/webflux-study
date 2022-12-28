package com.john.webfluxstudy.song.adapter.`in`.web

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

/**
 * @author yoonho
 * @since 2022.12.28
 */
@Configuration
class SongRouter(
    private val songHandler: SongHandler
) {
    @Bean
    fun songRouterFunction(): RouterFunction<ServerResponse> = router {
        accept(MediaType.APPLICATION_JSON).nest {
            GET("/api/song", songHandler::findSong)
            POST("/api/song", songHandler::saveSong)
        }
    }
}