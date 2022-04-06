package repository;

import entity.Flight;
import entity.Person;
import entity.PersonFlight;
import exception.NotFoundException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateSessionFactory;
import java.util.List;

public class PersonFlightRepository {

    public PersonFlight create(PersonFlight personFlight) {
        Transaction transaction = null;
        try (Session session = HibernateSessionFactory.buildSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(personFlight);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return personFlight;
    }

    public PersonFlight update(PersonFlight personFlight) {
        Transaction transaction = null;
        try (Session session = HibernateSessionFactory.buildSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(personFlight);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return personFlight;
    }

    public void delete(Person person, Flight flight) {
        Transaction transaction = null;
        try (Session session = HibernateSessionFactory.buildSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            PersonFlight personFlight = session.get(PersonFlight.class, new PersonFlight(person, flight));
            session.delete(personFlight);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<PersonFlight> getAll() {
        List<PersonFlight> personFlightList = null;
        try (Session session = HibernateSessionFactory.buildSessionFactory().openSession()) {
            personFlightList = session.createQuery("FROM PersonFlight", PersonFlight.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return personFlightList;
    }

    public List<PersonFlight> getByPersonId(Integer personId) {
        List<PersonFlight> personFlightList = null;
        try (Session session = HibernateSessionFactory.buildSessionFactory().openSession()) {
            Query<PersonFlight> query = session.createQuery("FROM PersonFlight WHERE person.id = :personId", PersonFlight.class);
            query.setParameter("personId",personId);
            personFlightList = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return personFlightList;
    }

    public PersonFlight getById(Integer id) {
        PersonFlight personFlight = null;
        try (Session session = HibernateSessionFactory.buildSessionFactory().openSession()) {
            personFlight = session.get(PersonFlight.class, id);
            if (personFlight == null) throw new NotFoundException("PersonFlight not found");
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return personFlight;
    }
}
