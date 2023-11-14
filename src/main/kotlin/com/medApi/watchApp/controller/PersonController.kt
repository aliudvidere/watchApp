package com.medApi.watchApp.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import com.medApi.watchApp.model.Person
import com.medApi.watchApp.service.PersonService

@RestController
class PersonController(val personService: PersonService) {
    @GetMapping(value = ["/service/get-persons"], produces = ["application/json"])
    fun getAllPersons(): List<Person>{
        return personService.getAllPersons()
    }
}