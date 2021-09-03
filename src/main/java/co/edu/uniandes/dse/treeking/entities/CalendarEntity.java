package co.edu.uniandes.dse.treeking.entities;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class CalendarEntity extends BaseEntity{
    @OneToMany(mappedBy = "quotation",fetch= FetchType.LAZY, cascade= CascadeType.PERSIST)
    private List<QuotationEntity> history = new ArrayList<>();
}
