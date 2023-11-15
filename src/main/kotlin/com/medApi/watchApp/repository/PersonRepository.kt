package com.medApi.watchApp.repository

import com.medApi.watchApp.model.Person
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : JpaRepository<Person, Int> {
    @Transactional
    fun deletePersonByName(name: String)
}