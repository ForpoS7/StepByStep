package by.ebzh.caching.controller

import by.ebzh.caching.decode.FileEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/upload")
class FileUploadController {
    private val encoder = FileEncoder()
    @PostMapping
    fun uploadFile(@RequestParam("file") file: MultipartFile) {
        println(encoder.decodeToString(file.inputStream))
    }
}