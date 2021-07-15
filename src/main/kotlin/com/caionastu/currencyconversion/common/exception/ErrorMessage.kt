package com.caionastu.currencyconversion.common.exception

class ErrorMessage(val title: String) {
    val details: ArrayList<String> = arrayListOf()

    fun addDetail(detail: String) {
        details.add(detail)
    }
}