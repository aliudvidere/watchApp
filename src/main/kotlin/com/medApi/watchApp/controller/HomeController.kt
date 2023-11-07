package com.medApi.watchApp.controller

import com.medApi.watchApp.model.Constants
import com.medApi.watchApp.model.Count
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import java.io.File
import java.util.Optional


@Controller
class HomeController(
) {

    @GetMapping(value = ["/"])
    fun home(model: Model): String {
        model.addAttribute("title", "Home page")
        val countList = arrayListOf<Count>()
        for (person in Constants.personList){
            val dir = "${Constants.imagePath}/${person}/labeled"
            val listFiles = File(dir).list()
            countList.add(Count(person, Optional.ofNullable(listFiles?.size).orElse(0)))
        }
        model.addAttribute("countList", countList)
        return "home-page"
    }
}