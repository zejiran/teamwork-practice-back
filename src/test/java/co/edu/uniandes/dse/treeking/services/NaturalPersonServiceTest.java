package co.edu.uniandes.dse.treeking.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.exceptions.IllegalOperationException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.edu.uniandes.dse.treeking.entities.NaturalPersonEntity;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * Logic test of NaturalPerson
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(NaturalPersonService.class)
class NaturalPersonServiceTest {

	@Autowired
	private NaturalPersonService naturalPersonService;

	@Autowired
	private TestEntityManager entityManager;

	private PodamFactory factory = new PodamFactoryImpl();

	private List<NaturalPersonEntity> naturalPersonList = new ArrayList<>();

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
		entityManager.getEntityManager().createQuery("delete from NaturalPersonEntity").executeUpdate();
	}

	/**
	 * Insert initial data to the tables.
	 */
	private void insertData() {
		for (int i = 0; i < 3; i++) {
			NaturalPersonEntity naturalPersonEntity = factory.manufacturePojo(NaturalPersonEntity.class);
			entityManager.persist(naturalPersonEntity);
			naturalPersonList.add(naturalPersonEntity);
		}
	}

	/**
	 * Test for getting NaturalPerson list.
	 */
	@Test
	void testGetNaturalPersons() {
		List<NaturalPersonEntity> list = naturalPersonService.getNaturalPersons();
		assertEquals(list.size(), naturalPersonList.size());
	}

	/**
	 * Test for getting NaturalPerson.
	 */
	@Test
	void testGetNaturalPerson() throws EntityNotFoundException {
		NaturalPersonEntity naturalPersonEntity = naturalPersonList.get(0);
		NaturalPersonEntity naturalPerson = naturalPersonService.getNaturalPerson(naturalPersonEntity.getId());
		assertEquals(naturalPerson.getId(), naturalPersonEntity.getId());
		assertEquals(naturalPerson.getPerson(), naturalPersonEntity.getPerson());
		assertNotNull(naturalPerson);
	}

	/**
	 * Test for creating a new NaturalPerson.
	 */
	@Test
	void testAddNaturalPerson() throws EntityNotFoundException, IllegalOperationException {
		NaturalPersonEntity newEntity = factory.manufacturePojo(NaturalPersonEntity.class);
		NaturalPersonEntity result = naturalPersonService.createNaturalPerson(newEntity);
		assertNotNull(result);

		NaturalPersonEntity entity = entityManager.find(NaturalPersonEntity.class, result.getId());

		assertEquals(newEntity.getId(), entity.getId());
		assertEquals(newEntity.getPerson(), entity.getPerson());
		assertNotNull(newEntity);
	}
}
