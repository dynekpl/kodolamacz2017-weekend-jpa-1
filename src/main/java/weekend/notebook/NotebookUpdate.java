package weekend.notebook;

import weekend.Notebook;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

public class NotebookUpdate {

    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("h2");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {
        TypedQuery<Notebook> query = entityManager.createNamedQuery("Notebook.findAll", Notebook.class);

        System.out.println(query.getResultList());

        query = entityManager.createNamedQuery("Notebook.findById", Notebook.class);
        query.setParameter("ID", 1);

        Notebook res = query.getSingleResult();
        System.out.println("!!! " + res);

        updateDateForEntity(res);

        entityManager.close();
        entityManagerFactory.close();
    }

    private static void updateDateForEntity(Notebook res) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Calendar calendar = Calendar.getInstance();
        calendar.set(2017,9,01,13,00);
        Date date = calendar.getTime();
        res.setWarrantyDate(date);
        transaction.commit();
    }

    private static void updateDateForToday(Notebook res) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        res.setWarrantyDate(new Date());
        transaction.commit();
    }
}
