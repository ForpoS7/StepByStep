package by.ebzh.caching.service

import by.ebzh.caching.model.FileModel
import by.ebzh.caching.producer.FileProducer
import by.ebzh.caching.repository.FileRepository
import org.slf4j.LoggerFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service
import java.net.ConnectException
import java.time.Duration

@Service
class FileService(
    private val fileRepo: FileRepository,
    private val redisTemplate: RedisTemplate<String, FileModel>
){
    companion object {
        private val log = LoggerFactory.getLogger(FileService::class.java)
        private const val CACHE_KEY_PREFIX = "fileModel:"
        private val TTL = Duration.ofSeconds(10)
    }

    fun saveFileModel(fileModel: FileModel) {
        fileRepo.save(fileModel)
    }

    fun getFileModelById(id: Long): FileModel?{
        val key = CACHE_KEY_PREFIX + id

        return try {
            redisTemplate.opsForValue().get(key)
                ?: fileRepo.findById(id).orElseThrow().also {
                    redisTemplate.opsForValue().set(key, it, TTL)
                }
        } catch (e : ConnectException) {
            log.warn("Redis unavailable, falling back to DB: ${e.message}")
            fileRepo.findById(id).orElseThrow()
        }
    }
}