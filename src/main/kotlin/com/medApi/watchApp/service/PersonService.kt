package com.medApi.watchApp.service

import com.medApi.watchApp.model.Person
import com.medApi.watchApp.repository.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonService(val personRepository: PersonRepository) {
    fun getAllPersons(): List<Person> = personRepository.findAll()
    fun deletePerson(name: String): List<Person>{
        personRepository.deletePersonByName(name)
        return getAllPersons()
    }
    fun countPersons(): Long{
        return personRepository.count()
    }
    fun addPerson(name: String): List<Person>{
        personRepository.save(Person(countPersons().toInt() + 1, name))
        return getAllPersons()
    }
}