package co.edu.uniandes.dse.treeking.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.treeking.entities.ClientEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.exceptions.ErrorMessage;
import co.edu.uniandes.dse.treeking.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;

	/**
	 * Obtiene la lista de los registros Client
	 * 
	 * @return Colección de objetos ClientEntity
	 */
	@Transactional
	public List<ClientEntity> getClients() {
		return clientRepository.findAll();
	}
	
	/**
	 * Obtiene la instancia Client asociada a clientId
	 * @param clientId Identificador de la instancia client
	 * @return Instancia Client que coincide con clientId
	 * @throws EntityNotFoundException
	 */
	@Transactional
	public ClientEntity getClient(Long clientId) throws EntityNotFoundException{
		Optional<ClientEntity> clientEntity = clientRepository.findById(clientId);
		if (clientEntity.isEmpty()) {
			throw new EntityNotFoundException(ErrorMessage.CLIENT_NOT_FOUND);
		}
		return clientEntity.get();
	}
}
