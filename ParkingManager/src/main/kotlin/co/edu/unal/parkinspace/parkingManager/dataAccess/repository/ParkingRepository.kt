package co.edu.unal.parkinspace.parkingManager.dataAccess.repository

import co.edu.unal.parkinspace.parkingManager.dataAccess.model.Parking
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ParkingRepository : JpaRepository<Parking, Long>