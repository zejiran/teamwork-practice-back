package co.edu.uniandes.dse.treeking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.entities.EnterpriseEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.exceptions.ErrorMessage;
import co.edu.uniandes.dse.treeking.repositories.EnterpriseRepository;

@Service
public class EnterpriseService {
	@Autowired
	private EnterpriseRepository enterpriseRepository;

	@Transactional
	public List<EnterpriseEntity> getEnterprises() {
		return enterpriseRepository.findAll();
	}

	/**
	 * Obtiene los datos de una instancia de Enterprise a partir de su ID.
	 *
	 * @param enterpriseId Identificador de la instancia a consultar
	 * @return Instancia de EnterpriseEntity con los datos del Enterprise
	 *         consultado.
	 */
	@Transactional
	public EnterpriseEntity getEnterprise(Long enterpriseId) throws EntityNotFoundException {
		Optional<EnterpriseEntity> enterpriseEntity = enterpriseRepository.findById(enterpriseId);
		if (enterpriseEntity.isEmpty())
			throw new EntityNotFoundException(ErrorMessage.ENTERPRISE_NOT_FOUND);
		return enterpriseEntity.get();
	}

}
