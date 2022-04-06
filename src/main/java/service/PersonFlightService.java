package service;

import entity.Flight;
import entity.Person;
import entity.PersonFlight;
import repository.PersonFlightRepository;
import java.util.List;

public class PersonFlightService {

    private final PersonFlightRepository personFlightRepository;

    public PersonFlightService() {
        this.personFlightRepository = new PersonFlightRepository();
    }

    public PersonFlight create(PersonFlight personFlight) {
        return personFlightRepository.create(personFlight);
    }

    public PersonFlight update(PersonFlight personFlight) {
        return personFlightRepository.update(personFlight);
    }

    public void delete(Person person, Flight flight) {
         personFlightRepository.delete(person, flight);
    }

    public List<PersonFlight> getAll() {
        return personFlightRepository.getAll();
    }

    public List<PersonFlight> getByPersonId(Integer id) {
        return personFlightRepository.getByPersonId( id);
    }

    public PersonFlight getById(Integer id) {
        return personFlightRepository.getById(id);
    }
}
