package weekend.cinema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "owners")
public class User extends AbstractEntity {

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String password;
    private String mail;

    public User() {
    }

    public User(String login, String password, String mail) {
        this.login = login;
        this.password = password;
        this.mail = mail;
    }

    public User(String login, String password) {
        this(login, password, "na");
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
