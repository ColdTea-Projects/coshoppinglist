package de.coldtea.coshoppinglist.apiinfo

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.*

@RestController
class InfoController {

    @Value("\${api_version}")
    private lateinit var version: String

    @GetMapping("/api_version")
    fun getHomePage() = "Current version of Coshoppinglist API : $version"
}