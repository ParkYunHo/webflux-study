package com.john.webfluxstudy.song.adapter.`in`.web

import com.john.webfluxstudy.song.domain.Song
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.parameters.RequestBody
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springdoc.core.annotations.RouterOperation
import org.springdoc.core.annotations.RouterOperations
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMethod
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
    @RouterOperations(
        value = [
            RouterOperation(
                path = "/api/song/{songId}",
                method = [RequestMethod.GET],
                beanClass = SongHandler::class,
                beanMethod = "findSong",
                operation = Operation(
                    tags = ["곡"],
                    summary = "특정 곡정보 조회",
                    operationId = "findSong",
                    requestBody = RequestBody(
                        content = [Content(
                            schema = Schema(
                                implementation = Song::class
                            )
                        )]
                    ),
                    responses = [
                        ApiResponse(
                            responseCode = "200",
                            content = [Content(schema = Schema(implementation = Song::class))]
                        )
                    ],
                )
            ),
//            RouterOperation(
//                path = "/api/song",
//                method = [RequestMethod.GET],
//                beanClass = SongHandler::class,
//                beanMethod = "findSongAll",
//                operation = Operation(
//                    tags = ["곡"],
//                    summary = "전체 곡정보 조회",
//                    operationId = "findSongAll",
//                    requestBody = RequestBody(
//                        content = [Content(
//                            schema = Schema(
//                                implementation = Song::class
//                            )
//                        )]
//                    ),
//                    responses = [
//                        ApiResponse(
//                            responseCode = "200",
//                            content = [Content(schema = Schema(implementation = Song::class))]
//                        )
//                    ],
//                )
//            ),
//            RouterOperation(
//                path = "/api/song",
//                method = [RequestMethod.POST],
//                beanClass = SongHandler::class,
//                beanMethod = "saveSong",
//                operation = Operation(
//                    tags = ["곡"],
//                    summary = "곡정보 저장",
//                    operationId = "saveSong",
//                    requestBody = RequestBody(
//                        content = [Content(
//                            schema = Schema(
//                                implementation = Song::class
//                            )
//                        )]
//                    ),
//                    responses = [
//                        ApiResponse(
//                            responseCode = "200",
//                            content = [Content(schema = Schema(implementation = Song::class))]
//                        )
//                    ],
//                )
//            ),
        ]
    )
    fun songRouterFunction(): RouterFunction<ServerResponse> = router {
        accept(MediaType.APPLICATION_JSON).nest {
            GET("/api/song/{songId}", songHandler::findSong)
            GET("/api/song", songHandler::findSongAll)
            POST("/api/song", songHandler::saveSong)
        }
    }
}