package co.edu.uniandes.dse.treeking.controllers;

import co.edu.uniandes.dse.treeking.dto.CalendarDTO;
import co.edu.uniandes.dse.treeking.dto.CalendarDetailDTO;
import co.edu.uniandes.dse.treeking.entities.CalendarEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.services.CalendarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendars")
public class CalendarController {

    @Autowired
    private CalendarService calendarService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<CalendarDTO> findAll(){
        List<CalendarEntity> calendars = calendarService.getCalendars();
        return modelMapper.map(calendars, new TypeToken<List<CalendarDTO>>(){}.getType());
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public CalendarDetailDTO findOneById(@PathVariable("id") Long id) throws EntityNotFoundException{
        CalendarEntity calendar = calendarService.getCalendarById(id);
        return modelMapper.map(calendar, CalendarDetailDTO.class);
    }
}
