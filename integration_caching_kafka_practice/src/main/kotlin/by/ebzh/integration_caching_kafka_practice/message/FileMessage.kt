package by.ebzh.integration_caching_kafka_practice.message

data class FileMessage (
    var id: Long? = null,
    var contentType: String,
    var fileName: String,
    var fileContent: ByteArray
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as FileMessage

        if (id != other.id) return false
        if (contentType != other.contentType) return false
        if (fileName != other.fileName) return false
        if (!fileContent.contentEquals(other.fileContent)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + contentType.hashCode()
        result = 31 * result + fileName.hashCode()
        result = 31 * result + fileContent.contentHashCode()
        return result
    }
}