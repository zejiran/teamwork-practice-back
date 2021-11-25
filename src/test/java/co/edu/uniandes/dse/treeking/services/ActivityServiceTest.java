package co.edu.uniandes.dse.treeking.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
import co.edu.uniandes.dse.treeking.entities.OutingEntity;
import co.edu.uniandes.dse.treeking.exceptions.IllegalOperationException;
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
	
	@Test
	void testGetActivity() {
		ActivityEntity activityEntity = activityList.get(0);
		ActivityEntity entity = activityService.getActivity(activityEntity.getId());
		assertNotNull(entity);
		assertEquals(entity.getId(), activityEntity.getId());
		assertEquals(entity.getDescription(), activityEntity.getDescription());
		assertEquals(entity.getMinutes(), activityEntity.getMinutes());
	}
	
	@Test
	void testCreateActivity() throws IllegalOperationException   {
		ActivityEntity newEntity = factory.manufacturePojo(ActivityEntity.class);
		ActivityEntity result = activityService.createActivity(newEntity);
		assertNotNull(result);

		ActivityEntity entity = entityManager.find(ActivityEntity.class, result.getId());

		assertEquals(newEntity.getId(), entity.getId());
		assertEquals(newEntity.getName(), entity.getName());
		assertEquals(newEntity.getDescription(), entity.getDescription());

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
