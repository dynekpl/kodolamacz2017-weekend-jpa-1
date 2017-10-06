package weekend.cinema.dao;

import weekend.cinema.Movie;
import weekend.cinema.User;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpqlMovieDao extends JpqlAbstractDao<Movie> implements MovieDao{

    public JpqlMovieDao(EntityManager entityManager) {
        super(entityManager, Movie.class);
    }

    @Override
    public Optional<Movie> findMovieByTitle(String title) {
        List<Movie> results = entityManager.createQuery(
                "select m from Movie m where m.title = :title", Movie.class)
                .setParameter("title", title)
                .getResultList();

        return results.stream().findFirst();
    }
}
