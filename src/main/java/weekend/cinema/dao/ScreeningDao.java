package weekend.cinema.dao;

import weekend.cinema.Room;
import weekend.cinema.Screening;

import java.util.List;
import java.util.Optional;

public interface ScreeningDao extends AbstractDao<Screening> {

    List<Screening> findScreeningByMovieTitle(String title);

    List<Screening> findScreeningByRoom(Room room);
}
