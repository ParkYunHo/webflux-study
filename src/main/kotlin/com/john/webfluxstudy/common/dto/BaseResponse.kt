package com.john.webfluxstudy.common.dto

import org.springframework.http.HttpStatus
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerResponse
import java.io.Serializable

/**
 * @author yoonho
 * @since 2022.12.28
 */
data class BaseResponse (
    val message: String?,
    val status: HttpStatus,
    val data: Any?
): Serializable {
    constructor(): this(message = "Success", status = HttpStatus.OK, null)
    constructor(message: String?, status: HttpStatus): this(message = message, status = status, null)

    fun error(status: HttpStatus, message: String) =
        ServerResponse.status(status)
            .bodyValue(
                BaseResponse(
                    message = message,
                    status = status,
                    null
                )
            )

    fun success(data: Any?) =
        ServerResponse.ok().body(
            BodyInserters.fromValue(
                BaseResponse(
                    message = "Success",
                    status = HttpStatus.OK,
                    data
                )
            )
        )

    fun successNoContent() =
        ServerResponse.ok().body(
            BodyInserters.fromValue(
                BaseResponse(
                    message = "Success",
                    status = HttpStatus.OK,
                    null
                )
            )
        )
}