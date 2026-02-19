package by.ebzh.caching.producer

import by.ebzh.caching.model.FileModel
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class FileProducer (
    private val kafkaTemplate: KafkaTemplate<String, FileModel>
){
    fun sendFile(fileModel: FileModel) {
        kafkaTemplate.send("file", fileModel)
    }
}