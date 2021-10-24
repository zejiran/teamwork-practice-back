package co.edu.uniandes.dse.treeking.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniandes.dse.treeking.dto.ActivityDTO;
import co.edu.uniandes.dse.treeking.dto.ItineraryDTO;

import co.edu.uniandes.dse.treeking.entities.ItineraryEntity;

import co.edu.uniandes.dse.treeking.services.ItineraryService;

@RestController
@RequestMapping("/itineraries")
public class ItineraryController {

	@Autowired
    private ItineraryService itineraryService;

    @Autowired
    private ModelMapper modelMapper;

    
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<ActivityDTO> findAll() {
            List<ItineraryEntity> itineraries = itineraryService.getItineries();
            return modelMapper.map(itineraries, new TypeToken<List<ItineraryDTO>>() {
            }.getType());
    }
}
