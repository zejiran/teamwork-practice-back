package co.edu.uniandes.dse.treeking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.entities.AdminEntity;
import co.edu.uniandes.dse.treeking.repositories.AdminRepository;

/**
 * Clase que implementa los servicios de la lógica de la entidad Admin.Para
 * esto, se conecta a la clase que maneja la persistencia AdminRepository.
 *
 * @author ISIS2603
 */

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepository;

	/**
	 * Obtiene la lista de los registros de Admin.
	 *
	 * @return Colección de objetos de AdminEntity.
	 */
	@Transactional
	public List<AdminEntity> getAdmins() {
		return adminRepository.findAll();
	}
}
