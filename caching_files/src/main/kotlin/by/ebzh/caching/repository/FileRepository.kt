package by.ebzh.caching.repository

import by.ebzh.caching.model.FileModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FileRepository: JpaRepository<FileModel,Long>{

}