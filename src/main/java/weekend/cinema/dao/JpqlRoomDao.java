package weekend.cinema.dao;

import weekend.cinema.Movie;
import weekend.cinema.Room;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpqlRoomDao extends JpqlAbstractDao<Room> implements RoomDao {

    public JpqlRoomDao(EntityManager entityManager) {
        super(entityManager, Room.class);
    }

    @Override
    public Optional<Room> findRoomByDescription(String description) {
        List<Room> results = entityManager.createQuery(
                "select r from Room r where r.description = :description", Room.class)
                .setParameter("description", description)
                .getResultList();

        return results.stream().findFirst();
    }
}
