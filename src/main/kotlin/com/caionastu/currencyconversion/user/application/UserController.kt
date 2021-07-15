package com.caionastu.currencyconversion.user.application

import com.caionastu.currencyconversion.common.application.ApiCollectionResponse
import com.caionastu.currencyconversion.common.application.annotation.ApiPageable
import com.caionastu.currencyconversion.common.util.sortIfUnsorted
import com.caionastu.currencyconversion.user.application.request.CreateUserRequest
import com.caionastu.currencyconversion.user.application.response.UserResponse
import com.caionastu.currencyconversion.user.domain.User
import com.caionastu.currencyconversion.user.exception.UserNameAlreadyExistsException
import com.caionastu.currencyconversion.user.repository.UserRepository
import mu.KotlinLogging
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import springfox.documentation.annotations.ApiIgnore
import javax.validation.Valid

@RestController
@RequestMapping("/api/users")
class UserController(private val repository: UserRepository) {

    private val log = KotlinLogging.logger {}

    @ApiPageable
    @GetMapping
    fun findAll(@ApiIgnore pageable: Pageable): ResponseEntity<ApiCollectionResponse<UserResponse>> {
        log.info("Receiving request to find all users.")
        val pageableRequest = sortIfUnsorted(pageable, Sort.by(Sort.Direction.ASC, "name"))
        val usersResponse: Page<UserResponse> = repository.findAll(pageableRequest)
            .map { UserResponse.from(it) }

        val response = ApiCollectionResponse.from(usersResponse)
        log.info("Retrieving all users.")
        return ResponseEntity.ok(response)
    }

    @PostMapping
    fun create(@Valid @RequestBody request: CreateUserRequest): ResponseEntity<UserResponse> {
        log.info("Receiving request to create new user with name: {}.", request.name);

        if (repository.existsByName(request.name)) {
            log.error("Error creating user. Name {} is already in use.", request.name);
            throw UserNameAlreadyExistsException(request.name)
        }

        var newUser = User.from(request)
        newUser = repository.save(newUser)
        log.info("User created. Id: {}.", newUser.id);

        val response = UserResponse.from(newUser)
        return ResponseEntity.ok(response)
    }
}

