package repository;

import entity.Baggage;
import exception.NotFoundException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateSessionFactory;


import java.util.List;

public class BaggageRepository {

    public Baggage create(Baggage baggage) {
        Transaction transaction = null;
        try (Session session = HibernateSessionFactory.buildSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(baggage);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return baggage;
    }

    public Baggage update(Baggage baggage) {
        Transaction transaction = null;
        try (Session session = HibernateSessionFactory.buildSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(baggage);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return baggage;
    }

    public Integer delete(Integer id) {
        Transaction transaction = null;
        try (Session session = HibernateSessionFactory.buildSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Baggage baggage = session.get(Baggage.class, id);
            session.delete(baggage);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return id;
    }

    public List<Baggage> getAll() {
        List<Baggage> baggages = null;
        try (Session session = HibernateSessionFactory.buildSessionFactory().openSession()) {
            baggages = session.createQuery("FROM Baggage", Baggage.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return baggages;
    }

    public List<Baggage> getByPersonId(Integer personId) {
        List<Baggage> baggages = null;
        try (Session session = HibernateSessionFactory.buildSessionFactory().openSession()) {
            Query<Baggage> query =  session.createQuery("FROM Baggage WHERE person.id = :personId", Baggage.class);
            query.setParameter("personId",personId);
            baggages = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return baggages;
    }

    public Baggage getById(Integer id) {
        Baggage baggage = null;
        try (Session session = HibernateSessionFactory.buildSessionFactory().openSession()) {
            baggage = session.get(Baggage.class, id);
            if (baggage == null) throw new NotFoundException("Baggage not found");
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return baggage;
    }
}
