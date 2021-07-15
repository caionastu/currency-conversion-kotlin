package com.caionastu.currencyconversion.common.exception

open class BusinessException(val messageKey: String) : RuntimeException() {
    var arguments: List<Any> = listOf()
        private set

    constructor(messageKey: String, vararg arguments: Any) : this(messageKey) {
        this.arguments = arguments.asList()
    }

}