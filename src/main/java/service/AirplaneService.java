package service;

import entity.Airplane;
import repository.AirplaneRepository;
import java.util.List;

public class AirplaneService {

    private final AirplaneRepository airplaneRepository;

    public AirplaneService() {
        this.airplaneRepository = new AirplaneRepository();
    }

    public Airplane create(Airplane airplane) {
        return airplaneRepository.create(airplane);
    }

    public Airplane update(Airplane airplane) {
        return airplaneRepository.update(airplane);
    }

    public Integer delete(Integer id) {
        return airplaneRepository.delete(id);
    }

    public List<Airplane> getAll() {
        return airplaneRepository.getAll();
    }

    public Airplane getById(Integer id) {
        return airplaneRepository.getById(id);
    }
}
