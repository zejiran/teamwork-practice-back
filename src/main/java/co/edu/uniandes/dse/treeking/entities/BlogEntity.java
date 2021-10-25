package co.edu.uniandes.dse.treeking.entities;
import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Getter
@Setter
public class BlogEntity extends BaseEntity{

    @PodamExclude
    @OneToOne
    private UserEntity user;

    @OneToMany(mappedBy = "blog")
    private List<PostEntity> posts;
}
