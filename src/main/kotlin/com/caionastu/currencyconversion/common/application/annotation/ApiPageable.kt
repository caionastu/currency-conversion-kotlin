package com.caionastu.currencyconversion.common.application.annotation

import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.TYPE)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@ApiImplicitParams(
    ApiImplicitParam(name = "page", dataTypeClass = Int::class, paramType = "query", value = "Page number."),
    ApiImplicitParam(
        name = "size",
        dataTypeClass = Int::class,
        paramType = "query",
        value = "Number of records per page."
    ),
    ApiImplicitParam(
        name = "sort",
        allowMultiple = true,
        dataTypeClass = String::class,
        paramType = "query",
        value = "Sorting criteria in the format: property,asc|desc."
    )
)
annotation class ApiPageable()
