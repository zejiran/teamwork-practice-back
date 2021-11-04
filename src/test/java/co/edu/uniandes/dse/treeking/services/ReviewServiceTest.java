package co.edu.uniandes.dse.treeking.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import co.edu.uniandes.dse.treeking.entities.ReviewEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.edu.uniandes.dse.treeking.entities.ReviewEntity;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * Pruebas de lógica de Review
 *
 * @author ISIS2603
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(ReviewService.class)
class ReviewServiceTest {

	@Autowired
	private ReviewService reviewService;

	@Autowired
	private TestEntityManager entityManager;

	private PodamFactory factory = new PodamFactoryImpl();

	private List<ReviewEntity> reviewList = new ArrayList<>();

	/**
	 * Configuración inicial de la prueba.
	 */
	@BeforeEach
	void setUp() {
		clearData();
		insertData();
	}

	/**
	 * Limpia las tablas que están implicadas en la prueba.
	 */
	private void clearData() {
		entityManager.getEntityManager().createQuery("delete from ReviewEntity").executeUpdate();
	}

	/**
	 * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
	 */
	private void insertData() {
		for (int i = 0; i < 3; i++) {
			ReviewEntity ReviewEntity = factory.manufacturePojo(ReviewEntity.class);
			entityManager.persist(ReviewEntity);
			reviewList.add(ReviewEntity);
		}
	}

	/**
	 * Prueba para consultar la lista de Review.
	 */
	@Test
	void testGetReviews() {
		List<ReviewEntity> list = reviewService.getReviews();
		assertEquals(list.size(), reviewList.size());

	}

	@Test
	void testGetReview() throws EntityNotFoundException {
		ReviewEntity entity = reviewList.get(0);
		ReviewEntity resultEntity = reviewService.getReview(entity.getId());
		assertNotNull(resultEntity);
		assertEquals(entity.getId(), resultEntity.getId());
		assertEquals(entity.getScore(), resultEntity.getScore());
		assertEquals(entity.getRoute(), resultEntity.getRoute());
	}

}