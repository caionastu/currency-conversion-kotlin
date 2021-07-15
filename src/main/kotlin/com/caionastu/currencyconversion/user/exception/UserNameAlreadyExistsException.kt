package com.caionastu.currencyconversion.user.exception

import com.caionastu.currencyconversion.common.exception.BusinessException

class UserNameAlreadyExistsException(name: String) : BusinessException("user.exception.exist", name) {
}