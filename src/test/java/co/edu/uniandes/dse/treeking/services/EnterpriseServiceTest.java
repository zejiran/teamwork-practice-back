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

import co.edu.uniandes.dse.treeking.entities.EnterpriseEntity;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(EnterpriseService.class)
class EnterpriseServiceTest {
	
	@Autowired
	private EnterpriseService enterpriseService;

	@Autowired
	private TestEntityManager entityManager;

	private PodamFactory factory = new PodamFactoryImpl();

	private List<EnterpriseEntity> enterpriseList = new ArrayList<>();

	/**
	 * Limpia las tablas que están implicadas en la prueba.
	 */
	private void clearData() {
		entityManager.getEntityManager().createQuery("delete from EnterpriseEntity").executeUpdate();
	}

	private void insertData() {
		for (int i = 0; i < 3; i++) {
			EnterpriseEntity enterpriseEntity = factory.manufacturePojo(EnterpriseEntity.class);
			entityManager.persist(enterpriseEntity);
			enterpriseList.add(enterpriseEntity);
		}
	}

	@BeforeEach
	void setUp() throws Exception {
		clearData();
		insertData();
	}

	@Test
	void testGetEnterprises() {
        List<EnterpriseEntity> enterprises = enterpriseService.getEnterprises();
        assertEquals(enterprises.size(), enterpriseList.size());
        
        EnterpriseEntity enterprise1 = enterpriseList.get(0);
        EnterpriseEntity enterprise2 = entityManager.find(EnterpriseEntity.class, enterprise1.getId());
        assertEquals(enterprise1.getId(), enterprise2.getId());
	}

}
