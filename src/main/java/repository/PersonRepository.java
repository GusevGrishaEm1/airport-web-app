package repository;

import entity.Person;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactory;
import java.util.List;

public class PersonRepository {

    public Person create(Person person) {
        Transaction transaction = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
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
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
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
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
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
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            persons = session.createQuery("FROM Person", Person.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return persons;
    }

    public Person getById(Integer id) {
        Person person = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            person = session.get(Person.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return person;
    }
}
