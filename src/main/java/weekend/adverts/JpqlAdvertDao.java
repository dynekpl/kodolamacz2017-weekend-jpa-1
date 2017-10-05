package weekend.adverts;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class JpqlAdvertDao extends JpqlAbstractDao<Advert> implements AdvertDao {

    protected JpqlAdvertDao(EntityManager entityManager) {
        super(entityManager, Advert.class);
    }

    @Override
    public long count() {
        return entityManager.createQuery("select count(a.id) from Advert a", Long.class)
                .getSingleResult();
    }

    @Override
    public List<Advert> findByCategory(Category category) {
        return entityManager.createQuery(
                "select a from Advert a where a.category = :category", Advert.class)
                .setParameter("category", category)
                .getResultList();
    }

    @Override
    public List<Advert> findByPrice(int low, int high) {
        return entityManager.createQuery(
                "select a from Advert a where a.price >= ?1 and a.price <= ?2", Advert.class)
                .setParameter(1, low)
                .setParameter(2, high)
                .getResultList();
//        return Collections.emptyList();
    }

    @Override
    public List<Advert> findByPriceAndCategory(int low, int high, Category category) {
        List<Advert> results = entityManager.createQuery("select a from Advert a where a.price between :low and :high and category = :category", Advert.class)
                .setParameter("low", low)
                .setParameter("high", high)
                .setParameter("category", category)
                .getResultList();
        return results != null ? results : Collections.emptyList();
    }

    @Override
    public List<Advert> findByUser(User user) {
//        return entityManager.createQuery(
//                "select a from Advert a " +
//                        "where a.owner >= :user", Advert.class)
//                .setParameter("user", user)
//                .getResultList();
        return findByUserLogin(user.getLogin());
    }


    @Override
    public List<Advert> findByUserLogin(String login) {
        return entityManager.createQuery(
                "select a from Advert a " +
                        "where a.owner.login = :login ", Advert.class)
                .setParameter("login", login)
                .getResultList();
    }

    @Override
    public List<Advert> findByTitleContains(String text) {
        return entityManager.createQuery(
                "select a from Advert a " +
                        "where a.title like :text ", Advert.class)
                .setParameter("text", "%" + text + "%")
                .getResultList();
    }

    public List<Advert> findByTitleContains(String text, int pageNr, int sizePerPage) {
        List<Advert> results = new ArrayList<>();

        int startingIdx = sizePerPage * pageNr;
        List<Advert> adverts = findByTitleContains(text);
        List<Advert> advertsSubList = adverts.subList(startingIdx, adverts.size());

        if(advertsSubList.size() <= sizePerPage){
            results = advertsSubList;
        }
        else{
            results = advertsSubList.subList(0,sizePerPage - 1);
        }
        return results;
    }
}
