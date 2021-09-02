package co.edu.uniandes.dse.treeking.services;

import co.edu.uniandes.dse.treeking.entities.CalendarEntity;
import co.edu.uniandes.dse.treeking.repositories.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CalendarService {

    @Autowired
    CalendarRepository calendarRepository;
    /**
     * Obtiene la lista de los registros de Calendario
     */
    @Transactional
    public List<CalendarEntity> getCalendars() {
        return calendarRepository.findAll();
    }
}
