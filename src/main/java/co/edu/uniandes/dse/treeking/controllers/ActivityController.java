package co.edu.uniandes.dse.treeking.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniandes.dse.treeking.dto.ActivityDTO;
import co.edu.uniandes.dse.treeking.entities.ActivityEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.services.ActivityService;

@RestController
@RequestMapping("/activities")
public class ActivityController {

	@Autowired
    private ActivityService activityService;

    @Autowired
    private ModelMapper modelMapper;

    
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<ActivityDTO> findAll() {
            List<ActivityEntity> activities = activityService.getActivities();
            return modelMapper.map(activities, new TypeToken<List<ActivityDTO>>() {
            }.getType());
    }

    @GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ActivityDTO findOne(@PathVariable("id") Long id) throws EntityNotFoundException {
		ActivityEntity activityEntity = activityService.getActivity(id);
		return modelMapper.map(activityEntity, ActivityDTO.class);
	}

}
