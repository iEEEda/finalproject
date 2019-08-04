package kz.eduard.first.entity;

public class User extends Entity {
  private Long id;
  private String login;
  private String email;

  public User(Long id, String login, String email) {
    this.id = id;
    this.login = login;
    this.email = email;
  }

  public User() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", login='" + login + '\'' +
        ", email='" + email + '\'' +
        '}';
  }
}
