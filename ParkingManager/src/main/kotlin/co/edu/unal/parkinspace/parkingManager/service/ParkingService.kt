package co.edu.unal.parkinspace.parkingManager.service

import co.edu.unal.parkinspace.parkingManager.dataAccess.model.Parking
import co.edu.unal.parkinspace.parkingManager.dataAccess.repository.ParkingRepository
import org.springframework.stereotype.Service
import co.edu.unal.parkinspace.parkingManager.exception.ResourceNotFoundException

@Service
class ParkingService(private val parkingRepository: ParkingRepository) {

    fun getAllParkings(): List<Parking> =
        parkingRepository.findAll()

    fun createNewParking(parking: Parking): Parking =
        parkingRepository.save(parking)

    fun getParkingById(parkingId: Long): Parking {
        return parkingRepository.findById(parkingId).orElseThrow { ResourceNotFoundException("Parking", "id", parkingId) }
    }

    fun updateParking(parkingId: Long, parkingDetails: Parking): Parking{
        val parking = getParkingById(parkingId)
        parking.name = parkingDetails.name
        parking.pricePerMinute = parkingDetails.pricePerMinute
        parking.totalSpaces = parkingDetails.totalSpaces
        parking.usedSpaces = parkingDetails.usedSpaces
        return parkingRepository.save(parking)
    }

    fun deleteParking(parkingId: Long){
        val parking = getParkingById(parkingId)
        parkingRepository.delete(parking)
    }
}