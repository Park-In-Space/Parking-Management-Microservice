package co.edu.unal.parkinspace.parkingManager.dataAccess.repository

import co.edu.unal.parkinspace.parkingManager.exception.ResourceNotFoundException
import kotlin.Throws
import org.springframework.core.io.FileSystemResource
import org.springframework.stereotype.Repository
import java.lang.Exception
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

@Repository
class FileSystemRepository {
    var RESOURCES_DIR = FileSystemRepository::class.java.getResource("/")
        .path

    @Throws(Exception::class)
    fun save(content: ByteArray?, imageName: String): String {
        val newFile = Paths.get(RESOURCES_DIR + Date().time + "-" + imageName)
        Files.createDirectories(newFile.parent)
        Files.write(newFile, content)
        return newFile.toAbsolutePath()
            .toString()
    }

    fun findInFileSystem(location: String?): FileSystemResource {
        return try {
            FileSystemResource(Paths.get(location))
        } catch (e: Exception) {
            // Handle access or file not found problems.
            throw ResourceNotFoundException( "Parking" , "photo" , location )
        }
    }
}