package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person_flight")
public class PersonFlight implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @Id
    @ManyToOne
    @JoinColumn(name="flight_id", nullable = false)
    private Flight flight;

    @Column(name="seat_number")
    private Integer seatNumber;

    public PersonFlight(Person person, Flight flight, Integer seatNumber) {
        this.person = person;
        this.flight = flight;
        this.seatNumber = seatNumber;
    }

    public PersonFlight(Person person, Flight flight) {
        this.person = person;
        this.flight = flight;
    }

    public Person getPerson() {
        return person;
    }

    public Flight getFlight() {
        return flight;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public PersonFlight() {
    }
}
