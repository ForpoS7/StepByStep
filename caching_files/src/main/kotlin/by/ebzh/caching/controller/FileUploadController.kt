package by.ebzh.caching.controller

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
        val fileModel = FileModel(null, file.contentType!!, file.originalFilename!!, file.bytes)
        fileService.saveFileModel(fileModel)
    }

    @GetMapping
    fun getFile(): ResponseEntity<ByteArray> {
        val fileModel = fileService.getFileModel()
        if (fileModel != null) {
            return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileModel.contentType))
                .body(fileModel.fileContent)
        }
        return ResponseEntity.ok().body(null)
    }
}