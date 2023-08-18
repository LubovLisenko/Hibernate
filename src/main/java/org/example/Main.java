package org.example;

import entity.Client;
import entity.Planet;
import storage.DataBaseInitService;


import java.sql.SQLException;

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

    }
}