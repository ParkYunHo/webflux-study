package com.john.webfluxstudy.common.dto

import org.springframework.http.HttpStatus
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerResponse

/**
 * @author yoonho
 * @since 2022.12.28
 */
class BaseResponse (
    val message: String?,
    val status: HttpStatus,
    val data: Any?
) {
    constructor(): this(message = "Success", status = HttpStatus.OK, null)
    constructor(message: String?, status: HttpStatus): this(message = message, status = status, null)

    fun success(data: Any?) =
        ServerResponse.ok().body(BodyInserters.fromValue(BaseResponse(message = "Success", status = HttpStatus.OK, data)))

    // TEST
    fun success() =
        BaseResponse(message = "Success", status = HttpStatus.OK, data)
    //

    fun successNoContent() =
        ServerResponse.ok().body(BodyInserters.fromValue(BaseResponse(message = "Success", status = HttpStatus.OK, null)))
}