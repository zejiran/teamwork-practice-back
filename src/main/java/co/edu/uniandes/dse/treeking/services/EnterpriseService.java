package co.edu.uniandes.dse.treeking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.entities.EnterpriseEntity;
import co.edu.uniandes.dse.treeking.repositories.EnterpriseRepository;

@Service
public class EnterpriseService {
	@Autowired
	private EnterpriseRepository enterpriseRepository;

	@Transactional
	public List<EnterpriseEntity> getEnterprises() {
		return enterpriseRepository.findAll();
	}
}
