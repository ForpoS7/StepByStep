package by.ebzh.caching.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class FileModel (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Column(nullable = false)
    var contentType: String,
    @Column(nullable = false)
    var fileName: String,
    @Column(nullable = false)
    var fileContent: String
){
}