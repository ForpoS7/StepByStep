package by.ebzh.caching.repository

import by.ebzh.caching.model.FileModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface FileRepository: JpaRepository<FileModel,Long>{
    @Query(value = "SELECT id,contentType,fileName,fileContent FROM FileModel ORDER BY RANDOM() LIMIT 1")
    fun getRandomFileModel(): FileModel?
}