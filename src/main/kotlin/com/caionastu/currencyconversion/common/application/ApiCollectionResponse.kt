package com.caionastu.currencyconversion.common.application

import org.springframework.data.domain.Page

class ApiCollectionResponse<T>(
    val hasNext: Boolean,
    val pageSize: Int,
    val pageNumber: Int,
    val totalElements: Long,
    val items: Collection<T> = listOf()
) {
    companion object {
        fun <T> from(page: Page<T>): ApiCollectionResponse<T> = ApiCollectionResponse(
            page.hasNext(),
            page.size,
            page.number,
            page.totalElements,
            page.content
        )
    }
}

