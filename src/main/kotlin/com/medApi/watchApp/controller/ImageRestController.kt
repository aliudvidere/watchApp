package com.medApi.watchApp.controller

import com.medApi.watchApp.model.Image
import com.medApi.watchApp.service.ImageService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/service/image")
class ImageRestController(val imageService: ImageService) {

    @GetMapping(value = ["/get-images"], produces = ["application/json"])
    fun getAllImages(): List<Image>{
        return imageService.getAllImages()
    }

    @DeleteMapping(value = ["/delete-image"], produces = ["application/json"])
    fun deleteImage(@RequestParam name: String): List<Image>{
        return imageService.deleteImage(name)
    }

//    @PostMapping(value = ["/add-image"], produces = ["application/json"])
//    fun addPerson(@RequestParam name: String): List<Person>{
//        return personService.addPerson(name)
//    }

    @GetMapping(value = ["/count-images"], produces = ["application/json"])
    fun countImages(): Long{
        return imageService.countImages()
    }

}