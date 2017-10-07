package weekend.examples;

import weekend.Notebook;
import weekend.Notebook_;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class SelectionCriteria {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("h2");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        //By ID
        CriteriaQuery<Notebook> query = cb.createQuery(Notebook.class);
        Root<Notebook> from = query.from(Notebook.class);
        query.where(cb.equal(from.get(Notebook_.id), 1));
        List<Notebook> resultList = entityManager.createQuery(query).getResultList();
        System.out.println("#1 " + resultList);

        //By resolution
        query = cb.createQuery(Notebook.class);
        query.where(cb.and(
                cb.greaterThan(from.get(Notebook_.resolution), 1600),
                cb.lessThan(from.get(Notebook_.resolution), 2000))
        );
        resultList = entityManager.createQuery(query).getResultList();
        System.out.println("#2 " + resultList);

        entityManager.close();
        entityManagerFactory.close();
    }
}
