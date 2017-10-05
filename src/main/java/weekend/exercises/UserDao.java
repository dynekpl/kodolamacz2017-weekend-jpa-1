package weekend.exercises;

import weekend.exercises.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDao {
    private final EntityManager entityManager;

    public UserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<User> getUsersFromTown(String town) {
        //noinspection unchecked
        return entityManager.createNativeQuery(
                "select * from users u join towns t on u.town_id = t.id where t.name = :town",
                User.class
        )
                .setParameter("town", town)
                .getResultList();
    }

    public List<User> getUsersFromTownJpql(String town) {
        return entityManager.createQuery("select u from User u where u.town.name = :town", User.class)
                .setParameter("town", town)
                .getResultList();
    }
}
