package weekend.exercises;

import weekend.exercises.Town;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String login;
  private String password;

  @ManyToOne
  private Town town;

  public User(String login, String password, Town town) {
    this.login = login;
    this.password = password;
    this.town = town;
  }

  public User() {
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", login='" + login + '\'' +
        ", password='" + password + '\'' +
        ", town=" + town +
        '}';
  }

  public int getId() {
    return id;
  }

  public String getLogin() {
    return login;
  }

  public String getPassword() {
    return password;
  }

  public Town getTown() {
    return town;
  }
}
