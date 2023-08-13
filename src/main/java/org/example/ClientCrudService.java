package org.example;

import entity.Client;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ClientCrudService {
    private  final SessionFactory sessionFactory  = HibernateUtil.getINSTANCE().getSessionFactory(); ;

    public  void create(String name){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Client newClient = new Client();
        newClient.setName(name);
        session.persist(newClient);
        System.out.println("newClient = " + newClient);
        transaction.commit();
        session.close();
    }

    public  void update(long id, String name){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
         Client existing = session.get(Client.class, id);
         existing.setName(name);
         session.persist(existing);
        transaction.commit();
        session.close();
    }

    public Client getById(long id){
        Session session = sessionFactory.openSession();
       Client client = session.get(Client.class, id);
        System.out.println("client = " + client);
        session.close();
        return client;
    }

    public void deleteById(long id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Client client = session.get(Client.class, id);
         session.remove(client);
        transaction.commit();
        session.close();
    }

    public List<Client> listAll(){
        Session session = sessionFactory.openSession();
        List<Client>  clients = session.createQuery("from Client", Client.class).list();
        System.out.println("clients = " + clients);
        session.close();
         return clients;

    }



}
