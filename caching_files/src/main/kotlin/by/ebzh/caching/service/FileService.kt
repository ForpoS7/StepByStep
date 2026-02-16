package by.ebzh.caching.service

import by.ebzh.caching.model.FileModel
import by.ebzh.caching.repository.FileRepository
import org.springframework.stereotype.Service

@Service
class FileService(
    private val fileRepo: FileRepository
){
    fun saveFileModel(fileModel: FileModel) {
        fileRepo.save(fileModel)
    }

    fun getFileModel(): FileModel{
        return fileRepo.findById(3).orElseThrow() // TODO убрать заглушку, добавить функционал рандома какой-нить
    }
}