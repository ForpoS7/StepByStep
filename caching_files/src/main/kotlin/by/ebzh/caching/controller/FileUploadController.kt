package by.ebzh.caching.controller

import by.ebzh.caching.service.FileService
import by.ebzh.caching.model.FileModel
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.util.Base64.Decoder
import java.util.Base64.Encoder

@RestController
@RequestMapping("/file")
class FileUploadController(
    private val encoder: Encoder,
    private val decoder: Decoder,
    private val fileService: FileService
) {
    @PostMapping
    fun uploadFile(@RequestParam("file") file: MultipartFile) {
        val encodedFile = encoder.encodeToString(file.bytes) // TODO храним content type, название файла и закодированный в base64
        val fileModel = FileModel(null, file.contentType!!, file.originalFilename!!, encodedFile)
        fileService.saveFile(fileModel)
    }

//    @GetMapping
//    fun getFile(): ResponseEntity<ByteArray> {
//        val decodedFile = decoder.decode(encodedFile)
//        return ResponseEntity.ok()
//            .contentType(MediaType.IMAGE_JPEG)
//            .body(decodedFile)
//    }
}