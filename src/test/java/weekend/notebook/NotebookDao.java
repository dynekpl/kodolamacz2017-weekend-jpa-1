package weekend.notebook;

import org.junit.AfterClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class NotebookDao {

    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("h2");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Test
    public void shouldReadParametersTest() {
        TypedQuery<Parameters> query = entityManager.createNamedQuery("Notebook.getParameters", Parameters.class);
        List<Parameters> results = query.getResultList();

        System.out.println(results);
    }

    @AfterClass
    public static void clean() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
