package weekend.examples;

import weekend.Notebook;

import javax.persistence.*;
import java.util.Date;

public class Flush {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("h2");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Notebook> query = entityManager.createNamedQuery("Notebook.findAll", Notebook.class);
        query.getResultList().stream().forEach(rs -> rs.setWarrantyDate(new Date()));

        //TODO flush

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
