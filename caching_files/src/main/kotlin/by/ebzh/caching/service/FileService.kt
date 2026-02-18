package by.ebzh.caching.service

import by.ebzh.caching.model.FileModel
import by.ebzh.caching.repository.FileRepository
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class FileService(
    private val fileRepo: FileRepository,
    private val redisTemplate: RedisTemplate<String, FileModel>
){
    companion object {
        private const val CACHE_KEY_PREFIX = "fileModel:"
        private val TTL = Duration.ofSeconds(10)
    }

    fun saveFileModel(fileModel: FileModel) {
        fileRepo.save(fileModel)
    }

    fun getFileModelById(id: Long): FileModel?{
        val key = CACHE_KEY_PREFIX + id

        var fileModel = redisTemplate.opsForValue().get(key)
        if (fileModel == null) {
            fileModel = fileRepo.findById(id).orElseThrow()
            redisTemplate.opsForValue().set(key, fileModel, TTL)
        }

        return fileModel
    }
}