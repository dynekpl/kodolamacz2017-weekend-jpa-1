package weekend.exercises;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Preparetion {

    public static EntityManager entityManager;

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgres");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Town town = new Town("Warszawa", 200);
        addTown(town);
        prepareAndAddUser("Marcin", "tajne", town);


        //prepareAndAddTown("Wroclaw", 300);
        //prepareAndAddTown("Gdansk", 400);
        //prepareAndAddTown("Krakow", 500);
        //prepareAndAddTown("Opole", 600);


        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    private static void addUser(User user) {
        entityManager.persist(user);
    }

    private static void prepareAndAddUser(String login, String password, Town town) {
        new User(login, password, town);
    }

    private static void addTown(Town town) {
        entityManager.persist(town);
    }

    private static void prepareAndAddTown(String name, int inhabitants) {
        Town town = new Town(name, inhabitants);
        addTown(town);
    }
}
