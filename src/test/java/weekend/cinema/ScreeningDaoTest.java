package weekend.cinema;

import org.junit.BeforeClass;
import weekend.cinema.dao.JpqlMovieDao;
import weekend.cinema.dao.JpqlScreeningDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

public class ScreeningDaoTest {

    public static final String TITLE = "Botoks";

    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgres-test");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();

    static JpqlScreeningDao screeningDao = new JpqlScreeningDao(entityManager);
    static Movie movie = new Movie(TITLE, Genre.THRILLER, "2:15", 2017);

    @BeforeClass
    public static void init() {

    }

}
