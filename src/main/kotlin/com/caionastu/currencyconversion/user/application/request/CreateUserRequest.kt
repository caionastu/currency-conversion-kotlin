package com.caionastu.currencyconversion.user.application.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

class CreateUserRequest(
    @get:NotBlank(message = "{user.name.notBlank}")
    @get:Size(min = 4, max = 50, message = "{user.name.size}")
    val name: String
) {
}