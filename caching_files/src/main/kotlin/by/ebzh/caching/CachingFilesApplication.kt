package by.ebzh.caching

import by.ebzh.caching.decode.FileDecoder
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CachingFilesApplication

fun main(args: Array<String>) {
	runApplication<CachingFilesApplication>(*args)

	val fileDecoder = FileDecoder()
	fileDecoder.decodeToString()
}
