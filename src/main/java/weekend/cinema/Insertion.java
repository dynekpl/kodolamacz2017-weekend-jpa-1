package weekend.cinema;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Insertion {

    public static EntityManager entityManager;

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgres");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(new Room(25, 50, "big"));
        entityManager.persist(new Room(15, 30, "medium"));
        entityManager.persist(new Room(10, 10, "small"));

        Movie movie = new Movie("Botoks", Genre.THRILLER, "2:15", 2017);
        entityManager.persist(movie);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
