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

import co.edu.uniandes.dse.treeking.entities.QuotationEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(QuotationService.class)
class QuotationServiceTest {

	@Autowired
	private QuotationService quotationService;

	@Autowired
	private TestEntityManager entityManager;

	private PodamFactory factory = new PodamFactoryImpl();

	private List<QuotationEntity> quotationList = new ArrayList<>();

	@BeforeEach
	void setUp() throws Exception {
		clearData();
		insertData();
	}

	/**
	 * Limpia las tablas que están implicadas en la prueba.
	 */
	private void clearData() {
		entityManager.getEntityManager().createQuery("delete from QuotationEntity").executeUpdate();
	}

	/**
	 * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
	 */
	private void insertData() {
		for (int i = 0; i < 3; i++) {
			QuotationEntity quotationEntity = factory.manufacturePojo(QuotationEntity.class);
			entityManager.persist(quotationEntity);
			quotationList.add(quotationEntity);
		}
	}

	@Test
	void testGetQuotations() {
		List<QuotationEntity> list = quotationService.getQuotations();
		assertEquals(list.size(), quotationList.size());
	}
	
	
	@Test
	void testGetQuotation() throws EntityNotFoundException{
		QuotationEntity quotationEntity = quotationList.get(0);
		QuotationEntity quotation = quotationService.getQuotation(quotationEntity.getId());
		assertNotNull(quotation);
		assertEquals(quotation.getId(), quotationEntity.getId());
		assertEquals(quotation.getParticipants(), quotationEntity.getParticipants());
		assertEquals(quotation.getTotalCost(), quotationEntity.getTotalCost());
		assertEquals(quotation.getStatus(), quotationEntity.getStatus());
	}

}
