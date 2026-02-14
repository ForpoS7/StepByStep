package by.ebzh.caching.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*
import java.util.Base64.Decoder
import java.util.Base64.Encoder

@Configuration
class Configuration {
    @Bean
    fun encoder(): Encoder{
        return Base64.getEncoder()
    }

    @Bean
    fun decoder(): Decoder{
        return Base64.getDecoder()
    }
}