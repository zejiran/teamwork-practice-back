package co.edu.uniandes.dse.treeking.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
