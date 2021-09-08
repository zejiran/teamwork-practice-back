package co.edu.uniandes.dse.treeking.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.treeking.entities.QuotationEntity;
import co.edu.uniandes.dse.treeking.repositories.QuotationRepository;

@Service
public class QuotationService {

	@Autowired
	QuotationRepository quotationRepository;

	/**
	 * Obtiene la lista de los registros de Quotation.
	 * 
	 * @return Colección de objetos de quotationEntity.
	 */
	@Transactional
	public List<QuotationEntity> getQuotations() {
		return quotationRepository.findAll();
	}
}
