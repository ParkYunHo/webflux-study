package com.john.webfluxstudy.cucumber.feature.step

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.assertEquals

import com.john.webfluxstudy.common.dto.BaseResponse
import com.john.webfluxstudy.common.handler.ExceptionHandler
import com.john.webfluxstudy.song.adapter.`in`.web.SongRouter
import com.john.webfluxstudy.song.adapter.`in`.web.dto.SongInput
import io.cucumber.java.Before
import io.cucumber.java.ko.그러면
import io.cucumber.java.ko.만약
import io.cucumber.java.ko.먼저
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.HandlerStrategies

/**
 * @author yoonho
 * @since 2023.01.01
 */
class SongStep {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @Autowired
    private lateinit var router: SongRouter
    @Autowired
    private lateinit var objectMapper: ObjectMapper

    private lateinit var webTestClient: WebTestClient
    private lateinit var result:  WebTestClient.ResponseSpec

    private lateinit var songId: String
    private lateinit var songName: String

    @Before(value = "@song")
    fun init() {
        webTestClient = WebTestClient.bindToRouterFunction(router.songRouterFunction())
            .handlerStrategies(
                HandlerStrategies.builder()
                    .exceptionHandler(ExceptionHandler())
                    .build()
            )
            .build()
    }

    @먼저("곡정보 관리API 호출을 위한 {string}{string} 가 있다")
    fun 곡정보_관리API_호출을_위한_가_있다(songId: String, songName: String) {
        this.songId = songId
        this.songName = songName
    }

    @만약("곡정보 관리API를 {string}{string} 요청하면")
    fun 곡정보_관리API를_요청하면(method: String, url: String) {
        var requestUrl = url
        if(url.contains("{songId}")) {
            requestUrl = url.replace("{songId}", this.songId)
        }

        result = webTestClient.method(HttpMethod.valueOf(method))
            .uri(requestUrl)
            .contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(SongInput(songId, songName)))
            .exchange()
    }

    @그러면("곡정보 관리API 호출결과 {int}{string} 를 확인한다")
    fun 곡정보_관리API_호출결과_를_확인한다(code: Int, status: String) {
        // Default 세팅
        this.songId = if(songId.isNullOrEmpty()) "1234" else songId
        this.songName = if(songName.isNullOrEmpty()) "TEST" else songName
        //

        result
            .expectStatus().isEqualTo(code)
            .expectBody(BaseResponse::class.java)
            .value {
                logger.info(" >>> response: {}", it.toString())
                assertEquals(it.status.name, status)

                if(it.data != null) {
                    lateinit var data: Any
                    when(it.data) {
                        is SongStep -> {
                            data = it.data as SongStep
                            assertEquals(data.songId, this.songId)
                            assertEquals(data.songName, this.songName ?: "TEST")
                        }
                        is List<*> -> {
                            data = it.data as List<*>

                            data.forEach {
                                val item = objectMapper.convertValue(it, com.john.webfluxstudy.song.domain.Song::class.java)
                                assertEquals(item.songId, this.songId)
                                assertEquals(item.songName, this.songName)
                            }
                        }
                    }
                }
            }
    }
}