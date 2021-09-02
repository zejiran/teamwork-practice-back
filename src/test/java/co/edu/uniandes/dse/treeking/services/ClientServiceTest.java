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

import co.edu.uniandes.dse.treeking.entities.ClientEntity;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(ClientService.class)
class ClientServiceTest {

	private PodamFactory factory = new PodamFactoryImpl();

	private List<ClientEntity> clientList = new ArrayList<>();

	@Autowired
	private ClientService clientService;

	@Autowired
	private TestEntityManager entityManager;

	@BeforeEach
	void setUp() throws Exception {
		clearData();
		insertData();
	}

	/**
     * Limpia las tablas que están implicadas en la prueba.
     */
	private void clearData(){
        entityManager.getEntityManager().createQuery("delete from ClientEntity").executeUpdate();
	}

	/**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     */
	private void insertData() {
        for (int i = 0; i < 3; i++) {
                ClientEntity clientEntity = factory.manufacturePojo(ClientEntity.class);
                entityManager.persist(clientEntity);
                clientList.add(clientEntity);
        }
	}

	/**
	 * Prueba para consultar la lista de Client
	 */
	@Test
	void testGetClients() {
		List<ClientEntity> list = clientService.getClients();
		assertEquals(list.size(), clientList.size());
	}

}