package repository;

import entity.Flight;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactory;
import java.util.List;

public class FlightRepository {

    public Flight create(Flight flight) {
        Transaction transaction = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
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
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
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
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
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
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            flights = session.createQuery("FROM Flight", Flight.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return flights;
    }

    public Flight getById(Integer id) {
        Flight flight = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            flight = session.get(Flight.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return flight;
    }
}
