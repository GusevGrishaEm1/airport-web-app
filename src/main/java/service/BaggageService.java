package service;

import entity.Baggage;
import repository.BaggageRepository;
import java.util.List;

public class BaggageService {
    private final BaggageRepository baggageRepository;

    public BaggageService() {
        this.baggageRepository = new BaggageRepository();
    }

    public Baggage create(Baggage baggage) {
        return baggageRepository.create(baggage);
    }

    public Baggage update(Baggage baggage) {
        return baggageRepository.update(baggage);
    }

    public Integer delete(Integer id) {
        return baggageRepository.delete(id);
    }

    public List<Baggage> getAll() {
        return baggageRepository.getAll();
    }

    public Baggage getById(Integer id) {
        return baggageRepository.getById(id);
    }

    public List<Baggage> getByPersonId(Integer personId) {return baggageRepository.getByPersonId(personId);}
}
