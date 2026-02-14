package by.ebzh.caching.decode

import java.io.FileInputStream
import java.io.InputStream
import java.nio.file.Files
import java.nio.file.Paths
import java.util.Base64

class FileEncoder {
    fun decodeToString(inputStream: InputStream) : String {
//        val path = Paths.get("C:",
//            "Users", "Кирилл", "IdeaProjects", "OOOOOOOOOOO", "StepByStep",
//            "caching_files", "qwe", "photo_2026-02-11_18-44-27.jpg") // TODO подумать как задавать путь в пропертях
//        val fileBytes = Files.readAllBytes(inputStream)
        val fileBytes = inputStream.readAllBytes()
        val res = Base64.getEncoder().encodeToString(fileBytes)
        return res
    }
}