package com.medApi.watchApp.repository

import com.medApi.watchApp.model.Person
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : CrudRepository<Person, Int> {
    override fun findAll(): List<Person>
}