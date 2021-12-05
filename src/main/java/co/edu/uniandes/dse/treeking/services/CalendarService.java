package co.edu.uniandes.dse.treeking.services;

import java.util.List;
import java.util.Optional;

import co.edu.uniandes.dse.treeking.entities.LocationEntity;
import co.edu.uniandes.dse.treeking.entities.RouteEntity;
import co.edu.uniandes.dse.treeking.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.treeking.exceptions.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.treeking.entities.CalendarEntity;
import co.edu.uniandes.dse.treeking.repositories.CalendarRepository;

@Slf4j
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

	public CalendarEntity getCalendarById(Long id) throws EntityNotFoundException {
		Optional<CalendarEntity> calendarEntity = calendarRepository.findById(id);
		if (calendarEntity.isEmpty()) {
			throw new EntityNotFoundException(ErrorMessage.ROUTE_NOT_FOUND);
		}
		return calendarEntity.get();
	}

	@Transactional
	public CalendarEntity createCalendar(CalendarEntity calendar) {
		log.info("Inicia proceso de creación del calendar");
		return calendarRepository.save(calendar);
	}


}
