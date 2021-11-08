package co.edu.uniandes.dse.treeking.services;

import static org.junit.jupiter.api.Assertions.*;

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

import co.edu.uniandes.dse.treeking.entities.EnterpriseEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(EnterpriseService.class)
class EnterpriseServiceTest {

	@Autowired
	private EnterpriseService enterpriseService;

	@Autowired
	private TestEntityManager entityManager;

	private PodamFactory factory = new PodamFactoryImpl();

	private List<EnterpriseEntity> enterpriseList = new ArrayList<>();

	/**
	 * Limpia las tablas que están implicadas en la prueba.
	 */
	private void clearData() {
		entityManager.getEntityManager().createQuery("delete from EnterpriseEntity").executeUpdate();
	}

	private void insertData() {
		for (int i = 0; i < 3; i++) {
			EnterpriseEntity enterpriseEntity = factory.manufacturePojo(EnterpriseEntity.class);
			entityManager.persist(enterpriseEntity);
			enterpriseList.add(enterpriseEntity);
		}
	}

	@BeforeEach
	void setUp() throws Exception {
		clearData();
		insertData();
	}

	@Test
	void testGetEnterprises() {
		List<EnterpriseEntity> enterprises = enterpriseService.getEnterprises();
		assertEquals(enterpriseList.size(), enterprises.size());

		for (EnterpriseEntity entity : enterprises) {
			boolean found = false;
			for (EnterpriseEntity storedEntity : enterpriseList)
				if (entity.getId().equals(storedEntity.getId())) {
					found = true;
				}
			assertTrue(found);
		}
	}

	@Test
	void testGetEnterprise() throws EntityNotFoundException {
		EnterpriseEntity enterpriseEntity = enterpriseList.get(0);
		EnterpriseEntity resultEntity = enterpriseService.getEnterprise(enterpriseEntity.getId());
		assertNotNull(resultEntity);
		assertEquals(enterpriseEntity.getId(), resultEntity.getId());
		assertEquals(enterpriseEntity.getCalendar(), resultEntity.getCalendar());
		assertEquals(enterpriseEntity.getMail(), resultEntity.getMail());
		assertEquals(enterpriseEntity.getPassword(), resultEntity.getPassword());
		assertEquals(enterpriseEntity.getPosts(), resultEntity.getPosts());
		assertEquals(enterpriseEntity.getRepresentative(), resultEntity.getRepresentative());
		assertEquals(enterpriseEntity.getTransactions(), resultEntity.getTransactions());
		assertEquals(enterpriseEntity.getUser(), resultEntity.getUser());
	}

}
