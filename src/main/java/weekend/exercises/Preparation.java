package weekend.exercises;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Preparation {

    public static EntityManager entityManager;

    public static final String PASSWORD = "tajne";

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgres");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Town town = prepareAndAddTown("Warszawa", 200);
        prepareAndAddUser("Marcin", PASSWORD, town);
        prepareAndAddUser("Kamil", PASSWORD, town);

        town = prepareAndAddTown("Wroclaw", 300);
        prepareAndAddUser("Mariusz", PASSWORD, town);
        prepareAndAddUser("Tomek", PASSWORD, town);

        town = prepareAndAddTown("Gdansk", 400);
        prepareAndAddUser("Radek", PASSWORD, town);

        town = prepareAndAddTown("Krakow", 500);

        town = prepareAndAddTown("Opole", 600);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    private static void addUser(User user) {
        entityManager.persist(user);
    }

    private static void prepareAndAddUser(String login, String password, Town town) {
        User user = new User(login, password, town);
        entityManager.persist(user);
    }

    private static void addTown(Town town) {
        entityManager.persist(town);
    }

    private static Town prepareAndAddTown(String name, int inhabitants) {
        Town town = new Town(name, inhabitants);
        addTown(town);
        return town;
    }
}
