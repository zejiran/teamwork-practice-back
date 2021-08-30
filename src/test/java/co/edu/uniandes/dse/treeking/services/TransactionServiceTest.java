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

import co.edu.uniandes.dse.treeking.entities.TransactionEntity;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(TransactionService.class)
class TransactionServiceTest {
	
	@Autowired
	private TransactionService transactionService;

	@Autowired
	private TestEntityManager entityManager;

	private PodamFactory factory = new PodamFactoryImpl();

	private List<TransactionEntity> transactionList = new ArrayList<>();

	/**
	 * Limpia las tablas que están implicadas en la prueba.
	 */
	private void clearData() {
		entityManager.getEntityManager().createQuery("delete from EnterpriseEntity").executeUpdate();
	}

	private void insertData() {
		for (int i = 0; i < 3; i++) {
			TransactionEntity transactionEntity = factory.manufacturePojo(TransactionEntity.class);
			entityManager.persist(transactionEntity);
			transactionList.add(transactionEntity);
		}
	}

	@BeforeEach
	void setUp() throws Exception {
		clearData();
		insertData();
	}

	@Test
	void testGetPosts() {
        List<TransactionEntity> transactions = transactionService.getTransactions();
        assertEquals(transactions.size(), transactionList.size());
        
        TransactionEntity transaction1 = transactionList.get(0);
        TransactionEntity transaction2 = entityManager.find(TransactionEntity.class, transaction1.getId());
        assertEquals(transaction1.getId(), transaction2.getId());
	}

}
