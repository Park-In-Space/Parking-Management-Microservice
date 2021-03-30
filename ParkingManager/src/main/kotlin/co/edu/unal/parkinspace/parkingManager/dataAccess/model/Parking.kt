package co.edu.unal.parkinspace.parkingManager.dataAccess.model

import javax.persistence.*

@Entity( name = "parking" )
data class Parking (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column( name = "name" , nullable = false )
    val name: String = "",

    @Column( name = "total_spaces" , nullable = false )
    val totalSpaces: Long = 0,

    @Column( name = "used_spaces" )
    val usedSpaces: Long = 0,
)