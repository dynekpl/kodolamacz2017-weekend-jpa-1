package weekend.cinema;

import org.junit.BeforeClass;
import org.junit.Test;
import weekend.cinema.dao.JpqlMovieDao;
import weekend.cinema.dao.MovieDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;

public class MovieDaoTest {

    public static final String TITLE = "Botoks";

    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgres-test");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();

    static JpqlMovieDao movieDao = new JpqlMovieDao(entityManager);
    static Movie movie = new Movie(TITLE, Genre.THRILLER, "2:15", 2017);


    @BeforeClass
    public static void init() {
        Optional<Movie> movieByTitle = movieDao.findMovieByTitle(TITLE);
        if(!movieByTitle.isPresent()){
            movieDao.save(movie);
        }
    }

    @Test
    public void shouldFindMovieByTitleTest() {
        // given

        // when
        Optional<Movie> movieByTitle = movieDao.findMovieByTitle(TITLE);

        // then
        assertThat(movieByTitle.isPresent(), is(true));
        assertThat(movieByTitle.get().getTitle(), equalToIgnoringCase(TITLE));
    }

}
