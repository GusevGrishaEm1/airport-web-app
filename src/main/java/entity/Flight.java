package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="from_airport_name", nullable = false)
    private String fromAirportName;

    @Column(name="to_airport_name", nullable = false)
    private String toAirportName;

    @Column(name="arrival_time", nullable = false)
    private Timestamp arrivalTime;

    @Column(name="departure_time", nullable = false)
    private Timestamp departureTime;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Person_Flight",
            joinColumns = { @JoinColumn(name = "flight_id") },
            inverseJoinColumns = { @JoinColumn(name = "person_id") }
    )
    private Set<Person> persons = new HashSet<>();

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Airplane_Flight",
            joinColumns = { @JoinColumn(name = "flight_id") },
            inverseJoinColumns = { @JoinColumn(name = "airplane_id") }
    )
    private Set<Airplane> airplanes = new HashSet<>();

}
