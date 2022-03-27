package repository;

import entity.Airplane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateSessionFactory;

import java.util.List;

public class AirplaneRepository {

    public Airplane create(Airplane airplane) {
        Transaction transaction = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(airplane);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return airplane;
    }

    public Airplane update(Airplane airplane) {
        Transaction transaction = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(airplane);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return airplane;
    }

    public Integer delete(Integer id) {
        Transaction transaction = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Airplane airplane = session.get(Airplane.class, id);
            session.delete(airplane);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return id;
    }

    public List<Airplane> getAll() {
        List<Airplane> airplanes = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            airplanes = session.createQuery("FROM Airplane", Airplane.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return airplanes;
    }

    public Airplane getById(Integer id) {
        Airplane airplane = null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            airplane = session.get(Airplane.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return airplane;
    }

}
