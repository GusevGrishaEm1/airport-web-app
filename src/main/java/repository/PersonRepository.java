package repository;

import entity.Person;
import exception.NotFoundException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateSessionFactory;

import java.util.List;

public class PersonRepository {

    public Person create(Person person) {
        Transaction transaction = null;
        try (Session session = HibernateSessionFactory.buildSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(person);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return person;
    }

    public Person update(Person person) {
        Transaction transaction = null;
        try (Session session = HibernateSessionFactory.buildSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(person);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return person;
    }

    public Integer delete(Integer id) {
        Transaction transaction = null;
        try (Session session = HibernateSessionFactory.buildSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Person person = session.get(Person.class, id);
            session.delete(person);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return id;
    }

    public List<Person> getAll() {
        List<Person> persons = null;
        try (Session session = HibernateSessionFactory.buildSessionFactory().openSession()) {
            persons = session.createQuery("FROM Person", Person.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return persons;
    }

    public List<Person> getByFullName(String fullName) {
        List<Person> persons = null;
        try (Session session = HibernateSessionFactory.buildSessionFactory().openSession()) {
            Query<Person> query = session.createQuery("FROM Person WHERE fullName like :fullName", Person.class);
            query.setParameter("fullName", "%" + fullName + "%");
            persons = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return persons;
    }

    public List<Person> getByFlightId(Integer flightId) {
        List<Person> persons = null;
        try (Session session = HibernateSessionFactory.buildSessionFactory().openSession()) {
            Query<Person> query = session.createQuery("FROM Person WHERE id IN  (SELECT person.id FROM PersonFlight WHERE flight.id = :flightId)", Person.class);
            query.setParameter("flightId", flightId);
            persons = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return persons;
    }

    public Person getById(Integer id) {
        Person person = null;
        try (Session session = HibernateSessionFactory.buildSessionFactory().openSession()) {
            person = session.get(Person.class, id);
            if (person == null) throw new NotFoundException("Person not found");
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return person;
    }
}
