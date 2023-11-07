package com.medApi.watchApp.controller

import com.medApi.watchApp.model.Image
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.attribute.BasicFileAttributes
import java.time.ZoneId
import java.time.format.DateTimeFormatter


@Controller
class ImageController(
) {

    @GetMapping(value = ["/person"])
    fun home(@RequestParam person: String, model: Model): String {
        model.addAttribute("title", "images $person")
        val dir = "/Users/vladimirberman/Documents/vessels/watchApp/src/main/resources/static/Labeled/${person}/labeled"
        val listFiles = File(dir).list()
        model.addAttribute("person", person)
        val listImages = arrayListOf<Image>()
        listFiles?.forEach {listImages.add(Image(it, Files.readAttributes(Paths.get("$dir/$it"), BasicFileAttributes::class.java).creationTime().toInstant().atZone(
            ZoneId.of("GMT+3")).format(DateTimeFormatter.ISO_LOCAL_DATE)))}
        model.addAttribute("listImages", listImages)
        var lastDate = "never"
        var lastDownload = 0
        if (listImages.size != 0) {
            lastDate = listImages.maxBy { it.creationDate }.creationDate
            lastDownload = listImages.count { it.creationDate == lastDate }
        }
        model.addAttribute("lastDate", lastDate)
        model.addAttribute("lastDownload", lastDownload)
        return "images"
    }
}