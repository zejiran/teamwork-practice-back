package co.edu.uniandes.dse.treeking.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.edu.uniandes.dse.treeking.entities.AdminEntity;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * Pruebas de lógica de Student
 *
 * @author ISIS2603
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(AdminService.class)

class AdminServiceTest {

	@Autowired
	private AdminService adminService;

	@Autowired
	private TestEntityManager entityManager;

	private PodamFactory factory = new PodamFactoryImpl();

	private List<AdminEntity> adminList = new ArrayList<>();

	@BeforeAll
	static void setUpBeforeClass() {
	}

	@BeforeEach
	void setUp() {
		clearData();
		insertData();
	}

	/**
	 * Limpia las tablas que están implicadas en la prueba.
	 */
	private void clearData() {
		entityManager.getEntityManager().createQuery("delete from AdminEntity ").executeUpdate();
	}

	/**
	 * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
	 */
	private void insertData() {
		for (int i = 0; i < 3; i++) {
			AdminEntity adminEntity = factory.manufacturePojo(AdminEntity.class);
			entityManager.persist(adminEntity);
			adminList.add(adminEntity);
		}
	}

	@Test
	void testGetAdmins() {
		List<AdminEntity> list = adminService.getAdmins();
		assertEquals(list.size(), adminList.size());

	}

	@Test
	void testGetAdmin() throws EntityNotFoundException {
		AdminEntity entity = adminList.get(0);
		AdminEntity resultEntity = adminService.getAdmin(entity.getId());
		assertNotNull(resultEntity);
		assertEquals(entity.getId(), resultEntity.getId());
		assertEquals(entity.getUser(), resultEntity.getUser());
		assertEquals(entity.getPassword(), resultEntity.getPassword());
		assertEquals(entity.getMail(), resultEntity.getMail());
	}

}
