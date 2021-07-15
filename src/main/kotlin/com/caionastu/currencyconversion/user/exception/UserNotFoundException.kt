package com.caionastu.currencyconversion.user.exception

import com.caionastu.currencyconversion.common.exception.NotFoundException
import java.util.*

class UserNotFoundException(id: UUID) : NotFoundException("user.exception.notFound", id) {
}