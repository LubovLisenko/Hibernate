package org.example;

import entity.Client;
import entity.Planet;
import entity.Ticket;
import storage.DataBaseInitService;


import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws SQLException {
       new DataBaseInitService().initDb();

       Client client = new Client();
       client.setName("newName");
       new ClientCrudService().create(client);

        Client  client1 = new ClientCrudService().listAll().get(3);
        client1.setName("nameModify");
        System.out.println("client1 = " + client1);

        new ClientCrudService().update(client1);
        new ClientCrudService().getById(2);
        new ClientCrudService().deleteById(9);
        new ClientCrudService().listAll();
     System.out.println("_________________________");

        Planet planet = new Planet();
        planet.setId("N6");
        planet.setName("newPlanet");
        new PlanetCrudService().create(planet);

        Planet planet1 = new PlanetCrudService().listAll().get(4);
        planet1.setName("newModifiedPlanet");
        new PlanetCrudService().update(planet1);
         new PlanetCrudService().getById("N2");
         new PlanetCrudService().deleteById("N3");
        new PlanetCrudService().listAll();
     System.out.println("_________________________");


new TicketCrudService().listAll();
     Ticket ticket = new Ticket();
        Date currentDate = new Date();
        Timestamp timestamp = new Timestamp(currentDate.getTime());
        ticket.setCreated_at(String.valueOf(timestamp));
        ticket.setClient(client);
        ticket.setFrom(planet);
        ticket.setTo(planet1);
        System.out.println("Create ticket = " + ticket);
     new TicketCrudService().create(ticket);
        System.out.println("_________________________");


     Ticket ticket1 = new TicketCrudService().getById(1);
        ticket1.setCreated_at(String.valueOf(timestamp));
        ticket1.setClient(client1);
        ticket1.setFrom(new PlanetCrudService().getById("N2"));
        ticket1.setTo(new PlanetCrudService().getById("N1"));
        System.out.println("Update tickets = " + ticket1);
        new TicketCrudService().update(ticket1);
        System.out.println("_________________________");


        System.out.println("new TicketCrudService().getById(4) = " + new TicketCrudService().getById(4));
        System.out.println("_________________________");

        new TicketCrudService().deleteById(6);

        new TicketCrudService().listAll();

    }
}