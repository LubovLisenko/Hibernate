package org.example;

import entity.Client;
import entity.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class PlanetCrudService {
    private  final SessionFactory sessionFactory  = HibernateUtil.getINSTANCE().getSessionFactory(); ;

    public  void create(Planet planet){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
       try {
           session.persist(planet);
           transaction.commit();
       } catch (Exception ex){
           if (transaction!=null){
               transaction.rollback();
           }
       } finally {
           session.close();
       }
    }

    public  Planet update(String id, String name){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Planet existing = session.get(Planet.class, id);
        try {
            existing.setName(name);
            session.persist(existing);
            transaction.commit();
        } catch (Exception ex){
            if (transaction!=null){
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return existing;
    }

    public Planet getById(String id){
        Session session = sessionFactory.openSession();
        Planet planet = session.get(Planet.class, id);
        System.out.println("planet = " + planet);
        session.close();
        return planet;
    }

    public Planet deleteById(String id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Planet planet = session.get(Planet.class, id);
        try {
            session.remove(planet);
            transaction.commit();
        } catch (Exception ex){
            if (transaction!=null){
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return null;
    }

    public List<Planet> listAll(){
        Session session = sessionFactory.openSession();
        List<Planet> planets = session.createQuery("from Planet", Planet.class).list();
        System.out.println("planets = " + planets);
        session.close();
        return planets;

    }


}
