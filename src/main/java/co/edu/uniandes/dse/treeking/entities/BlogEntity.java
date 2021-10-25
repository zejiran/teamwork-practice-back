package co.edu.uniandes.dse.treeking.entities;
import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class BlogEntity extends BaseEntity{

    @PodamExclude
    @OneToOne
    private UserEntity user;

    @OneToMany(mappedBy = "blog", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostEntity> posts;
}
