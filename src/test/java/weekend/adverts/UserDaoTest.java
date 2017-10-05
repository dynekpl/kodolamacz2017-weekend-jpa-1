package weekend.adverts;

import org.hamcrest.Matchers;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserDaoTest {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgres-test");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    UserDao userDao = new JpqlUserDao(entityManager);

    @Test
    public void shouldFindByLoginTest(){
       // given
        User user = new User("dynio", "pass123");
        userDao.save(user);

        // when
        Optional<User> byLogin = userDao.findByLogin(user.getLogin());

        // then
        assertThat(byLogin.isPresent(),is(true));
    }
    
    @Test
    public void shouldNotFindByLoginTest(){
       // given
       
       // when
       
       // then
       
    }
}
