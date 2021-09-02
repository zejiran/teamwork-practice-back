package co.edu.uniandes.dse.treeking.entities;


import lombok.Getter;
import lombok.Setter;
import uk.co.jemos.podam.common.PodamExclude;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Getter
@Setter

public class ReviewEntity  extends BaseEntity{
    @ElementCollection
    private ArrayList<Integer> ratings;
    @OneToMany
    private ArrayList<CommentEntity> reviews;

    @PodamExclude
    @ManyToOne
    private RouteEntity review;

}
