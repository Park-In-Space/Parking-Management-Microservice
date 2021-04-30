package co.edu.unal.parkinspace.parkingManager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.TimeZone

import javax.annotation.PostConstruct

@SpringBootApplication
class ParkingManagerApplication {

	@PostConstruct
	fun started() {
		TimeZone.setDefault(TimeZone.getTimeZone("TimeZone"))
	}

	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			runApplication<ParkingManagerApplication>(*args)
		}
	}

}
