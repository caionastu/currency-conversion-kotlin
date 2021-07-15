package com.caionastu.currencyconversion.user.repository

import com.caionastu.currencyconversion.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository: JpaRepository<User, UUID> {
    fun existsByName(name: String) : Boolean
}