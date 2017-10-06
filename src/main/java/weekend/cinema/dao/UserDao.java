package weekend.cinema.dao;

import weekend.cinema.User;

import java.util.Optional;

public interface UserDao extends AbstractDao<User> {

    Optional<User> findByLogin(String login);
}
