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

import co.edu.uniandes.dse.treeking.entities.UserEntity;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * Logic test of User
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(UserService.class)
class UserServiceTest {

	@Autowired
	private UserService userService;

	@Autowired
	private TestEntityManager entityManager;

	private PodamFactory factory = new PodamFactoryImpl();

	private List<UserEntity> userList = new ArrayList<>();

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
		entityManager.getEntityManager().createQuery("delete from UserEntity").executeUpdate();
	}

	/**
	 * Insert initial data to the tables.
	 */
	private void insertData() {
		for (int i = 0; i < 3; i++) {
			UserEntity userEntity = factory.manufacturePojo(UserEntity.class);
			entityManager.persist(userEntity);
			userList.add(userEntity);
		}
	}

	/**
	 * Test for getting User list.
	 */
	@Test
	void testGetUsers() {
		List<UserEntity> list = userService.getUsers();
		assertEquals(list.size(), userList.size());
	}

	/**
	 * Test for getting User.
	 */
	@Test
	void testGetUser() throws EntityNotFoundException {
		UserEntity userEntity = userList.get(0);
		UserEntity user = userService.getUser(userEntity.getId());
		assertNotNull(user);
		assertEquals(user.getId(), userEntity.getId());
		assertEquals(userEntity.getUser(), user.getUser());
		assertEquals(userEntity.getPassword(), user.getPassword());
		assertEquals(userEntity.getMail(), user.getMail());
	}

	/**
	 * Test for adding a new User.
	 */
	@Test
	void testAddUser() throws EntityNotFoundException, IllegalOperationException {
		UserEntity newEntity = factory.manufacturePojo(UserEntity.class);
		UserEntity result = userService.createUser(newEntity);
		assertNotNull(result);

		UserEntity entity = entityManager.find(UserEntity.class, result.getId());

		assertEquals(newEntity.getId(), entity.getId());
		assertEquals(newEntity.getUser(), entity.getUser());
		assertEquals(newEntity.getPassword(), entity.getPassword());
		assertEquals(newEntity.getMail(), entity.getMail());
	}
}
