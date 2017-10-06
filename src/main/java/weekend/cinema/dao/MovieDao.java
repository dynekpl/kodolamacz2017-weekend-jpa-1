package weekend.cinema.dao;

import weekend.cinema.Movie;

import java.util.Optional;

public interface MovieDao extends AbstractDao<Movie>{

    Optional<Movie> findMovieByTitle(String title);
}
