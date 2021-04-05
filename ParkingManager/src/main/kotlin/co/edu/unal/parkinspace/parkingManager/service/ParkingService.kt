package co.edu.unal.parkinspace.parkingManager.service

import co.edu.unal.parkinspace.parkingManager.dataAccess.model.OpenHours
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
        var removed = 0
        for( i in parking.openHours.indices ){
            if( i >= parkingDetails.openHours.size ) removed ++
            else if( parkingDetails.openHours[i] == null ) parking.openHours[i] = null
            else if( parking.openHours[i] != null ){
                parking.openHours[i]!!.opening = parkingDetails.openHours[i]!!.opening
                parking.openHours[i]!!.closing = parkingDetails.openHours[i]!!.closing
            }else parking.openHours[i] = OpenHours(opening = parkingDetails.openHours[i]!!.opening,
                                                    closing = parkingDetails.openHours[i]!!.closing)
        }
        while ( removed > 0 ){
            parking.openHours.removeLast();
            removed --;
        }
        while( parking.openHours.size < parkingDetails.openHours.size ){
            val position = parking.openHours.size
            parking.openHours.add( parkingDetails.openHours[position] )
        }
        return parkingRepository.save(parking)
    }

    fun deleteParking(parkingId: Long){
        val parking = getParkingById(parkingId)
        parkingRepository.delete(parking)
    }
}