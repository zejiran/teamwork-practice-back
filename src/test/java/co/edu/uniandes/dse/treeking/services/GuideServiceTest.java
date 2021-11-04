package co.edu.uniandes.dse.treeking.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.edu.uniandes.dse.treeking.entities.GuideEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(GuideService.class)

class GuideServiceTest {

	@Autowired
	private GuideService guideService;

	@Autowired
	private TestEntityManager entityManager;

	private PodamFactory factory = new PodamFactoryImpl();

	private List<GuideEntity> guideList = new ArrayList<>();

	@BeforeEach
	void setUp() throws Exception {
		clearData();
		insertData();

	}

	@Test
	void testGetGuides() {
		List<GuideEntity> list = guideService.getGuides();
		assertEquals(list.size(), guideList.size());
	}

	@Test
	void testGetGuide() throws EntityNotFoundException {
		GuideEntity guideEntity = guideList.get(0);
		GuideEntity entity = guideService.getGuide(guideEntity.getId());
		assertNotNull(entity);
		assertEquals(guideEntity.getId(),entity.getId());
		assertEquals(guideEntity.getAge(), entity.getAge());
		assertEquals(guideEntity.getRating(), entity.getRating());
	}
	private void clearData() {
		entityManager.getEntityManager().createQuery("delete from GuideEntity").executeUpdate();
	}

	private void insertData() {
		for (int i = 0; i < 3; i++) {
			GuideEntity guideEntity = factory.manufacturePojo(GuideEntity.class);
			entityManager.persist(guideEntity);
			guideList.add(guideEntity);
		}
	}
}
