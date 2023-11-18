package com.medApi.watchApp.repository

import com.medApi.watchApp.model.Image
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ImageRepository : JpaRepository<Image, Int> {
    @Transactional
    fun deleteImageByName(name: String)
}