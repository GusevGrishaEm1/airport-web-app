package entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "from_airport_name", nullable = false)
    private String fromAirportName;

    @Column(name = "to_airport_name", nullable = false)
    private String toAirportName;

    @Column(name = "arrival_time", nullable = false)
    private LocalDateTime arrivalTime;

    @Column(name = "departure_time", nullable = false)
    private LocalDateTime departureTime;

    @ManyToOne
    @JoinColumn(name = "airplane_id", nullable = false)
    private Airplane airplane;

    @OneToMany(mappedBy = "flight", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private List<PersonFlight> personFlightList = new ArrayList<>();

    public Flight() {
    }

    public Flight(String fromAirportName, String toAirportName, LocalDateTime arrivalTime, LocalDateTime departureTime, Airplane airplane) {
        this.fromAirportName = fromAirportName;
        this.toAirportName = toAirportName;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.airplane = airplane;
    }

    public Flight(Integer id, String fromAirportName, String toAirportName, LocalDateTime arrivalTime, LocalDateTime departureTime, Airplane airplane) {
        this.id = id;
        this.fromAirportName = fromAirportName;
        this.toAirportName = toAirportName;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.airplane = airplane;
    }

    public Integer getId() {
        return id;
    }

    public String getFromAirportName() {
        return fromAirportName;
    }

    public String getToAirportName() {
        return toAirportName;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public Airplane getAirplane() {
        return airplane;
    }
}
