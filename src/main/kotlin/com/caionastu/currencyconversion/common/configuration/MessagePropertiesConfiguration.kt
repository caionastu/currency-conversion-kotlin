package com.caionastu.currencyconversion.common.configuration

import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean

@Configuration
class MessagePropertiesConfiguration {

    @Bean
    fun messageSource(): MessageSource {
        val messageSource = ResourceBundleMessageSource()
        messageSource.setBasename("messages/messages")
        messageSource.setDefaultEncoding("UTF-8")
        messageSource.setUseCodeAsDefaultMessage(true)
        return messageSource
    }

    @Bean
    fun getValidatorFactoryBean(): LocalValidatorFactoryBean {
        val factoryBean = LocalValidatorFactoryBean()
        factoryBean.setValidationMessageSource(messageSource())
        return factoryBean
    }
}