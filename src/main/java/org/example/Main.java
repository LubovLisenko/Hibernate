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
        new ClientCrudService().update(3, "ModifiedClientName");
        new ClientCrudService().getById(2);
        new ClientCrudService().deleteById(9);
        new ClientCrudService().listAll();

        Planet planet = new Planet();
        planet.setId("N6");
        planet.setName("newPlanet");

         new PlanetCrudService().create(planet);
         new PlanetCrudService().getById("N2");
         new PlanetCrudService().deleteById("N3");
        new PlanetCrudService().update("N5", "newModifiedPlanet");
        new PlanetCrudService().listAll();

    }
}