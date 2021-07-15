package com.caionastu.currencyconversion.common.exception

open class NotFoundException(messageKey: String, vararg arguments: Any) : BusinessException(messageKey, arguments) {
}