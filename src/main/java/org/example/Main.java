package org.example;

import storage.DataBaseInitService;


import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
       new DataBaseInitService().initDb();

        new ClientCrudService().create("newName");
        new ClientCrudService().update(10, "ModifiedClientName");
        new ClientCrudService().getById(2);
        new ClientCrudService().deleteById(9);
        new ClientCrudService().listAll();

        new PlanetCrudService().create("N6","newPlanet");
        new PlanetCrudService().getById("N2");
        new PlanetCrudService().listAll();
        new PlanetCrudService().deleteById("N3");
        new PlanetCrudService().update("N5", "newModifiedPlanet");
        new PlanetCrudService().listAll();

    }
}