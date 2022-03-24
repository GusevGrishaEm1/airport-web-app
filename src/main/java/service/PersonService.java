package service;

import entity.Person;
import repository.PersonRepository;
import java.util.List;

public class PersonService {

    private final PersonRepository personRepository;

    public PersonService() {
        this.personRepository = new PersonRepository();
    }

    public Person create(Person person) {
        return personRepository.create(person);
    }

    public Person update(Person person) {
        return personRepository.update(person);
    }

    public Integer delete(Integer id) {
        return personRepository.delete(id);
    }

    public List<Person> getAll() {
        return personRepository.getAll();
    }

    public Person getById(Integer id) {
        return personRepository.getById(id);
    }

}
