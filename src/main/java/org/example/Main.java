package org.example;

import storage.ConnectionProvider;
import storage.DataBaseInitService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        new DataBaseInitService().initDb();
      //  ConnectionProvider connectionProvider = new ConnectionProvider();
      //  connectionProvider.createConnection();
    }
}