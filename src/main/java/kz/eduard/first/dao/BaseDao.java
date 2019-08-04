package kz.eduard.first.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import kz.eduard.first.entity.Entity;

public interface BaseDao<T extends Entity> {
  static final Logger LOGGER = LogManager.getLogger(BaseDao.class);

  List<T> findAll(); // not good using object parameter
  T findEntityById(Long id);
  boolean delete(T t);
  boolean delete(Long id);
  boolean create(T t);
  T update(T t);

  default void close(Statement statement) {
    try {
      if (statement != null) {
        statement.close();
      }
    } catch (SQLException e) {
      LOGGER.error(e);
    }
  }

  default void close(Connection connection) {
    try {
      if (connection != null) {
        connection.close();
      }
    } catch (SQLException e) {
      LOGGER.error(e);
    }
  }
}
