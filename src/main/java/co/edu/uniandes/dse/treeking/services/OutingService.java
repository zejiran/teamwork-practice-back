package co.edu.uniandes.dse.treeking.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.treeking.entities.OutingEntity;
import co.edu.uniandes.dse.treeking.repositories.OutingRepository;

@Service
public class OutingService {
	
	@Autowired
	OutingRepository outingRepository;
	
	/**
     * Obtiene la lista de los registros de Outing.
     * @return Colección de objetos de outingEntity.
     */
    @Transactional
    public List<OutingEntity> getOutings() {
            return outingRepository.findAll();
    }
}
