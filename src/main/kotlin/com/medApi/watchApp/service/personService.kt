package com.medApi.watchApp.service

import com.medApi.watchApp.model.Person
import com.medApi.watchApp.repository.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonService(val personRepository: PersonRepository) {
    fun getAllPersons(): List<Person> = personRepository.findAll()
}