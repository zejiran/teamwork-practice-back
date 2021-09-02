package co.edu.uniandes.dse.treeking.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.treeking.repositories.ClientRepository;
import co.edu.uniandes.dse.treeking.entities.ClientEntity;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;

	/**
	 * Obtiene la lista de los registros Client
	 * @return Colección de objetos ClientEntity
	 */
	@Transactional
	public List<ClientEntity> getClients(){
		return clientRepository.findAll();
	}
}
