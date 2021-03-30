package co.edu.unal.parkinspace.parkingManager.controller

import co.edu.unal.parkinspace.parkingManager.dataAccess.model.Parking
import co.edu.unal.parkinspace.parkingManager.service.ParkingService
import org.springframework.web.bind.annotation.*

@RestController
class ParkingController(private val parkingService: ParkingService) {

    @GetMapping("/parkings")
    fun getAllParkings(): List<Parking> =
        parkingService.getAllParkings()

    @PostMapping("/parking")
    fun createNewParking(@RequestBody parking: Parking): Parking =
        parkingService.createNewParking(parking)

    @GetMapping("/parking/{id}")
    fun getParkingById(@PathVariable(value = "id") parkingId: Long): Parking =
        parkingService.getParkingById(parkingId)

    @PutMapping("/parking/{id}")
    fun updateParking(@PathVariable(value = "id") parkingId: Long, @RequestBody parkingDetails: Parking): Parking =
        parkingService.updateParking(parkingId, parkingDetails)

    @DeleteMapping("/parking/{id}")
    fun deleteParking(@PathVariable(value = "id") parkingId: Long) {
        parkingService.deleteParking(parkingId)
    }

}