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

import co.edu.uniandes.dse.treeking.entities.ActivityEntity;
import co.edu.uniandes.dse.treeking.entities.ItineraryEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.exceptions.IllegalOperationException;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(ItineraryService.class)

class ItineraryServiceTest {

	@Autowired
	private ItineraryService itineraryService;

	@Autowired
	private TestEntityManager entityManager;

	private PodamFactory factory = new PodamFactoryImpl();

	private List<ItineraryEntity> itineraryList = new ArrayList<>();

	@BeforeEach
	void setUp() throws Exception {
		clearData();
		insertData();
	}

	@Test
	void testGetItineries() {
		List<ItineraryEntity> list = itineraryService.getItineries();
		assertEquals(list.size(), itineraryList.size());
	}
	
	@Test
	void testGetItinerary() throws EntityNotFoundException {
		ItineraryEntity itineraryEntity = itineraryList.get(0);
		ItineraryEntity entity = itineraryService.getItinerary(itineraryEntity.getId());
		assertNotNull(entity);
		assertEquals(itineraryEntity.getId(), entity.getId());
		assertEquals(itineraryEntity.getLodging(), entity.getLodging());
		assertEquals(itineraryEntity.getTransportation(), itineraryEntity.getTransportation());
	}
	
	@Test
	void testCreateItinerary() throws IllegalOperationException {
		ItineraryEntity newEntity = factory.manufacturePojo(ItineraryEntity.class);
		ItineraryEntity result = itineraryService.createItinerary(newEntity);
		assertNotNull(result);

		ItineraryEntity entity = entityManager.find(ItineraryEntity.class, result.getId());

		assertEquals(newEntity.getId(), entity.getId());
		assertEquals(newEntity.getLodging(), entity.getLodging());
		assertEquals(newEntity.getTransportation(), entity.getTransportation());

	}

	private void clearData() {
		entityManager.getEntityManager().createQuery("delete from ItineraryEntity").executeUpdate();
	}

	/**
	 * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
	 */
	private void insertData() {
		for (int i = 0; i < 3; i++) {
			ItineraryEntity itineraryEntity = factory.manufacturePojo(ItineraryEntity.class);
			entityManager.persist(itineraryEntity);
			itineraryList.add(itineraryEntity);
		}
	}
}
