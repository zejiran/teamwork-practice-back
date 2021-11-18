package co.edu.uniandes.dse.treeking.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class FilesContainerEntity extends BaseEntity {
	@ManyToMany(mappedBy = "containers", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<MultimediaEntity> files;
}
