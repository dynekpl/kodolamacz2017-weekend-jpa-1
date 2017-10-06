package weekend.cinema.dao;

import weekend.cinema.Room;
import weekend.cinema.Screening;

import javax.persistence.EntityManager;
import java.util.List;

import static java.util.Collections.emptyList;

public class JpqlScreeningDao extends JpqlAbstractDao<Screening> implements ScreeningDao{

    public JpqlScreeningDao(EntityManager entityManager) {
        super(entityManager, Screening.class);
    }

    @Override
    public List<Screening> findScreeningByMovieTitle(String title) {
        List<Screening> results = entityManager.createQuery(
                "select s from Screening s where s.movie.title = :title", Screening.class)
                .setParameter("title", title)
                .getResultList();

        return results != null ? results : emptyList();
    }

    @Override
    public List<Screening> findScreeningByRoom(Room room) {
        List<Screening> results = entityManager.createQuery(
                "select s from Screening s where s.room = :room", Screening.class)
                .setParameter("room", room)
                .getResultList();

        return results != null ? results : emptyList();
    }
}
