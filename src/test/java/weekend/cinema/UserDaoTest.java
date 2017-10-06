package weekend.cinema;

import org.junit.BeforeClass;
import org.junit.Test;
import weekend.cinema.dao.JpqlUserDao;
import weekend.cinema.User;
import weekend.cinema.dao.UserDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class UserDaoTest {

    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgres-test");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();

    static UserDao userDao = new JpqlUserDao(entityManager);
    static User user = new User("dyneck", "pass");

    @BeforeClass
    public static void init() {
        Optional<User> userByLogin = userDao.findByLogin(user.getLogin());
        if (!userByLogin.isPresent()) {
            userDao.save(user);
        }
    }

    @Test
    public void shouldFindByLoginTest() {
        // given

        // when
        Optional<User> byLogin = userDao.findByLogin(user.getLogin());

        // then
        assertThat(byLogin.isPresent(), is(true));
    }

    @Test
    public void shouldNotFindByLoginTest() {
        // given

        // when

        // then

    }
}
