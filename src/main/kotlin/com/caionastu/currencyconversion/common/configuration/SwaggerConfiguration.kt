package com.caionastu.currencyconversion.common.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

@Configuration
class SwaggerConfiguration {

    @Bean
    fun swaggerDocket(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .apiInfo(ApiInfoBuilder()
                .title("Currency Conversion")
                .version("1.0.0")
                .description("An App that convert two currencies with updated tax rate.")
                .contact(Contact("Caio de Melo Nastulevitie", "https://github.com/caionastu", "caionast@gmail.com"))
                .build())
            .enable(true)
            .select()
            .paths(PathSelectors.any())
            .apis(RequestHandlerSelectors.basePackage("com.caionastu.currencyconversion"))
            .build()
            .useDefaultResponseMessages(false)
    }
}