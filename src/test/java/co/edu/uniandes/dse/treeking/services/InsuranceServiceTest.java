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

import co.edu.uniandes.dse.treeking.entities.InsuranceEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.exceptions.IllegalOperationException;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(InsuranceService.class)
class InsuranceServiceTest {

	@Autowired
	private InsuranceService insuranceService;

	@Autowired
	private TestEntityManager entityManager;

	private PodamFactory factory = new PodamFactoryImpl();

	private List<InsuranceEntity> insuranceList = new ArrayList<>();

	@BeforeEach
	void setUp() throws Exception {
		clearData();
		insertData();
	}

	/**
	 * Limpia las tablas que están implicadas en la prueba.
	 */
	private void clearData() {
		entityManager.getEntityManager().createQuery("delete from InsuranceEntity").executeUpdate();
	}

	/**
	 * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
	 */
	private void insertData() {
		for (int i = 0; i < 3; i++) {
			InsuranceEntity insuranceEntity = factory.manufacturePojo(InsuranceEntity.class);
			entityManager.persist(insuranceEntity);
			insuranceList.add(insuranceEntity);
		}
	}

	/**
	 * Prueba para consultar la lista de Insurance.
	 */
	@Test
	void testGetInsurances() {
		List<InsuranceEntity> list = insuranceService.getInsurances();
		assertEquals(list.size(), insuranceList.size());
	}

	@Test
	void testGetInsurance() throws EntityNotFoundException {
		InsuranceEntity insuranceEntity = insuranceList.get(0);
		InsuranceEntity insurance = insuranceService.getInsurance(insuranceEntity.getId());
		assertNotNull(insurance);
		assertEquals(insuranceEntity.getId(), insurance.getId());
		assertEquals(insuranceEntity.getFeatures(), insurance.getFeatures());
		assertEquals(insuranceEntity.getConditions(), insurance.getConditions());
		assertEquals(insuranceEntity.getName(), insurance.getName());
		assertEquals(insuranceEntity.getPrice(), insurance.getPrice());
	}
	
	@Test
	void testCreateInsurance() throws EntityNotFoundException, IllegalOperationException {
		InsuranceEntity newEntity = factory.manufacturePojo(InsuranceEntity.class);
		InsuranceEntity result = insuranceService.createInsurance(newEntity);
		assertNotNull(result);

		InsuranceEntity entity = entityManager.find(InsuranceEntity.class, result.getId());

		assertEquals(newEntity.getId(), entity.getId());
		assertEquals(newEntity.getFeatures(), entity.getFeatures());
		assertEquals(newEntity.getConditions(), entity.getConditions());
		assertEquals(newEntity.getName(), entity.getName());
		assertEquals(newEntity.getPrice(), entity.getPrice());
	}
}
