package co.edu.uniandes.dse.treeking.services;

import java.util.ArrayList;
import java.util.List;

import co.edu.uniandes.dse.treeking.entities.CalendarEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.entities.LocationEntity;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas de lógica de Location
 *
 * @author BalaclavaAM
 *
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(LocationService.class)
class LocationServiceTest {

	@Autowired
	private LocationService locationService;

	@Autowired
	private TestEntityManager entityManager;

	private PodamFactory factory = new PodamFactoryImpl();

	private List<LocationEntity> listadeLocaciones = new ArrayList<>();

	/**
	 * Configuración inicial del test.
	 */
	@BeforeEach
	void instalacion() {
		limpiarData();
		insertarData();
	}

	private void limpiarData() {
		entityManager.getEntityManager().createQuery("delete from LocationEntity");
	}

	private void insertarData() {
		for (int i = 0; i < 3; i++) {
			LocationEntity locationEntity = factory.manufacturePojo(LocationEntity.class);
			entityManager.persist(locationEntity);
			listadeLocaciones.add(locationEntity);
		}
	}

	/**
	 * Test para consultar la lista de locaciones
	 */
	@Test
	void testConsultaLocaciones() {
		List<LocationEntity> list = locationService.getLocations();
		assertEquals(listadeLocaciones.size(), list.size());
		for (LocationEntity entidad : list) {
			boolean encontrao = false;
			for (LocationEntity entidadGuardada : listadeLocaciones) {
				if (entidad.getId().equals(entidadGuardada.getId())) {
					encontrao = true;
					break;
				}
			}
			assertTrue(encontrao);
		}
	}

	@Test
	void testGetLocation() throws EntityNotFoundException {
		LocationEntity entity = listadeLocaciones.get(0);
		LocationEntity resultEntity = locationService.getLocationById(entity.getId());
		assertNotNull(resultEntity);
		assertEquals(entity.getId(), resultEntity.getId());
		assertEquals(entity.getLatitude(), resultEntity.getLatitude());
		assertEquals(entity.getLongitude(), resultEntity.getLongitude());
		assertEquals(entity.getMap(), resultEntity.getMap());
	}


}
