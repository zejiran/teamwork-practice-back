package co.edu.uniandes.dse.treeking.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class CalendarEntity extends BaseEntity {
	@OneToMany(mappedBy = "quotation", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<QuotationEntity> history = new ArrayList<>();
}
