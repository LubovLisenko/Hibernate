package org.example;

import entity.Client;
import entity.Planet;
import entity.Ticket;
import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.CurrentTimestamp;

import java.security.Timestamp;
import java.util.Date;
import java.util.List;

public class TicketCrudService {
    private final SessionFactory sessionFactory = HibernateUtil.getINSTANCE().getSessionFactory();


    public void create(Ticket ticket) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(ticket);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    public Ticket getById(long id) {
        Session session = sessionFactory.openSession();
        Ticket ticket = session.get(Ticket.class, id);
        System.out.println("ticket = " + ticket);
        session.close();
        return ticket;
    }


    public void update(Ticket ticket) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Ticket existing = session.get(Ticket.class, ticket.getId());
        try {
            session.persist(existing);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    public Ticket deleteById(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Ticket ticket = session.get(Ticket.class, id);
        try {
            session.remove(ticket);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return null;
    }


    public List<Ticket> listAll() {
        Session session = sessionFactory.openSession();
        List<Ticket> tickets = session.createQuery("from Ticket", Ticket.class).list();
        System.out.println("tickets = " + tickets);
        session.close();
        return tickets;
    }

}
