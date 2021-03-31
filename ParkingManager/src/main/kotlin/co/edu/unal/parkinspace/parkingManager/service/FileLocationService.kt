package co.edu.unal.parkinspace.parkingManager.service

import co.edu.unal.parkinspace.parkingManager.dataAccess.repository.FileSystemRepository
import co.edu.unal.parkinspace.parkingManager.dataAccess.repository.ParkingRepository
import co.edu.unal.parkinspace.parkingManager.dataAccess.model.Parking
import co.edu.unal.parkinspace.parkingManager.exception.ResourceNotFoundException
import org.springframework.core.io.FileSystemResource
import org.springframework.stereotype.Service

@Service
class FileLocationService (private val parkingRepository: ParkingRepository , private val fileSystemRepository: FileSystemRepository ) {

    fun saveImageToParkingId(bytes: ByteArray?, imageName: String, parkingId: Long): Parking {
        val parking = parkingRepository.findById(parkingId).orElseThrow { ResourceNotFoundException("Parking", "id", parkingId) }
        val location = fileSystemRepository.save(bytes, imageName)
        parking.imageLocation = location
        return parkingRepository.save(parking)
    }

    fun findImageByParkingId(parkingId: Long): FileSystemResource {
        val parking = parkingRepository.findById(parkingId).orElseThrow { ResourceNotFoundException("Parking", "id", parkingId) }
        return fileSystemRepository.findInFileSystem(parking.imageLocation)
    }
}