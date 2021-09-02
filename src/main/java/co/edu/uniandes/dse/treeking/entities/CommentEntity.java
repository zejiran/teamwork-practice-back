package co.edu.uniandes.dse.treeking.entities;

import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
@Getter
@Setter
public class CommentEntity extends BaseEntity{
    private String text;
    @PodamExclude
    @OneToMany(mappedBy = "comment", fetch = FetchType.LAZY)
    private List<CommentEntity> repleis;

}
