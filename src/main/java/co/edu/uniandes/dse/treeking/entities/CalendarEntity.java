package co.edu.uniandes.dse.treeking.entities;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Setter
@Getter
@Entity
public class CalendarEntity extends BaseEntity{
    /*
      no existe quotation entity x ahora :(
    @ManyToOne
    private QuotationEntity history;
    */
}
