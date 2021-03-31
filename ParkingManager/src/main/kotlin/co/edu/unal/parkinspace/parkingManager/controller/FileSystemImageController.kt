package co.edu.unal.parkinspace.parkingManager.controller

import org.springframework.web.bind.annotation.RestController
import co.edu.unal.parkinspace.parkingManager.service.FileLocationService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.bind.annotation.PathVariable
import co.edu.unal.parkinspace.parkingManager.dataAccess.model.Parking
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.core.io.FileSystemResource
import org.springframework.http.MediaType

@RestController
internal class FileSystemImageController(private val fileLocationService: FileLocationService) {
    @PostMapping("/parking/image/{id}")
    fun saveImageToParkingId( @RequestParam image: MultipartFile, @PathVariable(value = "id") parkingId: Long): Parking {
        return fileLocationService.saveImageToParkingId(image.bytes, image.originalFilename!!, parkingId)
    }

    @GetMapping(value = ["/parking/image/{id}"], produces = [MediaType.IMAGE_JPEG_VALUE])
    fun findImageByParkingId(@PathVariable(value = "id") parkingId: Long): FileSystemResource {
        return fileLocationService.findImageByParkingId(parkingId)
    }
}