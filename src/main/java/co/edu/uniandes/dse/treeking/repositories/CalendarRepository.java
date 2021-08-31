package co.edu.uniandes.dse.treeking.repositories;

import co.edu.uniandes.dse.treeking.entities.CalendarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarRepository extends JpaRepository<CalendarEntity, Long> {

}
