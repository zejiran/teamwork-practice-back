package co.edu.uniandes.dse.treeking.entities;


import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter

public class ReviewEntity  extends BaseEntity{
    @ElementCollection
    private List<Integer> ratings;
    @OneToMany
    private List<CommentEntity> reviews;

    @PodamExclude
    @ManyToOne
    private RouteEntity review;

}
