package weekend.exercises;

import weekend.Notebook;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Queries {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgres");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TownDao townDao = new TownDao(entityManager);
        List<Town> towns = townDao.getTownsWithInhabitantsCountBetween(300, 600);
        towns.forEach(town -> System.out.println(town + "; "));

        UserDao userDao = new UserDao(entityManager);
        String city = "Warszawa";
        List<User> users = userDao.getUsersFromTown(city);
        users.forEach(user -> System.out.println("User from " + city + ": " + user.getLogin()));

        entityManager.close();
        entityManagerFactory.close();
    }

}
