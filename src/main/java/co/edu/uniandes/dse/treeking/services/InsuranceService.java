package co.edu.uniandes.dse.treeking.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.treeking.entities.InsuranceEntity;
import co.edu.uniandes.dse.treeking.repositories.InsuranceRepository;

@Service
public class InsuranceService {

	@Autowired
	InsuranceRepository insuranceRepository;
	
	/**
     * Obtiene la lista de los registros de Insurance.
     * @return Colección de objetos de InsuranceEntity.
     */
    @Transactional
    public List<InsuranceEntity> getInsurances() {
            return insuranceRepository.findAll();
    }
}
