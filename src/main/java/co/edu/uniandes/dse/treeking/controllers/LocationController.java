package co.edu.uniandes.dse.treeking.controllers;

import co.edu.uniandes.dse.treeking.dto.LocationDTO;
import co.edu.uniandes.dse.treeking.dto.LocationDetailDTO;
import co.edu.uniandes.dse.treeking.entities.LocationEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.services.LocationService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    @ResponseStatus(code= HttpStatus.OK)
    public List<LocationDTO> findAll() {
        List<LocationEntity> locations = locationService.getLocations();
        return modelMapper.map(locations, new TypeToken<List<LocationDTO>>(){}.getType());
    }

     @GetMapping(value = "/{id}")
     @ResponseStatus (code = HttpStatus.OK)
     public LocationDetailDTO findOneById(@PathVariable("id") Long id) throws EntityNotFoundException {
        LocationEntity location = locationService.getLocationById(id);
        return modelMapper.map(location, LocationDetailDTO.class);
     }
}
