package weekend.examples;

import weekend.Notebook;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class NativeQuery {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgres");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        // zapytanie nieparametryzowane
        List notebooks = entityManager.createNativeQuery(
                "select * from notebooks where resolution < 1800",
                Notebook.class
        )
                .getResultList();
        System.out.println("1). " + notebooks);

        // zapytanie parametryzowane
        int resolution = 1700;
        notebooks = entityManager.createNativeQuery(
                "select * from notebooks where resolution < :resolution",
                Notebook.class
        )
                .setParameter("resolution", resolution)
                .getResultList();
        System.out.println("2). " + notebooks);

        entityManager.close();
        entityManagerFactory.close();
    }
}
