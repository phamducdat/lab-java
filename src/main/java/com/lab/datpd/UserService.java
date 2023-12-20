package com.lab.datpd;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.sql.Connection;

@Service
public class UserService {
  private final Connection connection;

  public UserService() {
    this.connection = DatabaseConnectionManager.getInstance().getConnection();
  }

  public void getUser(int id) {
    // Use the connection to query the database and return a User
  }
}
