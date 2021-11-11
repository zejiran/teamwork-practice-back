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

import co.edu.uniandes.dse.treeking.entities.ComplementaryInformationEntity;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(ComplementaryInformationService.class)
class ComplementaryInformationServiceTest {

	@Autowired
	private ComplementaryInformationService complementaryInformationService;

	@Autowired
	private TestEntityManager entityManager;

	private PodamFactory factory = new PodamFactoryImpl();

	private List<ComplementaryInformationEntity> ciList = new ArrayList<>();

	@BeforeEach
	void setUp() {
		clearData();
		insertData();
	}

	/**
	 * Limpia las tablas que están implicadas en la prueba.
	 */
	private void clearData() {
		entityManager.getEntityManager().createQuery("delete from ComplementaryInformationEntity").executeUpdate();
	}

	/**
	 * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
	 */
	private void insertData() {
		for (int i = 0; i < 3; i++) {
			ComplementaryInformationEntity complementaryInformationEntity = factory
					.manufacturePojo(ComplementaryInformationEntity.class);
			entityManager.persist(complementaryInformationEntity);
			ciList.add(complementaryInformationEntity);
		}
	}

	/**
	 * Prueba para consultar la lista de ComplementaryInformation.
	 */
	@Test
	void testGetComplementaryInformations() {
		List<ComplementaryInformationEntity> list = complementaryInformationService.getComplementaryInformations();
		assertEquals(list.size(), ciList.size());
	}
	@Test
	void testGetComplementaryInformation() {
		ComplementaryInformationEntity ciEntity = ciList.get(0);
		ComplementaryInformationEntity entity = complementaryInformationService.getComplementaryInformation(ciEntity.getId());
		assertNotNull(entity);
		assertEquals(entity.getId(), ciEntity.getId());
		assertEquals(entity.getDescription(), ciEntity.getDescription());
		assertEquals(entity.getRecommendation(), ciEntity.getRecommendation());
	}

}
