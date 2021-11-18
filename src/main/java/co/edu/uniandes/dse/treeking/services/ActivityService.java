package co.edu.uniandes.dse.treeking.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.entities.ActivityEntity;
import co.edu.uniandes.dse.treeking.exceptions.ErrorMessage;
import co.edu.uniandes.dse.treeking.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.treeking.repositories.ActivityRepository;


@Service
public class ActivityService {

	@Autowired
	ActivityRepository activityRepository;

	@Transactional
	public List<ActivityEntity> getActivities() {
		return activityRepository.findAll();
	}

	@Transactional
	public ActivityEntity getActivity(Long id) throws EntityNotFoundException {
		ActivityEntity activity = activityRepository.findById(id).orElse(null);
		if (activity == null) {
			throw new EntityNotFoundException(ErrorMessage.ACTIVITY_NOT_FOUND);
		}
		return activity;
	}
	
	@Transactional
	public ActivityEntity createActivity(ActivityEntity activity) throws IllegalOperationException {
		return activityRepository.save(activity);
	}
	
	
}
