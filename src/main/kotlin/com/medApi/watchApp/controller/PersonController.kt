package com.medApi.watchApp.controller

import com.medApi.watchApp.model.Person
import com.medApi.watchApp.service.PersonService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController(val personService: PersonService) {

    @GetMapping(value = ["/service/get-persons"], produces = ["application/json"])
    fun getAllPersons(): List<Person>{
        return personService.getAllPersons()
    }

    @DeleteMapping(value = ["/service/delete-person"], produces = ["application/json"])
    fun deletePerson(@RequestParam name: String): List<Person>{
        return personService.deletePerson(name)
    }

    @GetMapping(value = ["/service/add-person"], produces = ["application/json"])
    fun addPerson(@RequestParam name: String): List<Person>{
        return personService.addPerson(name)
    }

    @GetMapping(value = ["/service/count-persons"], produces = ["application/json"])
    fun countPersons(): Long{
        return personService.countPersons()
    }

}