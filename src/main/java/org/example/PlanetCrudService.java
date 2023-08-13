package org.example;

import entity.Client;
import entity.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class PlanetCrudService {
    private  final SessionFactory sessionFactory  = HibernateUtil.getINSTANCE().getSessionFactory(); ;

    public  void create(String id, String name){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Planet newPlanet = new Planet();
        newPlanet.setId(id);
        newPlanet.setName(name);
        session.persist(newPlanet);
        System.out.println("newPlanet = " + newPlanet);
        transaction.commit();
        session.close();
    }

    public  void update(String id, String name){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Planet existing = session.get(Planet.class, id);
        existing.setName(name);
        session.persist(existing);
        transaction.commit();
        session.close();
    }

    public void getById(String id){
        Session session = sessionFactory.openSession();
        Planet planet = session.get(Planet.class, id);
        System.out.println("planet = " + planet);
        session.close();
    }

    public void deleteById(String id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Planet planet = session.get(Planet.class, id);
        session.remove(planet);
        transaction.commit();
        session.close();
    }

    public List<Planet> listAll(){
        Session session = sessionFactory.openSession();
        List<Planet> planets = session.createQuery("from Planet", Planet.class).list();
        System.out.println("planets = " + planets);
        session.close();
        return planets;

    }


}
