package com.caionastu.currencyconversion.common.util

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort

fun sortIfUnsorted(pageable: Pageable, sort: Sort): Pageable {
    return if (!pageable.sort.isSorted) pageable
    else PageRequest.of(pageable.pageNumber, pageable.pageSize, sort)
}