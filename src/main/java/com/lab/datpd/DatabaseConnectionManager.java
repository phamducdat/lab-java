package com.lab.datpd;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DatabaseConnectionManager {
  private static DatabaseConnectionManager instance;
  private Connection connection;

  private DatabaseConnectionManager() {
    try {
      String url = "jdbc:mysql://localhost:3306/mydatabase";
      String username = "username";
      String password = "password";
      this.connection = DriverManager.getConnection(url, username, password);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public static synchronized DatabaseConnectionManager getInstance() {
    if (instance == null) {
      instance = new DatabaseConnectionManager();
    }
    return instance;
  }

  public Connection getConnection() {
    return connection;
  }
}
