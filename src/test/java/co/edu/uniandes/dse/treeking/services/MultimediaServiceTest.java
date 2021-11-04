package co.edu.uniandes.dse.treeking.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.edu.uniandes.dse.treeking.entities.MultimediaEntity;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * Logic test of Multimedia
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(MultimediaService.class)
class MultimediaServiceTest {

	@Autowired
	private MultimediaService multimediaService;

	@Autowired
	private TestEntityManager entityManager;

	private PodamFactory factory = new PodamFactoryImpl();

	private List<MultimediaEntity> multimediaList = new ArrayList<>();

	/**
	 * Initial configuration of the test.
	 */
	@BeforeEach
	void setUp() {
		clearData();
		insertData();
	}

	/**
	 * Clean tables of test.
	 */
	private void clearData() {
		entityManager.getEntityManager().createQuery("delete from MultimediaEntity").executeUpdate();
	}

	/**
	 * Insert initial data to the tables.
	 */
	private void insertData() {
		for (int i = 0; i < 3; i++) {
			MultimediaEntity multimediaEntity = factory.manufacturePojo(MultimediaEntity.class);
			entityManager.persist(multimediaEntity);
			multimediaList.add(multimediaEntity);
		}
	}

	/**
	 * Test for getting Multimedia list.
	 */
	@Test
	void testGetMultimedias() {
		List<MultimediaEntity> list = multimediaService.getMultimedias();
		assertEquals(list.size(), multimediaList.size());
	}

	/**
	 * Test for getting Multimedia.
	 */
	@Test
	void testGetMultimedia() throws EntityNotFoundException {
		MultimediaEntity multimediaEntity = multimediaList.get(0);
		MultimediaEntity multimedia = multimediaService.getMultimedia(multimediaEntity.getId());
		assertNotNull(multimedia);
		assertEquals(multimedia.getId(), multimediaEntity.getId());
	}
}
