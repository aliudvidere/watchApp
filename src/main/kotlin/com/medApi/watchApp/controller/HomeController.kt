package com.medApi.watchApp.controller

import com.medApi.watchApp.model.Constants
import com.medApi.watchApp.model.CountDTO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import java.io.File
import java.util.*


@Controller
class HomeController(
) {

    @GetMapping(value = ["/"])
    fun home(model: Model): String {
        model.addAttribute("title", "Home page")
        val countList = arrayListOf<CountDTO>()
        for (person in Constants.personList){
            val dir = "${Constants.imagePath}/${person}/labeled"
            val listFiles = File(dir).list()
            val count = Optional.ofNullable(listFiles?.size).orElse(0)
            val tableClass = if (count == 0) "table-danger" else "table-light"
            if (person == "TamaraSalamonovna")
                countList.add(CountDTO( "Tamara Salamonovna", count, tableClass))
            else
                countList.add(CountDTO(person, count, tableClass))
        }
        model.addAttribute("countList", countList.sortedBy{-it.numberOfImages})
        model.addAttribute("all", countList.sumOf { it.numberOfImages })
        return "home-page"
    }
}