package weekend.adverts;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User extends AbstractEntity {

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String password;
    private String mail;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    List<Advert> adverts;

    public User() {
        this("", "", "");
    }

    public User(String login, String password) {
        this(login, password, "na");
    }

    public User(String login, String password, String mail) {
        this.login = login;
        this.password = password;
        this.mail = mail;
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

    public String getPhone() {
        return mail;
    }

    public void setPhone(String mail) {
        this.mail = mail;
    }

    public List<Advert> getAdverts() {
        return adverts;
    }

    public void setAdverts(List<Advert> adverts) {
        this.adverts = adverts;
    }
}
