package co.edu.uniandes.dse.treeking.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.entities.ActivityEntity;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(ActivityService.class)
class ActivityServiceTest {

	@Autowired
    private ActivityService activityService;

    @Autowired
    private TestEntityManager entityManager;

    private PodamFactory factory = new PodamFactoryImpl();

    private List<ActivityEntity> activityList = new ArrayList<>();
	
	@BeforeEach
	void setUp() throws Exception {
		clearData();
        insertData();
	}

	@Test
	void testGetActivities() {
		List<ActivityEntity> list = activityService.getActivities();
        assertEquals(list.size(), activityList.size());
	}
	
	private void clearData() {
        entityManager.getEntityManager().createQuery("delete from ActivityEntity").executeUpdate();
	}
	
	private void insertData() {
        for (int i = 0; i < 3; i++) {
                ActivityEntity activityEntity = factory.manufacturePojo(ActivityEntity.class);
                entityManager.persist(activityEntity);
                activityList.add(activityEntity);
        }
	}
}
