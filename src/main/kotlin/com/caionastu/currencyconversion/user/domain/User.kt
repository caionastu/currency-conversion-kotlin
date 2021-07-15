package com.caionastu.currencyconversion.user.domain

import com.caionastu.currencyconversion.user.application.request.CreateUserRequest
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class User(

    @Id
    @GeneratedValue
    val id: UUID?,
    var name: String

) {
    companion object {
        fun from(request: CreateUserRequest): User = User(null, request.name)
    }
}