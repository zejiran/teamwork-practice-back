package co.edu.uniandes.dse.treeking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.entities.ActivityEntity;
import co.edu.uniandes.dse.treeking.repositories.ActivityRepository;

@Service
public class ActivityService {

	@Autowired
	ActivityRepository activityRepository;

	@Transactional
	public List<ActivityEntity> getActivities() {
		return activityRepository.findAll();
	}

}
