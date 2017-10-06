package weekend.cinema;

import org.junit.Test;
import weekend.cinema.dao.JpqlRoomDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;

public class RoomDaoTest {

    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgres-test");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    
    @Test
    public void shouldFindRoomByDescriptionTest(){
       // given
        String description = "medium";

        // when
        JpqlRoomDao jpqlRoomDao = new JpqlRoomDao(entityManager);
        Optional<Room> roomByDescription = jpqlRoomDao.findRoomByDescription(description);

        // then
        assertThat(roomByDescription.isPresent(), is(true));
        assertThat(roomByDescription.get().getDescription(), equalToIgnoringCase(description));
       
    }

}
