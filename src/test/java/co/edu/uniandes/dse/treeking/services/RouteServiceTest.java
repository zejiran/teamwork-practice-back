package co.edu.uniandes.dse.treeking.services;

import co.edu.uniandes.dse.treeking.entities.RouteEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Pruebas de lógica de Route
 * @author BalaclavaAM
 *
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(RouteService.class)
class RouteServiceTest {
	
	@Autowired
	private RouteService routeService;
	
	@Autowired
	private TestEntityManager entityManager;
	
	private final PodamFactory factory = new PodamFactoryImpl();
	
	private final List<RouteEntity> listaRutas = new ArrayList<>();
	
	/**
	 * Configuración inicial del test.
	 */
	@BeforeEach
	void instalacion() {
		limpiarData();
		insertarData();
	}
	
	private void limpiarData() {
		entityManager.getEntityManager().createQuery("delete from RouteEntity");
	}
	
	private void insertarData() {
		for (int i = 0; i < 3; i++) {
			RouteEntity routeEntity = factory.manufacturePojo(RouteEntity.class);
			entityManager.persist(routeEntity);
			listaRutas.add(routeEntity);
		}
	}
	/**
	 * Test para consultar la lista de rutas
	 */
	@Test
	void testConsultaRutas() {
		List<RouteEntity> list = routeService.getRoutes();
		assertEquals(listaRutas.size(), list.size());
		for (RouteEntity entidad : list) {
			boolean encontrao = false;
			for (RouteEntity entidadGuardada : listaRutas)
				if (entidad.getId().equals(entidadGuardada.getId())) {
					encontrao = true;
				}
			assertTrue(encontrao);
		}
	}

}
