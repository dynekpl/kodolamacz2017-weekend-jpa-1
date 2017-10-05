package weekend.adverts;

import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpqlUserDao extends JpqlAbstractDao<User> implements UserDao{
    
    private static final Logger LOG = Logger.getLogger(JpqlUserDao.class);

    public JpqlUserDao(EntityManager entityManager) {
        super(entityManager, User.class);
        LOG.info("Stworzono DAO");
    }

    @Override
    public Optional<User> findByLogin(String login) {
        LOG.info("Wyszukuję po loginie...");
        List<User> results = entityManager.createQuery(
                "select u from User u where u.login = :login", User.class)
                .setParameter("login", login)
                .getResultList();

        return results.stream().findFirst();
    }
}
