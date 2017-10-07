package weekend.notebook;

import weekend.notebook.Parameters;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class SelectParameters {

    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("h2");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {

        TypedQuery<Parameters> query = entityManager.createNamedQuery("Notebook.getParameters", Parameters.class);
        List<Parameters> results = query.getResultList();

        System.out.println(results);

        entityManager.close();
        entityManagerFactory.close();
    }
}
