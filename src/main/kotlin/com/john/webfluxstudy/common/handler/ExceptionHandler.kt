package com.john.webfluxstudy.common.handler

import com.john.webfluxstudy.common.dto.BaseResponse
import com.john.webfluxstudy.common.exception.NotFoundDataException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.web.WebProperties
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler
import org.springframework.boot.web.reactive.error.ErrorAttributes
import org.springframework.context.ApplicationContext
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.codec.ServerCodecConfigurer
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*
import reactor.core.publisher.Mono

/**
 * @note
 *  - @Order(-2): DefaultErrorWebExceptionHandler가 "@Order(-1)"로 설정되어 있어 먼저 실행하려면 -2로 설정해야 됨
 *
 * @author yoonho
 * @since 2022.12.31
 */
@Component
@Order(-2)
class ExceptionHandler(
    errorAttributes: ErrorAttributes,
    resources: WebProperties,
    applicationContext: ApplicationContext,
    serverCodecConfigurer: ServerCodecConfigurer,
): AbstractErrorWebExceptionHandler(errorAttributes, resources.resources, applicationContext) {

    init {
        super.setMessageReaders(serverCodecConfigurer.readers)
        super.setMessageWriters(serverCodecConfigurer.writers)
    }

    override fun getRoutingFunction(errorAttributes: ErrorAttributes?): RouterFunction<ServerResponse> =
        RouterFunctions.route(RequestPredicates.all(), this::handleError)

    private fun handleError(request: ServerRequest): Mono<ServerResponse> =
        when(val throwable = super.getError(request)) {
            is NotFoundDataException -> BaseResponse().error(HttpStatus.BAD_REQUEST, throwable.javaClass.simpleName + ": " + throwable.message)
            else -> {
                throwable.printStackTrace()
                BaseResponse().error(HttpStatus.BAD_REQUEST, throwable.javaClass.simpleName + ": " + throwable.message)
            }
        }
}