package service;

import entity.Flight;
import repository.FlightRepository;
import java.util.List;

public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService() {
        this.flightRepository = new FlightRepository();
    }

    public Flight create(Flight flight) {
        return flightRepository.create(flight);
    }

    public Flight update(Flight flight) {
        return flightRepository.update(flight);
    }

    public Integer delete(Integer id) {
        return flightRepository.delete(id);
    }

    public List<Flight> getAll() {
        return flightRepository.getAll();
    }

    public Flight getById(Integer id) {
        return flightRepository.getById(id);
    }
}
