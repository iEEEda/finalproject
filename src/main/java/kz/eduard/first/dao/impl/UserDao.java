package kz.eduard.first.dao.impl;

import java.util.List;
import kz.eduard.first.dao.BaseDao;
import kz.eduard.first.entity.User;

public class UserDao implements BaseDao<User> {
  @Override
  public List<User> findAll() {
    return null;
  }

  @Override
  public User findEntityById(Long id) {
    return null;
  }

  @Override
  public boolean delete(User user) {
    return false;
  }

  @Override
  public boolean delete(Long id) {
    return false;
  }

  @Override
  public boolean create(User user) {
    return false;
  }

  @Override
  public User update(User user) {
    return null;
  }
}
