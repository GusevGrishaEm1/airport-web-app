package repository;

import entity.Flight;
import entity.Person;
import exception.NotFoundException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateSessionFactory;

import java.util.List;

public class FlightRepository {


    public Flight create(Flight flight) {
        Transaction transaction = null;
        try (Session session = HibernateSessionFactory.buildSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(flight);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return flight;
    }

    public Flight update(Flight flight) {
        Transaction transaction = null;
        try (Session session = HibernateSessionFactory.buildSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(flight);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return flight;
    }

    public Integer delete(Integer id) {
        Transaction transaction = null;
        try (Session session = HibernateSessionFactory.buildSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Flight flight = session.get(Flight.class, id);
            session.delete(flight);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return id;
    }

    public List<Flight> getAll() {
        List<Flight> flights = null;
        try (Session session = HibernateSessionFactory.buildSessionFactory().openSession()) {
            flights = session.createQuery("FROM Flight", Flight.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return flights;
    }

    public List<Flight> getByFromAndTo(String from, String to) {
        List<Flight> flights = null;
        try (Session session = HibernateSessionFactory.buildSessionFactory().openSession()) {
            Query<Flight> query = session.createQuery("FROM Flight WHERE fromAirportName like :from AND toAirportName like :to", Flight.class);
            query.setParameter("from", from+"%");
            query.setParameter("to", to+"%");
            flights = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return flights;
    }

    public List<Flight> getByPersonId() {
        List<Flight> flights = null;
        try (Session session = HibernateSessionFactory.buildSessionFactory().openSession()) {
            flights = session.createQuery("FROM Flight INNER JOIN PERSON_FLIGHT ON Flight.id = ", Flight.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return flights;
    }

    public Flight getById(Integer id) {
        Flight flight = null;
        try (Session session = HibernateSessionFactory.buildSessionFactory().openSession()) {
            flight = session.get(Flight.class, id);
            if (flight == null) throw new NotFoundException("Flight not found");
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return flight;
    }

}
