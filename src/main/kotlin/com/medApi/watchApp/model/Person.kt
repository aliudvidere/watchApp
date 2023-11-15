package com.medApi.watchApp.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.Getter
import lombok.Setter

@Entity
@Table(name = "PERSON")
@Getter
@Setter
data class Person(
    @Id
    @Column(name = "id", nullable = false)
    var id: Int,
    @Column(nullable = false)
    var name: String
)

