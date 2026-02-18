package by.ebzh.caching.controller

import by.ebzh.caching.exception.SizeLimitException
import by.ebzh.caching.service.FileService
import by.ebzh.caching.model.FileModel
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/file")
class FileUploadController(
    private val fileService: FileService
) {
    @PostMapping
    fun uploadFile(@RequestParam("file") file: MultipartFile) {
        if (file.size == 1048576.toLong()) {
            throw SizeLimitException("File size must be less than 1MB")
        }
        val fileModel = FileModel(null, file.contentType!!, file.originalFilename!!, file.bytes)
        fileService.saveFileModel(fileModel)
    }

    @GetMapping
    fun getFileById(@RequestParam("id") id: Long): ResponseEntity<ByteArray> {
        val fileModel = fileService.getFileModelById(id)
        if (fileModel != null) {
            return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileModel.contentType))
                .body(fileModel.fileContent)
        }
        return ResponseEntity.ok().body(null)
    }
}