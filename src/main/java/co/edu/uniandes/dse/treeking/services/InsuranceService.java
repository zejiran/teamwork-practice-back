package co.edu.uniandes.dse.treeking.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.treeking.entities.InsuranceEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.exceptions.ErrorMessage;
import co.edu.uniandes.dse.treeking.repositories.InsuranceRepository;

@Service
public class InsuranceService {

	@Autowired
	InsuranceRepository insuranceRepository;

	/**
	 * Obtiene la lista de los registros de Insurance.
	 * 
	 * @return Colección de objetos de InsuranceEntity.
	 */
	@Transactional
	public List<InsuranceEntity> getInsurances() {
		return insuranceRepository.findAll();
	}
	
	/**
	 * Obtiene la instancia Insurance relacionada al id pasado por parametro
	 * @param insuranceId Identificador de la instancia que se quiere encontrar
	 * @return Instancia que coincide con el numero de identificador
	 * @throws EntityNotFoundException
	 */
	@Transactional
	public InsuranceEntity getInsurance(Long insuranceId) throws EntityNotFoundException{
		Optional<InsuranceEntity> insuranceEntity = insuranceRepository.findById(insuranceId);
		if (insuranceEntity.isEmpty()) {
			throw new EntityNotFoundException(ErrorMessage.INSURANCE_NOT_FOUND);
		}
		return insuranceEntity.get();
	}
}
