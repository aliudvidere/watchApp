package com.medApi.watchApp.service

import com.medApi.watchApp.model.Image
import com.medApi.watchApp.repository.ImageRepository
import org.springframework.stereotype.Service

@Service
class ImageService(val imageRepository: ImageRepository) {
    fun getAllImages(): List<Image> = imageRepository.findAll()
    fun deleteImage(name: String): List<Image>{
        imageRepository.deleteImageByName(name)
        return getAllImages()
    }
    fun countImages(): Long{
        return imageRepository.count()
    }
//    fun addImage(name: String): List<Person>{
//        imageRepository.save(Image(countPersons().toInt() + 1, name))
//        return getAllPersons()
//    }
}