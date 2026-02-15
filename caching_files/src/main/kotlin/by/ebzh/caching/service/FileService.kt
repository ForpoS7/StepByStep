package by.ebzh.caching.service

import by.ebzh.caching.model.FileModel
import by.ebzh.caching.repository.FileRepository
import org.springframework.stereotype.Service

@Service
class FileService(
    private val fileRepo: FileRepository
){
    fun saveFile(fileModel: FileModel) {
        fileRepo.save(fileModel)
    }
}