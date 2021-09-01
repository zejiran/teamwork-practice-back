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
}
