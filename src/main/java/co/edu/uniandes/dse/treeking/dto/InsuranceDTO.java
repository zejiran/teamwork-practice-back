package co.edu.uniandes.dse.treeking.dto;

import lombok.Data;

@Data
public class InsuranceDTO {
	private Long id;
	private String name;
	private String conditions;
	private String features;
	private Integer price;
}
