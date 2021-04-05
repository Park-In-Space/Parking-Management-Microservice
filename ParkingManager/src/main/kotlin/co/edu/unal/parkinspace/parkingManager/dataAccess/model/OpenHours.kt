package co.edu.unal.parkinspace.parkingManager.dataAccess.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.format.annotation.DateTimeFormat
import java.sql.Time
import java.util.*
import javax.persistence.*

@Entity( name = "open_hours" )
data class OpenHours (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name="id_open_hours")
    val id: Long = 0,

    @Temporal(TemporalType.TIME)
    @DateTimeFormat(style = "HH:mm")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm")
    @Column( name = "opening" , nullable = false )
    var opening: Date = Time(0,0,1),

    @Temporal(TemporalType.TIME)
    @DateTimeFormat(style = "HH:mm")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm")
    @Column( name = "closing" , nullable = false )
    var closing: Date = Time(23,59,59),

)