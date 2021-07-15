package com.caionastu.currencyconversion.common.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*

@Configuration
class TimeZoneConfiguration {

    @Bean
    fun timeZone(): TimeZone {
        val timeZone = TimeZone.getTimeZone("UTC")
        TimeZone.setDefault(timeZone)
        return timeZone
    }
}