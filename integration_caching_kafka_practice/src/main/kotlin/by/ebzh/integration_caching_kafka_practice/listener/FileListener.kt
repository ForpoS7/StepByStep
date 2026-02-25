package by.ebzh.integration_caching_kafka_practice.listener

import by.ebzh.integration_caching_kafka_practice.message.FileMessage
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class FileListener {
    @KafkaListener(topics = ["file"], id = "integration", concurrency = "2",
        properties = ["spring.json.value.default.type=by.ebzh.integration_caching_kafka_practice.message.FileMessage"])
    fun listen(fileMessage: FileMessage) {
        println(fileMessage.toString())
    }
}