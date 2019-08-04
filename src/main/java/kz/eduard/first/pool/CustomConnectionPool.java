package kz.eduard.first.pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public enum CustomConnectionPool {
  INSTANCE;

  private static final Logger LOGGER = LogManager.getLogger(CustomConnectionPool.class);
  private BlockingQueue<ProxyConnection> freeConnections;
  private Queue<ProxyConnection> givenAwayConnections;

  private static final int DEFAULT_POOL_SIZE = 32;

  CustomConnectionPool() {
    // register driver
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.getException();
    }
    DriverManager.getDrivers();
    // init pool params
    freeConnections = new LinkedBlockingQueue<>(DEFAULT_POOL_SIZE);
    givenAwayConnections = new ArrayDeque<>();
    // init connections
    try {
      DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "pass");
    } catch (SQLException e) {
      //LOGGER.error(e);
    }
  }

  public Connection getConnections() {
    Connection connection = null;
    try {
      connection = freeConnections.take();
      givenAwayConnections.add((ProxyConnection) connection);
    } catch (InterruptedException e) {
      LOGGER.error(e);
    }
    return connection;
  }

  public void releaseConnection(Connection connection) throws NotCorrectConnection {
    if (connection.getClass() == ProxyConnection.class) {
      givenAwayConnections.remove(connection);
      freeConnections.add((ProxyConnection) connection);
    } else {
      throw new NotCorrectConnection();
    }
  }

  public void destroyPool() {
    for (int i = 0; i < DEFAULT_POOL_SIZE; i++) {
      try {
        freeConnections.take().close();
      } catch (SQLException e) {
        LOGGER.error(e);
      } catch (InterruptedException e) {
        LOGGER.error(e);
      }
    }
    deregisterDrivers();
  }

  private void deregisterDrivers() {
    while(DriverManager.getDrivers().hasMoreElements()) {
      Driver driver = DriverManager.getDrivers().nextElement();
      try {
        DriverManager.deregisterDriver(driver);
      } catch (SQLException e) {
        LOGGER.error(e);
      }
    }
  }
}