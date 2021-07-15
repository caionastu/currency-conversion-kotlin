package com.caionastu.currencyconversion.common.exception

import org.springframework.context.MessageSource
import org.springframework.http.HttpStatus
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.util.*

@RestControllerAdvice
class ExceptionAdvice(val messageSource: MessageSource) {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationError(exception: MethodArgumentNotValidException, locale: Locale): ErrorMessage {
        val errorMessage = ErrorMessage(messageSource.getMessage("validation.exception.title", null, locale))
        for (error: ObjectError in exception.bindingResult.allErrors) {
            if (error is FieldError) {
                val message = messageSource.getMessage(error.code ?: "", error.arguments, error.defaultMessage, locale)
                errorMessage.addDetail(message!!)
            } else {
                errorMessage.addDetail(messageSource.getMessage(error.code ?: "", error.arguments, locale))
            }

        }
        return errorMessage
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(exception: BusinessException, locale: Locale): ErrorMessage =
        handleExceptionMessage("business.exception.title", exception, locale)

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(exception: NotFoundException, locale: Locale) =
        handleExceptionMessage("notFound.exception.title", exception, locale)

    private fun handleExceptionMessage(messageKey: String, exception: BusinessException, locale: Locale): ErrorMessage {
        val errorMessage = ErrorMessage(messageSource.getMessage(messageKey, null, locale))
        errorMessage.addDetail(
            messageSource.getMessage(
                exception.messageKey,
                exception.arguments.toTypedArray(),
                locale
            )
        )
        return errorMessage
    }
}