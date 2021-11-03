package co.edu.uniandes.dse.treeking.services;

import java.util.List;
import java.util.Optional;

import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.exceptions.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
		log.info("Inicia proceso de consultar todos los admins");
		return adminRepository.findAll();
	}

	@Transactional
	public AdminEntity getAdmin(Long AdminId) throws EntityNotFoundException {
		log.info("Inicia proceso de consultar el libro con id = {0}", AdminId);
		Optional<AdminEntity> AdminEntity = adminRepository.findById(AdminId);
		if (AdminEntity.isEmpty())
			throw new EntityNotFoundException(ErrorMessage.ADMIN_NOT_FOUND);
		log.info("Termina proceso de consultar el libro con id = {0}", AdminId);
		return AdminEntity.get();
	}

}
