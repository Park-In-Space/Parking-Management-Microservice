package co.edu.unal.parkinspace.parkingManager.dataAccess.model

import javax.persistence.*

@Entity( name = "parking" )
data class Parking (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_parking")
    val id: Long = 0,

    @Column( name = "name" , nullable = false )
    var name: String = "",

    @Column( name = "price_per_minute" , nullable = false )
    var pricePerMinute: Long = 0,

    @Column( name = "total_spaces" , nullable = false )
    var totalSpaces: Long = 0,

    @Column( name = "used_spaces" )
    var usedSpaces: Long = 0,

    @Lob
    @Column(name = "image")
    var image: String? = null,

    @OneToMany( cascade = [CascadeType.ALL] )
    @JoinTable(name = "parking_has_open_hours",
        joinColumns = [JoinColumn(name = "id_parking", referencedColumnName = "id_parking")],
        inverseJoinColumns = [JoinColumn(name = "id_open_hours", referencedColumnName = "id_open_hours", unique=true)])
    var openHours: MutableList<OpenHours?> = ArrayList(),
)