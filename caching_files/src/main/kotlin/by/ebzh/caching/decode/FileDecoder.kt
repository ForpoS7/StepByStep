package by.ebzh.caching.decode

import lombok.extern.slf4j.Slf4j
import java.nio.file.Files
import java.nio.file.Paths
import java.util.Base64

@Slf4j
class FileDecoder {
    fun decodeToString() : String {
        val path = Paths.get("C:",
            "Users", "Кирилл", "IdeaProjects", "OOOOOOOOOOO", "StepByStep",
            "caching_files", "qwe", "photo_2026-02-11_18-44-27.jpg") // TODO подумать как задавать путь в пропертях

        val exist = Files.exists(path)
        println(exist)

        val fileBytes = Files.readAllBytes(path)

        val res = Base64.getEncoder().encodeToString(fileBytes)
        println(res)

        return res
    }
}