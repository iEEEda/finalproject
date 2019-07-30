package kz.eduard.first.service;

public class UserService {
  public boolean checkLogin(String login, String password) {
    //TODO: connect to db
    return login.equals(password);
  }
}
