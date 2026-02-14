package by.ebzh.caching.controller

import org.springframework.core.io.ByteArrayResource
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.util.Base64.Decoder
import java.util.Base64.Encoder

@RestController
@RequestMapping("/file")
class FileUploadController(
    private val encoder: Encoder,
    private val decoder: Decoder
) {
    @PostMapping
    fun uploadFile(@RequestParam("file") file: MultipartFile): ResponseEntity<ByteArray> {
        val encodedFile = encoder.encodeToString(file.bytes) // TODO храним content type, название файла и закодированный в base64
        val decodedFile = decoder.decode(encodedFile)
        return ResponseEntity.ok()
            .contentType(MediaType.IMAGE_JPEG)
            .body(decodedFile)
    }

//    @GetMapping
//    fun getFile() {
//        decoder.decode()
//        var resource: ByteArrayResource()
//    }

}