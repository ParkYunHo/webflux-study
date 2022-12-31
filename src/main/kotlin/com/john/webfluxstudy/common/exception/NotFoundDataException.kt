package com.john.webfluxstudy.common.exception

/**
 * @author yoonho
 * @since 2022.12.31
 */
class NotFoundDataException: RuntimeException {
    constructor(msg: String?): super(msg)
    constructor(): super()
}