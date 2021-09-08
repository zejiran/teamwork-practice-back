package co.edu.uniandes.dse.treeking.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class CalendarDetailDTO extends CalendarDTO {
    private List<QuotationDTO> history;
}
