package co.edu.uniandes.dse.treeking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.entities.TransactionEntity;
import co.edu.uniandes.dse.treeking.repositories.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;

	@Transactional
	public List<TransactionEntity> getTransactions() {
		return transactionRepository.findAll();
	}
}
