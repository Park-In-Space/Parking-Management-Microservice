package co.edu.unal.parkinspace.parkingManager.dataAccess.model

import javax.persistence.*

@Entity( name = "parking" )
data class Parking (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_parking")
    val id: Long = 0,

    @Column( name = "name" , nullable = false )
    var name: String = "",

    @Column( name = "total_spaces" , nullable = false )
    var totalSpaces: Long = 0,

    @Column( name = "used_spaces" )
    var usedSpaces: Long = 0,
)