package com.caionastu.currencyconversion

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CurrencyConversionApplication

fun main(args: Array<String>) {
	runApplication<CurrencyConversionApplication>(*args)
}
