package co.edu.uniandes.dse.treeking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.entities.TransactionEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.exceptions.ErrorMessage;
import co.edu.uniandes.dse.treeking.repositories.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	TransactionRepository transactionRepository;

	@Transactional
	public List<TransactionEntity> getTransactions() {
		return transactionRepository.findAll();
	}

	/**
	 * Obtiene los datos de una instancia de Transaction a partir de su ID.
	 *
	 * @param transactionId Identificador de la instancia a consultar
	 * @return Instancia de TransactionEntity con los datos del transaction
	 *         consultado.
	 */
	@Transactional
	public TransactionEntity getTransaction(Long transactionId) throws EntityNotFoundException {
		Optional<TransactionEntity> transactionEntity = transactionRepository.findById(transactionId);
		if (transactionEntity.isEmpty())
			throw new EntityNotFoundException(ErrorMessage.TRANSACTION_NOT_FOUND);
		return transactionEntity.get();
	}
}
