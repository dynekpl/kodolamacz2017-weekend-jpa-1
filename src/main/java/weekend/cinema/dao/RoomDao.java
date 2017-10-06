package weekend.cinema.dao;

import weekend.cinema.Room;

import java.util.Optional;

public interface RoomDao extends AbstractDao<Room> {

    Optional<Room> findRoomByDescription(String description);
}
