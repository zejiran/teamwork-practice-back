package co.edu.uniandes.dse.treeking.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.exceptions.ErrorMessage;
import co.edu.uniandes.dse.treeking.exceptions.IllegalOperationException;
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

	/**
	 * Obtiene una instancia de Quotation asociada a determinado quotationId
	 * 
	 * @param quotationId Identificador de la instancia de Quotation
	 * @return La entidad Quotation asociada a quotationId
	 * @throws EntityNotFoundException
	 * @throws IllegalOperationException
	 */
	@Transactional
	public QuotationEntity getQuotation(Long quotationId) throws EntityNotFoundException {
		Optional<QuotationEntity> quotationEntity = quotationRepository.findById(quotationId);
		if (quotationEntity.isEmpty()) {
			throw new EntityNotFoundException(ErrorMessage.QUOTATION_NOT_FOUND);
		} else {
			return quotationEntity.get();
		}
	}
	
	/**
	 * Crea una quotation en la persistencia.
	 *
	 * @param quotationEntity La entidad que representa la quotation a persistir.
	 * @return La entidad de la quotation luego de persistirla.
	 * @throws IllegalOperationException Si la quotation a persistir ya existe.
	 */
	@Transactional
	public QuotationEntity createQuotation(QuotationEntity quotationEntity) throws IllegalOperationException {
		return quotationRepository.save(quotationEntity);
	}
}
