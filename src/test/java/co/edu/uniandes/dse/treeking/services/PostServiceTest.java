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

import co.edu.uniandes.dse.treeking.entities.PostEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(PostService.class)
class PostServiceTest {

	@Autowired
	private PostService postService;

	@Autowired
	private TestEntityManager entityManager;

	private PodamFactory factory = new PodamFactoryImpl();

	private List<PostEntity> postList = new ArrayList<>();

	/**
	 * Limpia las tablas que están implicadas en la prueba.
	 */
	private void clearData() {
		entityManager.getEntityManager().createQuery("delete from PostEntity").executeUpdate();
	}

	private void insertData() {
		for (int i = 0; i < 3; i++) {
			PostEntity postEntity = factory.manufacturePojo(PostEntity.class);
			entityManager.persist(postEntity);
			postList.add(postEntity);
		}
	}

	@BeforeEach
	void setUp() throws Exception {
		clearData();
		insertData();
	}

	@Test
	void testGetPosts() {
		List<PostEntity> posts = postService.getPosts();
		assertEquals(postList.size(), posts.size());

		for (PostEntity entity : posts) {
			boolean found = false;
			for (PostEntity storedEntity : postList)
				if (entity.getId().equals(storedEntity.getId())) {
					found = true;
				}
			assertTrue(found);
		}
	}
	
	@Test
	void testGetPost() throws EntityNotFoundException {
		PostEntity postEntity = postList.get(0);
		PostEntity resultEntity = postService.getPost(postEntity.getId());
		assertNotNull(resultEntity);
		assertEquals(postEntity.getId(), resultEntity.getId());
		assertEquals(postEntity.getBlog(), resultEntity.getBlog());
	}

}
