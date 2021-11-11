package co.edu.uniandes.dse.treeking.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PersonDetailDTO extends PersonDTO {
	private String idNumber;
	private String idType;
	private String address;
}
