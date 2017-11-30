package weekend.adverts;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AdvertDaoTest {

    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("docker");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();

    static AdvertDao advertDao = new JpqlAdvertDao(entityManager);
    static UserDao userDao = new JpqlUserDao(entityManager);

    static User owner = new User("dyneck","pass");

    static Integer id = null;

    @BeforeClass
    public static void init(){
        Optional<User> ownerByLogin = userDao.findByLogin(owner.getLogin());
        if(!ownerByLogin.isPresent()){
            userDao.save(owner);
        }
        Advert advert = new Advert("Sprzedam Astre","Nówka sztuka",8000, Category.CAR);
        advert.setOwner(ownerByLogin.orElse(owner));
        advertDao.save(advert);

        id = advert.getId();
    }

    @Test
    public void shouldSaveAdvertTest() {
        long before = advertDao.count();
        // given
        Advert advert = new Advert("Sprzedam Opla", "Niemiec płakał...", 5000, Category.CAR);
        advert.setOwner(owner);

        // when
        advertDao.save(advert);

        // then
        long count = advertDao.count();

        assertEquals(before + 1, count);
    }
    
    @Test
    public void shouldFindAdvertByUserTest(){
       // given

        // when
        List<Advert> adverts = advertDao.findByUser(owner);
        // then
        assertThat(adverts, hasSize(greaterThanOrEqualTo(1)));
    }

    @Test
    public void shouldFindAdvertByIdTest() {
        // given
        // when
        Advert advert = advertDao.findById(id);

        // then
        assertTrue(Objects.nonNull(advert));
    }

    @Test
    public void shouldFindByCategoryTest() {
        // given
        int before = advertDao.findByCategory(Category.CAR).size();
        advertDao.save(new Advert("", "", 100, Category.CAR));
        advertDao.save(new Advert("", "", 5, Category.BICYCLE));

        // when
        int count = advertDao.findByCategory(Category.CAR).size();

        // then
        assertEquals(before + 1, count);

    }

    @Test
    public void shouldFindByPriceTest() {
        // given
        Advert car = new Advert("Toyota", "sprzedam", 100, Category.CAR);
        advertDao.save(car);
        advertDao.save(new Advert("Rowerek", "", 200, Category.BICYCLE));

        // when
        List<Advert> adverts = advertDao.findByPrice(50, 150);

        // then
//        boolean containsCar = false;
//        for (Advert advert : adverts) {
//            Assert.assertTrue(advert.getPrice() >= 50);
//            Assert.assertTrue(advert.getPrice() <= 150);
//            if(advert.getId() == car.getId()){
//                System.out.println("Znalazłem");
//                System.out.println(advert);
//                containsCar = true;
//            }
//        }
//        Assert.assertTrue(containsCar);

        // ta metoda z biblioteki hamcrest zastępuje powyższy wykomentowany kod
        for (Advert advert : adverts) {
            assertThat(advert.getPrice(), is(greaterThanOrEqualTo(50)));
            assertThat(advert.getPrice(), is(lessThanOrEqualTo(150)));
        }
        // sprawdza czy dana lista zawiera konkretny obiekt
        assertThat(adverts, hasItem(car));
    }
    
    @Test
    public void shouldFindByTitleTest(){
       // given
        String carName = "Skoda";
        Advert car = new Advert(String.format("%s Octavia",carName), "sprzedam", 100, Category.CAR);
        advertDao.save(car);
       
       // when
        List<Advert> adverts = advertDao.findByTitleContains(carName);

        // then
       assertThat(adverts, hasSize(greaterThan(0)));
       assertThat(adverts, hasItem(car));
    }
}
