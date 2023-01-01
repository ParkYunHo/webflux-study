package com.john.webfluxstudy.cucumber.feature.step

import com.john.webfluxstudy.song.adapter.`in`.web.SongHandler
import com.john.webfluxstudy.song.adapter.`in`.web.SongRouter
import io.cucumber.java.ko.그러면
import io.cucumber.java.ko.만약
import io.cucumber.java.ko.먼저
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions

/**
 * @author yoonho
 * @since 2023.01.01
 */
class Song {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @Autowired
    private lateinit var mockMvc: MockMvc
    private var resultActions: ResultActions? = null

    @먼저("곡정보 관리API 호출을 위한 {string}{string} 가 있다")
    fun 곡정보_관리API_호출을_위한_가_있다(songId: String, songName: String) {

    }

    @만약("곡정보 관리API를 {string}{string} 요청하면")
    fun 곡정보_관리API를_요청하면(method: String, url: String) {

    }

    @그러면("곡정보 관리API 호출결과 {int}{string} 를 확인한다")
    fun 곡정보_관리API_호출결과_를_확인한다(code: Int, status: String) {

    }
}