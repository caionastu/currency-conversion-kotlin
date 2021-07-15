package com.caionastu.currencyconversion.user.application.response

import com.caionastu.currencyconversion.user.domain.User
import java.util.*

class UserResponse(val id: UUID, val name: String) {
    companion object {
        fun from(user: User) = user.id?.let { UserResponse(it, user.name) }
    }
}